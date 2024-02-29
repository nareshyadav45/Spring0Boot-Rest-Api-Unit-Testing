package com.unit.rest.test.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unit.rest.test.BookRestController;
import com.unit.rest.test.beans.Book;
import com.unit.rest.test.service.BookService;

@WebMvcTest(value=BookRestController.class)
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
public class BookRestControllerTest {

	@MockBean
	private BookService bookService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void addBookTest() throws Exception {
		when(bookService.addBook(ArgumentMatchers.any())).thenReturn(false);
		
		Book book=new Book(1, "RestApiUnitTesting", 1220.0);
		ObjectMapper mapper=new ObjectMapper();
		String jsonData = mapper.writeValueAsString(book);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addBook")
		                       .contentType(MediaType.APPLICATION_JSON)
		                       .content(jsonData);
		
	ResultActions perform = mockMvc.perform(requestBuilder);
	MvcResult andReturn = perform.andReturn();
	MockHttpServletResponse response = andReturn.getResponse();
	int actual = response.getStatus();
	assertEquals(400, actual);
       String actualWithString = response.getContentAsString();
       assertEquals("Book not saved!!", actualWithString);
	}
	
	@Test
	public void deleteRestApiTest() throws Exception {
		//int anyIntt = ArgumentMatchers.anyInt();
		int idToBeDelete=123;
		//when(bookService.deleteBook(ArgumentMatchers.anyInt())).thenReturn(new ResponseEntity<>("with given id resource not found"+idToBeDelete, HttpStatus.NO_CONTENT));
		when(bookService.deleteBook(ArgumentMatchers.anyInt())).thenReturn(new ResponseEntity<>("resource deleted successfully with given id"+idToBeDelete, HttpStatus.NO_CONTENT));

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/delete/{id}", idToBeDelete)
		    .contentType(MediaType.APPLICATION_JSON);
				//.contentType(MediaType.APPLICATION_JSON);
				//.accept(MediaType.APPLICATION_JSON);
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult results = perform.andReturn();
		MockHttpServletResponse response = results.getResponse();
		//int actual = response.getStatus();
		//assertEquals(204, actual);
		String actual = response.getContentAsString();
		//assertEquals("with given id resource not found"+idToBeDelete,actual);
		assertEquals("resource deleted successfully with given id"+idToBeDelete,actual);
	}
	
	@Test
	public void updateRestApiTest() throws Exception {
		when(bookService.updateBook(ArgumentMatchers.anyInt(),ArgumentMatchers.any())).thenReturn(new ResponseEntity<>(true,HttpStatus.OK));
		Book book=new Book(1, "RestApiUnitTesting", 1220.0);
		ObjectMapper mapper=new ObjectMapper();
		String jsonData = mapper.writeValueAsString(book);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update/{id}",1).
		contentType(MediaType.APPLICATION_JSON)
		.content(jsonData);
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		//int actual = response.getStatus();
		//assertEquals(200, actual);
		String contentAsString = response.getContentAsString();
		Boolean readValue = mapper.readValue(contentAsString, Boolean.class);
		//assertFalse(readValue);
		assertEquals(true, readValue);
	}
	
}
