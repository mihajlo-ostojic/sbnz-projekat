package sbnz.integracija.example.model;

import java.io.Serializable;

public class OrderLine implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Book book;
    private int quantity;
    
    public OrderLine() {
    }
    
    
    
    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "OrderLine [book=" + book + ", quantity=" + quantity + "]";
    }
    
    

}
