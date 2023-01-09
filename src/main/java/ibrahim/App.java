package ibrahim;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Account;
import entities.Address;
import entities.Customer;
import entities.Phone;





public class App {
  public static void main(String[] args) {
	  UserDatabaseOperation db = new UserDatabaseOperation(getSessionFactory().openSession());

	  // Create a new customer
	  Customer customer = new Customer("İbrahim", "Güneş", "ibrahim.gunes@ibtech.com.tr");
	  // Create a new address
	  Address address = new Address(customer, "cadde", "istanbul", "IST", "12345");
	  // Create a new phone
	  Phone phone = new Phone(customer, "111-111-111");
	  // Create a new account
	  Account account = new Account(customer, 1000.00);
	  
	  // Save the customer to the database
	  customer.addAccount(account);
	  customer.addPhone(phone);
	  customer.addAddress(address);
	  db.createEntity(customer);
	  
	  // Read the customer from the database
	  
	  System.out.println("Read customer: " + customer.getFullName());

	  // Update the customer
	  customer.setName("new name");
	  db.updateEntity(customer);

	  // Delete the customer
	  // db.deleteEntity(customer);
	}
  private static SessionFactory getSessionFactory() {
	    // Set up the configuration and build the SessionFactory
	    Configuration config = new Configuration();
	    config.configure("hibernate.cfg.xml");
	    return config.buildSessionFactory();
	  }
  }


