package in.nagendra.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.nagendra.entity.Student;

public interface StudentService {
	
	
	
	boolean saveStudent(Student student, MultipartFile resume);
		
    public List<Student> getAllStudents();
	
	public boolean deleteUser(Integer sid);

    public Student getUserById(Integer sid);

	//void sendEmail(String email, String name);

}
