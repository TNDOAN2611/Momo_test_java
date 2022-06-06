package Entity;

import java.util.Date;

public class Bill {

	private int id;
	private Type type;
	private long amount;
	private Date dueDate;
	private State state;
	private Provider provider;
	
	public Bill(int id, Type type, long amount, Date dueDate, State state, Provider provider) {
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.dueDate = dueDate;
		this.state = state;
		this.provider = provider;
	}
	
	public enum Type {
	    ELECTRIC,
	    WATER,
	    INTERNET
	  }
	
	public enum State {
	    NOT_PAID,
	    PAID
	  }
	
	public enum Provider {
	    EVN_HCMC,
	    SAVICO_HCMC,
	    VNPT
	  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	@Override
	public String toString() {
		return "Bill with id: " + id + " type: " + type + " amount: " + amount + " duedate: " + dueDate + " state: " + state + " provider: " + provider;
	}
}
