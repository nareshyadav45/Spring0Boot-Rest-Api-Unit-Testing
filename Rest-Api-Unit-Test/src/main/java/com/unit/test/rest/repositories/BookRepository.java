package com.unit.test.rest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unit.test.rest.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitleContaining(String name);

}