package com.unit.test.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unit.test.rest.entities.Book;
import com.unit.test.rest.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public Book addBook(Book book) {
	Book bookObject = this.repository.save(book);
		return bookObject;
	}
	
	public Optional<Book> getBookById(Long id) {
		Optional<Book> book = this.repository.findById(id);
		return book;
	}
	
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> listOfBooks = (ArrayList<Book>) this.repository.findAll();
		return listOfBooks;
	}
	
	public Book updateBook(Book book){
		return this.repository.save(book);
		
	}
	
	public void deleteBook(Long id) {
		this.repository.deleteById(id); 
	}
	
	public List<Book> findBooksByTitleContains(String title){
		List<Book> containingBooksList = this.repository.findByTitleContaining(title);
		return containingBooksList;
	}

}
