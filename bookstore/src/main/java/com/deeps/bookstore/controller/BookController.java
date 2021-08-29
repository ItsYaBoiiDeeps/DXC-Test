package com.deeps.bookstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deeps.bookstore.model.Book;
import com.deeps.bookstore.repo.BookRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/book/")
public class BookController {

	@Autowired
	private BookRepo bk;

	// RETRIEVE ALL BOOKS
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bk.findAll();
	}

	// THIS IS TO CREATE
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bk.save(book);
	}

	// THIS IS TO RETRIEVE SPECIFICALLY
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getEmployeeById(@PathVariable Integer id) {
		Book book = bk.findById(id).orElseThrow();
		return ResponseEntity.ok(book);
	}

	// THIS IS TO UPDATE BY ID
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
		Book book = bk.findById(id).orElseThrow();
		book.setBookIsbn(bookDetails.getBookIsbn());
		book.setBookTitle(bookDetails.getBookTitle());
		book.setBookYear(bookDetails.getBookYear());
		book.setBookPrice(bookDetails.getBookPrice());
		Book updatedBook = bk.save(book);
		return ResponseEntity.ok(book);
	}

	
	// THIS IS TO DELETE BY ID
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
		Book employee = bk.findById(id).orElseThrow();
		bk.delete(employee);
		Map<String, Boolean> response = new HashMap();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
}
}
