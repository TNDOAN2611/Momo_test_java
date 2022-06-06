package Service;

import java.util.ArrayList;
import java.util.List;

import Entity.Bill;
import Entity.Bill.State;
import Entity.Customer;

public class PaymentService implements IPaymentService{

	@Override
	public String payForOneBill(int billId, Customer customer) {
		List<Bill> currentBills = customer.getBills();
		for(Bill bill : currentBills) {
			if(bill.getId() == billId) {
				if(bill.getAmount() <= customer.getBalance()) {
					customer.setBalance(customer.getBalance() - bill.getAmount());
					bill.setState(State.PAID);
					return "Payment has been completed for Bill with id: " +  billId +  "\n" + "Your current balance is:" +  customer.getBalance();
				}
				else {
					return "Sorry! Not enough fund to proceed with payment.";
				}
			}
		}
		
		return "Sorry! Not found a bill with such id";
	}

	@Override
	public String payForMultipleBill(List<Integer> billIdList, Customer customer) {
		List<Bill> currentBills = customer.getBills();
		long totalAmount = 0;
		List<Bill> willBePaidBill = new ArrayList<>();
		for(Bill bill : currentBills) {
			for(Integer billId : billIdList) {
				if(bill.getId() == billId) {
					totalAmount += bill.getAmount();
					willBePaidBill.add(bill);
				}
			}
		}
		if(totalAmount <= customer.getBalance()) {
			customer.setBalance(customer.getBalance() - totalAmount);
			willBePaidBill.forEach(bill -> bill.setState(State.PAID));
			return "Payment has been completed for Bills with id: " +  billIdList +  "\n" + "Your current balance is:" +  customer.getBalance();
		}
		else {
			return "Sorry! Not enough fund to proceed with payment.";
		}
	}
	

}
