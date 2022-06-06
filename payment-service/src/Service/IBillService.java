package Service;

import java.util.Date;
import java.util.List;

import Entity.Bill;
import Entity.Customer;
import Entity.Bill.Provider;
import Entity.Bill.State;
import Entity.Bill.Type;

public interface IBillService {
	void deleteBill(Customer customer, Bill bill);
	Bill updateBill(Bill bill, int updateId, Type updateType, long updateAmount, Date updateDueDate, State updateState, Provider updateProvider);
	String viewBillInfo(Bill bill);
	List<Bill> searchBillByType(Type type, Customer customer);
	List<Bill> getListBillDueDate(Customer customer);
}
