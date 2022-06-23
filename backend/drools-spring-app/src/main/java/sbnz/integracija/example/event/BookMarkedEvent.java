package sbnz.integracija.example.event;

import java.time.LocalDate;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;



@Role(Role.Type.EVENT)
@Expires("30d")
public class BookMarkedEvent {
	private LocalDate date;
	private int bookId;
	private int userId;
	private double mark;
	public BookMarkedEvent(int bookId,int userId ,double mark) {
		super();
		this.date = LocalDate.now();
		this.bookId = bookId;
		this.mark = mark;
		this.userId = userId;
	}
	public BookMarkedEvent() {
		super();
		this.date = LocalDate.now();
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate occurred) {
		this.date = occurred;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
