package com.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springwebapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
