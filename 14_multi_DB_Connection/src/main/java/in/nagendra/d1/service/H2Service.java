package in.nagendra.d1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.d1.entity.H2Entity;
import in.nagendra.d1.repository.H2Repository;

@Service
public class H2Service {

	@Autowired
	private H2Repository h2Repository;

	public void saveMySQLData() {

		H2Entity h = new H2Entity();
		h.setName("nagendra");
		h.setGender("male");
		h.setPlace("Kadapa");
		h2Repository.save(h);
	}
}