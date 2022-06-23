package sbnz.integracija.example.model;

import java.util.List;

public class BookDto {
	private Book book;
	private List<Comment> comments;
	
	
	
	
	public BookDto(Book book, List<Comment> comments) {
		super();
		this.book = book;
		this.comments = comments;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
