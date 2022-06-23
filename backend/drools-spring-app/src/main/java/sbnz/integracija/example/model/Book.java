package sbnz.integracija.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public enum BindingType {
		HARDCOVER,PAPERBACK
    };
	private int bookId;
	private String name;
	private int authorId;
	private int yearOfPublication;
	private String description;
	private String category;
	private double averageMark;
	private String alphabet;
	private BindingType bindingType;
	private double cost;
    private double salePrice;
    private List<Double> allMarks = new ArrayList<Double>();
	
	public Book() {
		super();
	}
	
	public Book(int bookId, String name, int authorId, int yearOfPublication, String description, String category,
			double averageMark, String alphabet, BindingType bindingType, double cost, double salePrice,
			List<Double> allMarks) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.authorId = authorId;
		this.yearOfPublication = yearOfPublication;
		this.description = description;
		this.category = category;
		this.averageMark = averageMark;
		this.alphabet = alphabet;
		this.bindingType = bindingType;
		this.cost = cost;
		this.salePrice = salePrice;
		this.allMarks = allMarks;
	}



	public Book(int id, String name, double cost, double salePrice) {
        this.bookId = id;
		this.name = name;
        this.cost = cost;
        this.salePrice = salePrice;
    }

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAverageMark() {
		if(this.allMarks.size()==0)
			return 0;
		double sum = 0;
		for (Double double1 : allMarks) {
			sum += double1;
		}
		return sum/this.allMarks.size();
	}

	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	public BindingType getBindingType() {
		return bindingType;
	}

	public void setBindingType(BindingType bindingType) {
		this.bindingType = bindingType;
	}
	
	public void addMark(double newMark)
	{
		this.allMarks.add(newMark);
	}

}
