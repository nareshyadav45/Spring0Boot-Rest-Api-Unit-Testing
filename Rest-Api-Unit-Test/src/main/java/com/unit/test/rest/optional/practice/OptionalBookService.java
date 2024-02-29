package com.unit.test.rest.optional.practice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unit.test.rest.entities.Book;
import com.unit.test.rest.optional.practice.exception.userNotFoundException;
import com.unit.test.rest.repositories.BookRepository;

@Service
public class OptionalBookService {

	@Autowired
	private BookRepository repository;
	
	public Optional<Book> findBookById(Long id) throws userNotFoundException  {
		Optional<Book> book = repository.findById(id);
		if(book.isEmpty()) {
			//throw new userNotFoundException("With given Id Book Not Found!! : "+id);
			book.orElseThrow(()-> new userNotFoundException("With Givenn Id User Not found  :"+id));
		}
		System.out.println("book find with given id");
		return book;
	}
}
