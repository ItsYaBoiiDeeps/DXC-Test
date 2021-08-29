package com.deeps.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int bookId;
	
	@Column(name="bookIsbn", unique=true)
	private int bookIsbn;
	
	@Column(name="bookTitle")
	private String bookTitle;
	
	@Column(name="bookYear")
	private int bookYear;
	
	@Column(name="bookPrice")
	private double bookPrice;
	
	@OneToMany(mappedBy="book", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Author> author;

	public Book() {
		super();
	}
	

	public Book(int bookId, int bookIsbn, String bookTitle, int bookYear, int bookPrice, List<Author> author) {
		super();
		this.bookId = bookId;
		this.bookIsbn = bookIsbn;
		this.bookTitle = bookTitle;
		this.bookYear = bookYear;
		this.bookPrice = bookPrice;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public List<Author> getAuthor() {
		return author;
	}


	public void setAuthor(List<Author> author) {
		this.author = author;
	}



	public int getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(int bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getBookYear() {
		return bookYear;
	}

	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}


	
	
	
	

}
