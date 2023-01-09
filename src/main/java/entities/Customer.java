package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "email")
  private String email;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Address> addresses;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Phone> phones;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Account> accounts;

  public Customer() {}

  public Customer(Long id, String name, String surname, String email) {
    super(id);
    this.name = name;
    this.surname = surname;
    this.email = email;
  }
  public Customer(String name, String surname, String email) {
	    this.name = name;
	    this.surname = surname;
	    this.email = email;
	  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    if (surname == null || surname.trim().isEmpty()) {
      throw new IllegalArgumentException("Surname cannot be null or empty.");
    }
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
	    if (email == null || email.trim().isEmpty()) {
	      throw new IllegalArgumentException("Email cannot be null or empty.");
	    }
	    this.email = email;
	  }

	  public List<Address> getAddresses() {
	    return addresses;
	  }

	  public void setAddresses(List<Address> addresses) {
	    this.addresses = addresses;
	  }

	  public List<Phone> getPhones() {
	    return phones;
	  }

	  public void setPhones(List<Phone> phones) {
	    this.phones = phones;
	  }

	  public List<Account> getAccounts() {
	    return accounts;
	  }

	  public void setAccounts(List<Account> accounts) {
	    this.accounts = accounts;
	  }

	  public String getFullName() {
	    return name + " " + surname;
	  }
	}

   
