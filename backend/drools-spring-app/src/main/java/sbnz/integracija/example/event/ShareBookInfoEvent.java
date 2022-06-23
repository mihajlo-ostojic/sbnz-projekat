package sbnz.integracija.example.event;

import java.time.LocalDate;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import sbnz.integracija.example.model.Book;



@Role(Role.Type.EVENT)
@Expires("30d")
public class ShareBookInfoEvent {

	private int customerId;
	private Book book;
	private LocalDate date;
	
	public ShareBookInfoEvent()
	{
		
	}

	public ShareBookInfoEvent(int customerId, Book book, LocalDate date) {
		super();
		this.customerId = customerId;
		this.book = book;
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate orderDate) {
		this.date = orderDate;
	}
	
	
}
