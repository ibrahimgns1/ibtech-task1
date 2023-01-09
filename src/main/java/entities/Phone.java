package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone extends BaseEntity {
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "phone_number")
  private String phoneNumber;

  public Phone() {}

  public Phone(Long id, Customer customer, String phoneNumber) {
    super(id);
    this.customer = customer;
    this.phoneNumber = phoneNumber;
  }
  public Phone( Customer customer, String phoneNumber) {
	    
	    this.customer = customer;
	    this.phoneNumber = phoneNumber;
	  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
      throw new IllegalArgumentException("Phone number cannot be null or empty.");
    }
    this.phoneNumber = phoneNumber;
  }

  public String getFormattedPhoneNumber() {
    
    return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
  }
}
