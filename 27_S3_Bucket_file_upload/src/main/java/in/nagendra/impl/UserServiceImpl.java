package in.nagendra.impl;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import software.amazon.awssdk.services.s3.S3Client;
import com.amazonaws.services.s3.AmazonS3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.nagendra.entity.User;
import in.nagendra.repo.UserRepo;
import in.nagendra.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private S3Client s3Client;

	@Autowired
	private AmazonS3 amazonS3;

	@Override
	public boolean saveData(User user) {

		User save = userRepo.save(user);
		return save != null;
	}

	@Override
	public List<User> getData() {

		List<User> all = userRepo.findAll();
		return all;
	}

	@Override
	public boolean updateData(Integer id, User user) {

		if (userRepo.existsById(id)) {
			userRepo.save(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteData(Integer id) {

		if (userRepo.existsById(id))

		{
			userRepo.deleteById(id);

			return true;
		}

		else

			return false;
		
	}

	@Override
	public User showData(Integer id) {
		User userById = userRepo.getUserById(id);

		return userById;

	}

	@Override
	public void sendEmail(String to, String subject, String text) throws MessagingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setFrom("nagendramajjari51@gmail.com");

		mimeMessageHelper.setTo(to);

		mimeMessageHelper.setSubject(subject);

		mimeMessageHelper.setText(text, true);

		mailSender.send(mimeMessage);

	}

	@Override
	public boolean uploadFile(MultipartFile file, String bucketName, User user) throws Exception {

		String fileName = file.getOriginalFilename();

		InputStream inputStream = file.getInputStream();

		PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(fileName).build();

		s3Client.putObject(putObjectRequest,
				software.amazon.awssdk.core.sync.RequestBody.fromInputStream(inputStream, file.getSize()));

		String a = amazonS3.getUrl(bucketName, fileName).toString();

		user.setFileUrl(a);

		userRepo.save(user);

		return true;
	}

}
