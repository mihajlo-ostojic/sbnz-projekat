package sbnz.integracija.example.event;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import sbnz.integracija.example.model.Order;

@Role(Role.Type.EVENT)
@Expires("30d")
public class OrderDeliveredEvent {

	private int customerId;
	private Order order;
	
	public OrderDeliveredEvent()
	{
		
	}

	public OrderDeliveredEvent(int customerId, Order order) {
		super();
		this.customerId = customerId;
		this.order = order;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
