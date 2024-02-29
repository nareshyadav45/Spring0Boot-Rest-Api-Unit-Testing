package com.unit.test.rest.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.unit.test.rest.entities.Book;
import com.unit.test.rest.repositories.BookRepository;

@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void findBooksByTitleNonIsolatedManner(){
		String title="java";
		Book book1=new Book(1l,"java language","jane");
		Book book2=new Book(2l,"Advance java ","smith");
		Book book3=new Book(3l,"python java", "title");
		
		Iterable<Book> saveAll = this.bookRepository.saveAll(Arrays.asList(book1,book2,book3));
		
		List<Book> listOfActualBooks = bookRepository.findByTitleContaining(title);
		
		assertEquals(3, listOfActualBooks.size());
		
	}
	
	@Test
	public void findBooksByTitelContainingNoResults() {
		String titleContaining="java";
		Book b1=new Book(3l, "python devolper", "rodde");
		Book b2=new Book(4l, ".Net developer", "jboss");
		
		this.bookRepository.saveAll(Arrays.asList(b1,b2));
		List<Book> containingActual = bookRepository.findByTitleContaining(titleContaining);
		
		assertEquals(0, containingActual.size());
		
		
	}
	
	

}
