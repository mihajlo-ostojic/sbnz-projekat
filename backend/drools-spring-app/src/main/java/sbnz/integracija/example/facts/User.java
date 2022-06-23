package sbnz.integracija.example.facts;

import java.io.Serializable;
import java.util.Objects;

import sbnz.integracija.example.model.Gender;


public class User implements Serializable {

	    private static final long serialVersionUID = 2L;

	    public int userId;
	    private Integer age;
	    private String username;
	    private String email;
	    private Gender gender;
	    private UserCategory category = UserCategory.NA;
	    private boolean member;
	    private double points;
	    
	    public User() {
	    	member = false;
	    }
	    
	    

	    public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public int getCustomerId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	    
	    public int getUserId() {
	        return this.userId;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }


	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    

	    public double getPoints() {
			return points;
		}

		public void setPoints(double points) {
			this.points = points;
		}
		
		public void removePoints(double points) {
			this.points = this.points - points;
			if(this.points <=0)
				this.points = 0;
		}
		
		public void addPoints(double points) {
			this.points = this.points + points;
		}
		
		

		public UserCategory getCategory() {
	        return category;
	    }

	    public void setCategory(UserCategory category) {
	        this.category = category;
	    }
	    
	    

	   

		public boolean getMember() {
			return member;
		}

		public void setMember(boolean member) {
			this.member = member;
		}
		

		public Gender getGender() {
			return gender;
		}



		public void setGender(Gender gender) {
			this.gender = gender;
		}



		@Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 67 * hash + Objects.hashCode(this.userId);
	        hash = 67 * hash + Objects.hashCode(this.age);
	        hash = 67 * hash + Objects.hashCode(this.email);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final User other = (User) obj;
	        if (!Objects.equals(this.userId, other.userId)) {
	            return false;
	        }
	        if (!Objects.equals(this.age, other.age)) {
	            return false;
	        }
	        if (!Objects.equals(this.email, other.email)) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "User{" + "id=" + userId + ", username=" + username + ", gender=" + gender
	                + ", age=" + age + ", points=" + points + ", email=" + email + ", member=" + member + ", category=" + category + '}';
	    }
	    
	    public int remove = 0;
	    public int add = 0;
	    public int shared = 0;

		public int getRemove() {
			return remove;
		}



		public void setRemove(int remove) {
			this.removePoints(remove);
			this.remove = remove;
		}



		public int getAdd() {
			return add;
		}



		public void setAdd(int add) {
			this.addPoints(add);
			this.add = add;
		}



		public int getShared() {
			return shared;
		}



		public void addShared(int shared) {
			this.addPoints(shared);
			this.shared = shared;
		} 
	    
}
