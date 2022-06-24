package sbnz.integracija.example.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sbnz.integracija.example.facts.User;

@Component
@Scope("singleton")
public class OrderStore {

	private List<Order> allOrders;
	private int lastId = 0;

	public OrderStore() {
		super();
		this.allOrders = new ArrayList<Order>();
		this.lastId = 0;
	}
	
	public Order addOrder(Order newOrder) {
		this.lastId++;
		newOrder.setOrderId(this.lastId);
		
		allOrders.add(newOrder);
		return newOrder;
	}
	
	public Order getOrder(int id) {
		for (Order o : this.allOrders) {
			if(o.getOrderId() == id)
			{
				return o;
			}
		}
		return null;
	}
	
	public List<Order> getOrdersByUser(int userId)
	{
		System.out.println("Id korisnika: " + userId);
		List<Order> allFound = new ArrayList<Order>();
		for (Order o : this.allOrders) {
			System.out.println("order id koji se poredi: " + o.getUserId());
			if(o.getUserId() == userId)
			{
				allFound.add(o);
			}
		}
		
		return allFound;
	}

	public List<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(List<Order> allOrders) {
		this.allOrders = allOrders;
	}
	
	
	
	
}
