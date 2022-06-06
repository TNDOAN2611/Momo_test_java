package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Entity.Bill;
import Entity.Customer;
import Entity.Bill.Provider;
import Entity.Bill.State;
import Entity.Bill.Type;
import Service.IPaymentService;
import Service.PaymentService;

public class PaymentServiceUnitTest {

	private static Customer customer;
	private static Bill electricBill;
	
	//object under test
	private IPaymentService paymentService = new PaymentService();
	
	
	@BeforeClass
	public static void initializeDataTest() {
		//should use mockito instead, for personal mockito issue, I can not use it
		customer = new Customer("Tom");
		customer.setBalance(1000000);
		electricBill = new Bill(0, Type.ELECTRIC, 200000, new Date(2020, 10, 25), State.NOT_PAID, Provider.EVN_HCMC);
		
		List<Bill> customerBills = new ArrayList<>();
		customerBills.add(electricBill);
		
		customer.setBills(customerBills);
	}
	
	
	@Test
	public void payForOneBillWhenBillAmountLowerThanBalance() {
		long balance = customer.getBalance() - electricBill.getAmount();
		String expected = "Payment has been completed for Bill with id: " +  electricBill.getId() +  "\n" + "Your current balance is:" +  balance;
		assertEquals(expected, paymentService.payForOneBill(electricBill.getId(), customer));
	}
	
	@Test
	public void payForOneBillWhenBillAmountGreaterThanBalance() {
		electricBill.setAmount(1000005);
		String expected = "Sorry! Not enough fund to proceed with payment.";
		assertEquals(expected, paymentService.payForOneBill(electricBill.getId(), customer));
	}
	
	@Test
	public void payForOneBillWhenBillDoesNotExist() {
		String expected = "Sorry! Not found a bill with such id";
		assertEquals(expected, paymentService.payForOneBill(10, customer));
	}
	
	@After
	public void resetValue() {
		customer.setBalance(1000000);
		electricBill.setAmount(200000);
	}
	
}
