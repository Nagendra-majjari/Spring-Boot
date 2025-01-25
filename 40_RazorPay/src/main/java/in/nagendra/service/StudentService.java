package in.nagendra.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import in.nagendra.dto.StudentOrder;
import in.nagendra.repo.StudentOrderRepo;

@Service
public class StudentService {

	@Autowired
	private StudentOrderRepo studentRepo;

	@Value("${razorpay.key.id}")
	private String razorPayKey;

	@Value("${razorpay.secret.key}")
	private String razorPaySecret;

	public RazorpayClient client;

	public StudentOrder createOrder(StudentOrder stuOrder) throws Exception {

		JSONObject orderReq = new JSONObject();
		
		orderReq.put("amount", stuOrder.getAmount() *100); //amount in paisa
		orderReq.put("currency", "INR");
		orderReq.put("receipt", stuOrder.getEmail());
		
		
		this.client = new RazorpayClient(razorPayKey,razorPaySecret);
		
		//create order in razorpay
		Order razorPayOrder = client.orders.create(orderReq);
		
		
		System.out.println(razorPayOrder);
		
		stuOrder.setRazorpayOrderId(razorPayOrder.get("id"));
		stuOrder.setOrderStatus(razorPayOrder.get("status"));
		
		
		studentRepo.save(stuOrder);
		
		return stuOrder;
	}
	
	
	public StudentOrder updateOrder(Map<String ,String> responsePayLoad) {
		
		String responsePayOrderId = responsePayLoad.get("razorpay_order_id"); 
		
		StudentOrder order = studentRepo.findByRazorpayOrderId(responsePayOrderId);
		
		order.setOrderStatus("PAYMENT_COMPLETED");
		
		StudentOrder updatedOrder = studentRepo.save(order);
		
		//send email
		
		return updatedOrder;
	}

}





























