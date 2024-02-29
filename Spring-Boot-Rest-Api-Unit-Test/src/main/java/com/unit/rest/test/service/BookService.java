package com.unit.rest.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unit.rest.test.BookRestController;
import com.unit.rest.test.beans.Book;

@Service
public class BookService<T> {
	

	public Boolean addBook(Book book) {
		return true;
		
	}
	
	public ResponseEntity<String> deleteBook(int id) {
			Book b=new Book(id);
			if(b==null) {
				return new ResponseEntity<String>("with given id resource not found"+id,HttpStatus.NOT_FOUND);
			}	
		return new ResponseEntity<String>("resource deleted successfully with given id"+id,HttpStatus.NO_CONTENT);
		
	}
	
	public ResponseEntity<Boolean> updateBook(int id,Book book){
		Book bookObject=new Book(id);
		if(bookObject==null) {
			return   new ResponseEntity<Boolean>(true,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		
	}							
}
