package sbnz.integracija.example.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sbnz.integracija.example.model.Book;

@Component
@Scope("singleton")
public class RecomendationsModule implements Serializable{

	 	private Map<String, Collection<Book>> allUsersRecomendations;

	    public RecomendationsModule() {
	    	allUsersRecomendations = new HashMap<>();
	    }

	    public void updateRecommendations(String username, Collection<Book> newRecommendations) {
	    	System.out.println("username:" + username);
	    	System.out.println("velicina je:" + newRecommendations.size());
	    	allUsersRecomendations.put(username, newRecommendations);
	    }
	    
	    public Collection<Book> getRecomendation(String username)
	    {
	    	return allUsersRecomendations.get(username);
	    }

	    public static List<Book> getBestRecomendations(List<Book> books)
	    {
	    	return  (List<Book>) books.stream()
	                .sorted((a, b) -> {
	                    Book aBook = (Book) a;
	                    Book bBook = (Book) b;
	                    return (int) (bBook.getAverageMark() - aBook.getAverageMark());
	                })
	                .limit(5)
	                .collect(Collectors.toList());
	    	
	    }
}
