package sbnz.integracija.example.event;

import java.time.LocalDate;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;



@Role(Role.Type.EVENT)
@Expires("30d")
public class CancelOrderEvent {

	private int customerId;
	private int orderId;
	private int seen = 0;
	private LocalDate date;
	
	public CancelOrderEvent()
	{
		this.date = LocalDate.now();
	}
	
	public CancelOrderEvent(int customerId, int orderId)
	{
		this.customerId = customerId;
		this.orderId = orderId;
		this.seen = 0;
		this.date = LocalDate.now();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
