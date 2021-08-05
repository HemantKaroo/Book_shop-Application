package com.my_shop;

public class Book {
	private String name;
	private String author;
	private float price;
	private String publisher;
	private int stock;
	
	Book(String name,String author,float price,String publisher,int stock){
		this.name=name;
		this.author=author;
		this.price=price;
		this.publisher=publisher;
		this.stock=stock;
	}
	Book(){
		super();
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public float getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getStock() {
		return stock;
	}
	
	public String toString() {
		return "Book [ name= "+name+" author= "+author+" price= "+price+" publisher= "+publisher+" stock= "+stock+" ]";
	}

}
