package sbnz.integracija.example.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
	    	allUsersRecomendations.put(username, newRecommendations);
	    }

}
