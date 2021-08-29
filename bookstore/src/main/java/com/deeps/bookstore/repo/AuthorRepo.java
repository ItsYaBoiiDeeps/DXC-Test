package com.deeps.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deeps.bookstore.model.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {

}
