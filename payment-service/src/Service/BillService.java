package Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import Entity.Bill;
import Entity.Bill.Provider;
import Entity.Bill.State;
import Entity.Bill.Type;
import Entity.Customer;

public class BillService implements IBillService{

	@Override
	public void deleteBill(Customer customer, Bill bill) {
		List<Bill> currentBillList = customer.getBills();
		currentBillList.remove(bill);
	}

	@Override
	public Bill updateBill(Bill bill, int updateId, Type updateType, long updateAmount, Date updateDueDate,
			State updateState, Provider updateProvider) {
		bill.setId(updateId);
		bill.setType(updateType);
		bill.setAmount(updateAmount);
		bill.setDueDate(updateDueDate);
		bill.setState(updateState);
		bill.setProvider(updateProvider);
		
		return null;
	}

	@Override
	public String viewBillInfo(Bill bill) {
		return bill.toString();
	}

	@Override
	public List<Bill> searchBillByType(Type type, Customer customer) {
		List<Bill> currentBillList = customer.getBills();
		
		return currentBillList.stream().filter(bill -> bill.getType().equals(type)).collect(Collectors.toList());
	}

	@Override
	public List<Bill> getListBillDueDate(Customer customer) {
		long millis=System.currentTimeMillis();  
		Date currentDate = new Date(millis);
		List<Bill> currentBillList = customer.getBills();
		
		return currentBillList.stream().filter(bill -> bill.getDueDate().before(currentDate)).collect(Collectors.toList());
	}
	
	

}
