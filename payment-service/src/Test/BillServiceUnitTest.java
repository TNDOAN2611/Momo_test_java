package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import Entity.Bill;
import Entity.Customer;
import Entity.Bill.Provider;
import Entity.Bill.State;
import Entity.Bill.Type;
import Service.BillService;
import Service.IBillService;

public class BillServiceUnitTest {

	private static Customer customer;
	private static Bill electricBill;
	private static Bill waterBill;

	//object under test
	private IBillService billService = new BillService();
	
	
	@BeforeClass
	public static void initializeDataTest() {
		//should use mockito instead, for personal mockito issue, I can not use it in this test
		customer = new Customer("Tom");
		customer.setBalance(1000000);
		electricBill = new Bill(0, Type.ELECTRIC, 200000, new Date(2020, 10, 25), State.NOT_PAID, Provider.EVN_HCMC);
		waterBill = new Bill(1, Type.WATER, 175000, new Date(2020, 10, 30), State.NOT_PAID, Provider.SAVICO_HCMC);
		List<Bill> customerBills = new ArrayList<>();
		customerBills.add(electricBill);
		customerBills.add(waterBill);
		
		customer.setBills(customerBills);
	}
	
	@Test
	public void deleteBillWhenBillExistInCustomerBill() {
		assertTrue((customer.getBills().contains(electricBill)));

		billService.deleteBill(customer, electricBill);
		
		assertFalse((customer.getBills().contains(electricBill)));
	}
	
	@Test
	public void searchBillByTypeWhenTypeBillExistInCustomnerBill() {
		assertEquals(Arrays.asList(waterBill), billService.searchBillByType(Type.WATER, customer));
	}
	
	@Test
	public void searchBillByTypeWhenTypeBillDoNotExistInCustomnerBill() {
		assertEquals(Collections.emptyList(), billService.searchBillByType(Type.INTERNET, customer));
	}
}
