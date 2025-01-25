package in.nagendra.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.nagendra.dto.StudentOrder;
import in.nagendra.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@PostMapping(value="/order",produces="application/json")
	@ResponseBody
	public ResponseEntity<StudentOrder> createOrder(@RequestBody StudentOrder studentOrder) throws Exception{
		
		StudentOrder createOrder = service.createOrder(studentOrder);
		
		return new ResponseEntity<>(createOrder,HttpStatus.CREATED);
	}
	
	@PostMapping("/handle-payment-callback")
	public String handlePaymentCallback(@RequestParam Map<String ,String> respPayLoad) {
		
		System.out.println(respPayLoad);
		
		service.updateOrder(respPayLoad);
		
		return "success";
		
	}
	

}
















