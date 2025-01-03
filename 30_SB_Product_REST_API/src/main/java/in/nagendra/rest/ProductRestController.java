package in.nagendra.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nagendra.bindings.Product;

@RestController
public class ProductRestController {
	
	@PutMapping(
		     value="/product",
		     consumes="application/json",//In which format taking the data
		     produces="text/plain"       //In which format giving the record
    )
    public ResponseEntity<String> updateProduct(@RequestBody Product p){
	
	    System.out.println(p);
	
	    //logic to update product
	
	    String msg = "Product Updated";
	
	    return new ResponseEntity<String>(msg,HttpStatus.OK);//status code ----->> 200
	
    }
	
	@DeleteMapping(
			       value="/product/{pid}",
			       produces="text/text"
    )
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pid){
		
		//logic to delete
		
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}
	
	@PostMapping(
			     value="/product",
			     consumes="application/json",//In which format taking the data
			     produces="text/plain"       //In which format giving the record
    )
	public ResponseEntity<String> addProduct(@RequestBody Product p){
		
		System.out.println(p);
		
		//logic to save product
		
		String msg = "Product Saved";
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);//status code ----->> 201
		
	}
	
	

	
	@GetMapping(
			    value="/product",
			    produces={"application/json","application/xml",}
    )
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid) {

		Product p = new Product(pid, "Mouse", 12000.00);
		
		return new ResponseEntity<Product>(p,HttpStatus.OK) ;//status code is 200..
	}
	@GetMapping(
			    value="/products",
			    produces="application/json"
	)
	public ResponseEntity<List<Product>> getProducts(){
		Product p1 = new Product(1,"nagendra",122000.00);
		Product p2 = new Product(2,"sreeja",120000.00);
		Product p3 = new Product(3,"nagaiah",132000.00);
		
		List<Product> plist = Arrays.asList(p1,p2,p3);
		
		return new ResponseEntity<List<Product>>(plist,HttpStatus.OK);
		
	}

}
