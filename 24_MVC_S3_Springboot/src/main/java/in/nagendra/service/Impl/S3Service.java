package in.nagendra.service.Impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Service
public class S3Service {

    private final AmazonS3 s3Client;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    // Constructor-based dependency injection
    public S3Service(@Value("${cloud.aws.region.static}") String region,
                     @Value("${cloud.aws.s3.bucket}") String bucketName,
                     @Value("${cloud.aws.credentials.access-key}") String accessKey,
                     @Value("${cloud.aws.credentials.secret-key}") String secretKey) {
        this.region = region;
        this.bucketName = bucketName;
        this.accessKey = accessKey;
        this.secretKey = secretKey;

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        // Generate a unique file name to avoid overwriting
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        
        // Upload the file to the S3 bucket
        s3Client.putObject(bucketName, fileName, file.getInputStream(), null);
        
        // Return the file URL
        return s3Client.getUrl(bucketName, fileName).toString();
    }
}
