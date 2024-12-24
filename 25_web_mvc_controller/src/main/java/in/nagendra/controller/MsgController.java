package in.nagendra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/msg")
public class MsgController {
	
	
	@GetMapping("/demo")
	@ResponseBody
	public String demoMessage() {
		return "Going to Hyderabad";
	}
	
	@GetMapping("/great")
	public String greatings(Model model) {
		String msg ="Good Morning To All,Welcome to AshokIT";
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg","Weloce to AshokIT");
		
		mav.setViewName("index");
		
		return mav;
	}

}
