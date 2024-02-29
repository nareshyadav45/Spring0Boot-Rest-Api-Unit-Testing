package com.unit.rest.test.beans;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

//@Entity
//@Builder
//@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bookName;
	private double priceOfBook;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPriceOfBook() {
		return priceOfBook;
	}
	public void setPriceOfBook(double priceOfBook) {
		this.priceOfBook = priceOfBook;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String bookName, double priceOfBook) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.priceOfBook = priceOfBook;
	}
	public Book(int id2) {
		// TODO Auto-generated constructor stub
	}
	  
	
	

}
