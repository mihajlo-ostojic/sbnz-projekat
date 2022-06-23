package sbnz.integracija.example.model;

import java.util.Collection;

public class RecomendationsDTO {
	
	 private Collection<Book> books;

	public RecomendationsDTO(Collection<Book> books) {
		super();
		this.books = books;
	}

	public RecomendationsDTO() {
		super();
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	 
	 
}
