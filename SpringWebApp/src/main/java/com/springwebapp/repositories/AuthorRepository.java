package com.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springwebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
