package local.java.model;

import java.util.Collection;

public class Customer {

	private String firstName;
	private String lastName;
	private Account account;
	private Collection<Order> orders;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, Account account, Collection<Order> orders) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.account = account;
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", account=" + account + ", orders="
				+ orders + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}

}
