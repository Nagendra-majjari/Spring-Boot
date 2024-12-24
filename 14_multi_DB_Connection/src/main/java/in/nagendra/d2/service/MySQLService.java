package in.nagendra.d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.d2.entity.MySQLEntity;
import in.nagendra.d2.repository.MySQLRepository;

@Service
public class MySQLService {
	
	
	@Autowired
	private  MySQLRepository mysqlRepository;
	
	
	public void saveH2data() {
        MySQLEntity m = new MySQLEntity();
            m.setName("nagaiah");
            m.setGender("female");
            m.setPlace("Hyderabad");

        mysqlRepository.save(m);
	}
}
