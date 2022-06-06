package Service;

import Entity.Customer;

public class CustomerService implements ICustomerService{

	@Override
	public void addFundToAccount(Customer customer, long amount) {
		long currentBalance = customer.getBalance();
		customer.setBalance(currentBalance + amount); 
	}
}
