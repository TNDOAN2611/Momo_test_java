package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.Bill;
import Entity.Bill.Provider;
import Entity.Bill.State;
import Entity.Bill.Type;
import Entity.Customer;
import Service.CustomerService;
import Service.ICustomerService;
import Service.IPaymentService;
import Service.PaymentService;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer("Tom");
		Bill electricBill = new Bill(0, Type.ELECTRIC, 200000, new Date(2020, 10, 25), State.NOT_PAID, Provider.EVN_HCMC);
		Bill waterBill = new Bill(1, Type.WATER, 175000, new Date(2020, 10, 30), State.NOT_PAID, Provider.SAVICO_HCMC);
		Bill internetBill = new Bill(2, Type.INTERNET, 800000, new Date(2020, 11, 30), State.NOT_PAID, Provider.VNPT);
		
		List<Bill> customerBills = new ArrayList<>();
		customerBills.add(electricBill);
		customerBills.add(waterBill);
		customerBills.add(internetBill);
		
		customer.setBills(customerBills);
		
		ICustomerService customerService = new CustomerService();
		customerService.addFundToAccount(customer, 1000000);
		
		System.out.println("Current balance: "+ customer.getBalance());
		
		customer.getBills().forEach(bill -> System.out.println(bill.toString()));
		
		IPaymentService paymentService = new PaymentService();
		System.out.println(paymentService.payForOneBill(0, customer));
		
		List<Integer> billIdList = new ArrayList<>();
		billIdList.add(1);
		billIdList.add(2);
		System.out.println(paymentService.payForMultipleBill(billIdList, customer));
	}
}
