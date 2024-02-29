package com.unit.test.rest.optional.practice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unit.test.rest.entities.Book;
import com.unit.test.rest.optional.practice.exception.userNotFoundException;

@RestController
public class OptionalRestController {
	
	@Autowired
	private OptionalBookService bookService;
	
	@GetMapping("/findBook/{id}")
	public ResponseEntity<Optional<Book>> findBookById(@PathVariable("id") Long id) throws userNotFoundException{
		Optional<Book> bookById = this.bookService.findBookById(id);
		return new ResponseEntity<Optional<Book>>(bookById,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lenghtOfName")
	public Integer lenghtOfName(@RequestBody Book book) {
		String title = book.getTitle();
		//int lenght =(title!=null)?title.length():0;
		Optional<String> optional = Optional.ofNullable(title);
		Integer lenght = optional.map(String::length).orElse(1);
	
		return (Integer) lenght;
		
	}

}
