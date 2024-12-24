package in.nagendra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private CustomRepo customrepo;

    // Save customer if not exists
    public void saveCustomerIfNotExists(Customer customer) {
        // Only check for existence if ID is not null
        if (customer.getId() != null) {
            Optional<Customer> existingCustomer = customrepo.findById(customer.getId());
            if (existingCustomer.isPresent()) {
                // Handle the duplicate case 
                System.out.println("Customer with ID " + customer.getId() + " already exists.");
                return;
            }
        }

        // Save the customer, ID will be generated by the CustomIdGenerator
        customrepo.save(customer);
    }

    public void dataIns() {
        Customer c1 = new Customer();
        c1.setName("nagendra");
        c1.setState("AP");
        saveCustomerIfNotExists(c1);

        Customer c2 = new Customer();
        c2.setName("ramya");
        c2.setState("AP");
        saveCustomerIfNotExists(c2);

        Customer c3 = new Customer();
        c3.setName("sreeja");
        c3.setState("MP");
        saveCustomerIfNotExists(c3);
    }
}
