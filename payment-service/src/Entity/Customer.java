package Entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private long balance;
	private List<Bill> bills;
	
	public Customer(String name) {
		this.name = name;
		balance = 0;
		bills = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
}
