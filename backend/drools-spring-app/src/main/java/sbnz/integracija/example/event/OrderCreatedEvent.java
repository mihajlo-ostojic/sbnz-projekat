package sbnz.integracija.example.event;


import java.time.LocalDate;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import sbnz.integracija.example.model.Order;


@Role(Role.Type.EVENT)
@Expires("30d")
public class OrderCreatedEvent {

	private int customerId;
	private Order order;
	private LocalDate orderDate;
	private int seen = 0;
	public OrderCreatedEvent()
	{
		
		this.orderDate = LocalDate.now();
	}

	public OrderCreatedEvent(int customerId, Order order, LocalDate orderDate) {
		super();
		this.customerId = customerId;
		this.order = order;
		this.orderDate = orderDate;
	}
	
	public OrderCreatedEvent(int customerId, Order order) {
		super();
		this.customerId = customerId;
		this.order = order;
		this.orderDate = LocalDate.now();
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

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}
	
}
