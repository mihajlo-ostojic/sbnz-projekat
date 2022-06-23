package sbnz.integracija.example.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sbnz.integracija.example.facts.User;



@Component
@Scope("singleton")
public class UserStore {
	private List<User> allUsers;

	public UserStore() {
		super();
		this.allUsers = new ArrayList<User>();
	}
	
	public boolean addUser(User newUser) {
		User foundUser = getUser(newUser.getUsername());
		if(foundUser!=null)
			return false;
		
		this.allUsers.add(newUser);
		return true;
		
	}
	
	public User getUser(String username) {
		for (User user : this.allUsers) {
			if(user.getUsername().equals(username)==true)
			{
				return user;
			}
		}
		return null;
	}
	
	public User getUser(int id) {
		for (User user : this.allUsers) {
			if(user.getCustomerId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	public Collection<User> getAllUsers()
	{
		return this.allUsers;
	}
	
	
}
