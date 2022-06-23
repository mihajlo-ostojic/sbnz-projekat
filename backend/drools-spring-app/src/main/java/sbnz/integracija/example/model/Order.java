package sbnz.integracija.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sbnz.integracija.example.facts.User;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private int orderId;
    private Date date;
    private User user;
    private int userId;
    
    private List<OrderLine> orderLines = new ArrayList<>();
    private Discount discount;
    private double delivery;
    
    public Order() {
    	this.delivery = 0;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }
    
    
    

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public double getDelivery() {
		return delivery;
	}

	public void setDelivery(double delivery) {
		this.delivery = delivery;
	}

	public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setItems(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    
    public double getTotal() {
        return this.getOrderLines().stream()
                .mapToDouble(item -> item.getBook().getSalePrice() * item.getQuantity())
                .sum();
    }
    
    public int getTotalItems() {
        return this.getOrderLines().stream()
                .mapToInt(item -> item.getQuantity())
                .sum();
    }
    
    
    
    
    
    public void increaseDiscount(double increase) {
        if (discount == null) {
            discount = new Discount(0.0);
        }
        discount.setPercentage(discount.getPercentage() + increase);
    }

    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((orderLines == null) ? 0 : orderLines.hashCode());
		return result;
	}

	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", user=" + user + ", orderLines=" + orderLines
				+ ", discount=" + discount + "]";
	}
    
    

  
}
