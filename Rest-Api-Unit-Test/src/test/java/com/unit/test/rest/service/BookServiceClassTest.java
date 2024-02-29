package com.unit.test.rest.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.unit.test.rest.entities.Book;
import com.unit.test.rest.optional.practice.exception.userNotFoundException;
import com.unit.test.rest.repositories.BookRepository;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
//@DataJpaTest
public class BookServiceClassTest {

	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	
	public Book createBookObject() {
		Book b=new Book(1l,"mybook","naresh");
		return b;
	}
	
	public List<Book> createListOfBookMethod(){
		List<Book> books=new ArrayList<>();
		
		books.add(new Book(2l, "commers", "srikanth"));
		books.add(new Book(3l, "commers", "dheeraj"));
		books.add(new Book(4l, "Botny", "sir bot"));
		
		return books;
	}
	
	@Test
	public void addBookTest() {
		when(bookRepository.save(createBookObject())).thenReturn(createBookObject());
		Book actual = bookService.addBook(createBookObject());
		assertEquals(createBookObject().getTitle(), actual.getTitle()); 
	}
	
	@Test
	public void getBookByIdTest() {
		when(bookRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(createBookObject()));
		Optional<Book> actualBook = bookService.getBookById(ArgumentMatchers.anyLong());
		assertEquals(createBookObject().getAuthor(),actualBook.get().getAuthor());
		//assertEquals(createBookObject(), actualBook);
		assertEquals(createBookObject().getId(), actualBook.get().getId());
	}
	
	@Test
	public void fetchAllBooksTest() {
		when(bookRepository.findAll()).thenReturn(createListOfBookMethod());
		ArrayList<Book> allBooks = bookService.getAllBooks();
		assertEquals(3, allBooks.size());	
		assertEquals(createListOfBookMethod(), allBooks);
		List<Book> listOfBookMethod = createListOfBookMethod();
		for(int i=0;i<listOfBookMethod.size();i++) {
			assertEquals(listOfBookMethod.get(i), allBooks.get(i));
		}	
		
		assertEquals(listOfBookMethod.get(1).getTitle(), allBooks.get(0).getTitle());
	}
	
	@Test
	public void deleteBookById() {
		bookService.deleteBook(1l);
		
	}
	

	@Test
	public void updateBook() {
		when(bookRepository.save(createBookObject())).thenReturn(createBookObject());
		Book updatectActualBook = bookService.updateBook(createBookObject());
		assertEquals(createBookObject(), updatectActualBook);
		
	}
	
	@Test
    public void findBooksByTitleContainingIsolateedWithElementsListTest() {
		List<Book> books=new ArrayList<>();
		books.add(new Book(1l, "Cricket game ", "sachin"));
		books.add(new Book(2l, "football game", "mbapee"));
		books.add(new Book(3l, "Tennis", "Nadal"));
		when(bookRepository.findByTitleContaining(ArgumentMatchers.anyString())).thenReturn(books);
		
		List<Book> actualListOfBooks = bookService.findBooksByTitleContains(ArgumentMatchers.anyString());
		assertEquals(3, actualListOfBooks.size());
    	
    }
	
	@Test
	public void findBooksByTitleContainingIsolateedWithEmptyListTest() {
		String containing="python";
		when(bookRepository.findByTitleContaining(containing)).thenReturn(Collections.EMPTY_LIST);
		List<Book> findBooksByTitleContains = bookService.findBooksByTitleContains(containing);
		assertEquals(1,findBooksByTitleContains.size() );
	}
	
	
	
	
}
