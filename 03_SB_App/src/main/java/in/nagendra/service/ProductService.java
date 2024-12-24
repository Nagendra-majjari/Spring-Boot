package in.nagendra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.dao.ProductDao;

@Service
public class ProductService {
    @Autowired
	private ProductDao dao;
	
	/*
	 * @Autowired 
	 * public void setDao(ProductDao dao) {
	 * System.out.println("Setter injection :: Setter");
	 *  this.dao = dao;
	 *   }
	 */

	//null pointer Exception
    /*
	 * public ProductService() { System.out.println(" no param - Constructor....");
	 * this.dao = dao; }
	 */



	public ProductService(ProductDao dao) {
		System.out.println("  param - Constructor....");
		this.dao = dao;
	}



	public void saveProduct() {
		dao.saveProduct();
		
	}
}
