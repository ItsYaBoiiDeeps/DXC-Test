package com.deeps.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deeps.bookstore.model.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
