package com.unit.rest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unit.rest.test.beans.Book;
import com.unit.rest.test.service.BookService;

@RestController
public class BookRestController<T> {
	
	@Autowired
	private BookService bookService;

	@PostMapping("/addBook")
	public ResponseEntity<String> addBookApi(@RequestBody Book book){
		Boolean addBook = this.bookService.addBook(book);
		if(addBook){
			return new ResponseEntity<String>("Book Svaed Successfully",HttpStatus.CREATED);
			
		}else {
		return new ResponseEntity<String>("Book not saved!!",HttpStatus.BAD_REQUEST);	
		}
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteRestApi(@PathVariable("id") int id){
//		ResponseEntity<String> deleteBook = this.bookService.deleteBook(id);
//		return deleteBook;
//		
//	}	
	
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Boolean> updateRestApi(@PathVariable("id") int id,@RequestBody Book book){
//		ResponseEntity deleteBook = this.bookService.updateBook(id, book);
//		return deleteBook;
//	}	
}
