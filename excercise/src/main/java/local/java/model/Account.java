package local.java.model;

import java.util.UUID;

public class Account {

	private UUID id;
	private Double balance;

	public Account() {
		super();
	}

	public Account(UUID id, Double balance) {
		this.id = id;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
