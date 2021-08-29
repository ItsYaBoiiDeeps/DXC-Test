package com.deeps.bookstore.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Author")
public class Author {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int authorId;
	
	@Column(name="authorName")
	private String authorName;
	
	@ManyToOne
	@JoinColumn(name="bookId")
	@JsonBackReference
	private Book book;
	

	public Author() {
		super();
	}

	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public Author(int authorId, String authorName, Book book) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.book = book;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	

	
	

}
