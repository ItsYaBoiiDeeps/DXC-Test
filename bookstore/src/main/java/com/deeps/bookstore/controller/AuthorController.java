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

import com.deeps.bookstore.model.Author;
import com.deeps.bookstore.repo.AuthorRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/author/")
public class AuthorController {

	@Autowired
	private AuthorRepo ath;

	// RETRIEVE ALL BOOKS
	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return ath.findAll();
	}

	// THIS IS TO CREATE
	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return ath.save(author);
	}

	// THIS IS TO RETRIEVE SPECIFICALLY
	@GetMapping("/authors/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
		Author author = ath.findById(id).orElseThrow();
		return ResponseEntity.ok(author);
	}

	// THIS IS TO UPDATE BY ID
	@PutMapping("/authors/{id}")
	public ResponseEntity<Author> updateBook(@PathVariable Integer id, @RequestBody Author authorDetails) {
		Author author = ath.findById(id).orElseThrow();
		author.setAuthorName(authorDetails.getAuthorName());
		Author updatedAuthor = ath.save(author);
		return ResponseEntity.ok(updatedAuthor);
	}

	// THIS IS TO DELETE BY ID
	@DeleteMapping("/authors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAuthor(@PathVariable Integer id) {
		Author author = ath.findById(id).orElseThrow();
		ath.delete(author);
		Map<String, Boolean> response = new HashMap();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
