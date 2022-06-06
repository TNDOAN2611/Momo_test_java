package Service;

import Entity.Customer;

public interface ICustomerService {
	void addFundToAccount(Customer customer, long amount);
}
