package in.nagendra.service;

public interface EmailService {
    

	boolean sendEmail(String email, String subject, String message);
}
