package Service;

import java.util.List;

import Entity.Customer;

public interface IPaymentService {

	String payForOneBill(int billId, Customer customer);
	String payForMultipleBill(List<Integer> billIdList, Customer customer);
	
}
