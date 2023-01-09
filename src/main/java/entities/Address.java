package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "street")
  private String street;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "zip_code")
  private String zipCode;

  public Address() {}

  public Address(Long id, Customer customer, String street, String city, String state, String zipCode) {
    super(id);
    this.customer = customer;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }
  public Address( Customer customer, String street, String city, String state, String zipCode) {
	    
	    this.customer = customer;
	    this.street = street;
	    this.city = city;
	    this.state = state;
	    this.zipCode = zipCode;
	  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    if (street == null || street.trim().isEmpty()) {
      throw new IllegalArgumentException("Street cannot be null or empty.");
    }
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    if (city == null || city.trim().isEmpty()) {
      throw new IllegalArgumentException("City cannot be null or empty.");
    }
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    if (state == null || state.trim().isEmpty()) {
      throw new IllegalArgumentException("State cannot be null or empty.");
    }
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    if (zipCode == null || zipCode.trim().isEmpty()) {
      throw new IllegalArgumentException("Zip code cannot be null or empty.");
    }
    this.zipCode = zipCode;
  }

  public String getFormattedAddress() {
	    return street + ", " + city + ", " + state + " " + zipCode;
	  }
	}

