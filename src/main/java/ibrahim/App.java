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
    // Create the SessionFactory from hibernate.cfg.xml
    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    // Create a new customer
    Customer customer = new Customer("İbrahim", "Güneş", "ibrahim.gunes@ibtech.com.tr");
    // Create a new address
    Address address = new Address(customer, "Pendik", "İstanbul", "IST", "12345");
    // Create a new phone
    Phone phone = new Phone(customer, "123-456-7890");
    // Create a new account
    Account account = new Account(customer, 1000.00);

    // Save the customer, address, phone, and account to the database
    Session session = factory.getCurrentSession();
    session.beginTransaction();
    session.save(customer);
    session.save(address);
    session.save(phone);
    session.save(account);
    session.getTransaction().commit();

    // Update the customer's email
    session = factory.getCurrentSession();
    session.beginTransaction();
    customer = session.get(Customer.class, customer.getId());
    customer.setEmail("changed@example.com");
    session.getTransaction().commit();

    
    System.out.println("Entitiy saved to database.");
    	
    // Clean up
    factory.close();
  }
}

