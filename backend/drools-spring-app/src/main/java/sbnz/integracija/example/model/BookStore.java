package sbnz.integracija.example.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sbnz.integracija.example.model.Book;


@Component
@Scope("singleton")
public class BookStore {

	private List<Book> allBooks;

	public BookStore() {
		super();
		this.allBooks = new ArrayList<Book>();
	}
	
	public boolean addBook(Book newBook) {
		Book foundBook = getBook(newBook.getBookId());
		if(foundBook!=null)
			return false;
		
		this.allBooks.add(newBook);
		return true;
		
	}
	
	public Book getBook(int bookId) {
		for (Book book : this.allBooks) {
			if(book.getBookId()==bookId)
			{
				return book;
			}
		}
		return null;
	}
	
	public Collection<Book> getAllBooks()
	{
		return this.allBooks;
	}

}
