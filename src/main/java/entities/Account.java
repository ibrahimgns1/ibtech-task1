package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account extends BaseEntity {
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "balance")
  private double balance;

  public Account() {}

  public Account(Long id, Customer customer, double balance) {
    super(id);
    this.customer = customer;
    this.balance = balance;
  }
  public Account( Customer customer, double d) {
	    
	    this.customer = customer;
	    this.balance = d;
	  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    if (customer == null) {
      throw new IllegalArgumentException("Customer cannot be null.");
    }
    this.customer = customer;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be negative.");
    }
    this.balance = balance;
  }

  public void addToBalance(BigDecimal amount) {
    if (amount.signum() < 0) {
      throw new IllegalArgumentException("Amount cannot be negative.");
    }
    balance += balance;
  }

  public void subtractFromBalance(BigDecimal amount) {
    if (amount.signum() < 0) {
      throw new IllegalArgumentException("Amount cannot be negative.");
    }
    balance -= balance;
  }
}
