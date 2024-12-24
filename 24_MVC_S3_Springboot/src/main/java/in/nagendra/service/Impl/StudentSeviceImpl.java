package in.nagendra.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.nagendra.entity.Student;
import in.nagendra.repo.StudentRepo;
import in.nagendra.service.StudentService;

@Service
public class StudentSeviceImpl implements StudentService {

	@Autowired
    private StudentRepo studentRepo;

    @Autowired
    private S3Service s3Service;


    @Override
    public boolean saveStudent(Student student, MultipartFile resume) {
        if (student == null) {
            throw new IllegalArgumentException("Student object cannot be null");
        }
        try {
            if (resume != null && !resume.isEmpty()) {
                // Upload the resume to S3 and get the file URL
                String fileUrl = s3Service.uploadFile(resume);
                student.setResumeUrl(fileUrl);  // Save the file URL in the student entity
            }
            Student savedStudent = studentRepo.save(student);
            return savedStudent != null && savedStudent.getSid() != null;
        } catch (IOException e) {
            throw new RuntimeException("Error uploading file to S3", e);
        }
    }


	@Override
	public List<Student> getAllStudents() {
		List<Student> allStudents = studentRepo.findAll();
		return allStudents;
	}

	@Override
	public boolean deleteUser(Integer sid) {
		if (sid == null) {
	        throw new IllegalArgumentException("Student ID cannot be null");
	    }
		if (studentRepo.existsById(sid)) {
			studentRepo.deleteById(sid);
			return true;
		}
		return false;
	}

	@Override
	public Student getUserById(Integer sid) {
	    Optional<Student> byId = studentRepo.findById(sid);
	    return byId.orElse(null); 
	}

}
