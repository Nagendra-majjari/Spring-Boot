package in.nagendra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nagendra.entity.User;
import in.nagendra.service.EmailService;
import in.nagendra.service.UserService;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	// open user form
	@GetMapping("/")
	public String loadForm(Model model) {
		User userObj = new User();

		model.addAttribute("user", userObj);

		return "form";
	}

	// to save the user and to send email to the registered user
	@PostMapping("/user")
	public String handleForm(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "form";
		}

		boolean isSaved = userService.saveData(user);

		if (isSaved) {
			model.addAttribute("smsg", "User saved");

			boolean emailSent = emailService.sendEmail(user.getEmail(), "Welcome to Ashok IT!",
					"Hello " + user.getName() + ",\n\nThank you for registering with us!");

			if (emailSent) {
				model.addAttribute("emailStatus", "Email sent successfully!");
			} else {
				model.addAttribute("emailStatus", "Email could not be sent ??");
			}
		} else {
			model.addAttribute("emsg", "User is not saved");
		}

		return "form";
	}

	// handle view-user page display
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<User> allUsers = userService.getAllUsers();

		model.addAttribute("users", allUsers);
		return "users";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam("uid") Integer uid, Model model) {

		User user = userService.getUserById(uid);

		model.addAttribute("user", user);

		return "form";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("uid") Integer uid, Model model) {

		boolean isDeleted = userService.deleteUser(uid);

		if (isDeleted) {
			model.addAttribute("smsg", "User Deleted");
			List<User> allUsers = userService.getAllUsers();
			model.addAttribute("smsg", allUsers);

		} else {

			model.addAttribute("emsg", "User not deleted");
		}
		return "redirect:/users";
	}

}
