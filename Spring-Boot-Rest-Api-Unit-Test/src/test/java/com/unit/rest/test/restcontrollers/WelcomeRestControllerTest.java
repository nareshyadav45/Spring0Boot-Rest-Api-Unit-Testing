package com.unit.rest.test.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unit.rest.test.controllers.WelcomeRestController;
import com.unit.rest.test.service.WelcoemService;

@WebMvcTest(value=WelcomeRestController.class)
public class WelcomeRestControllerTest {
	
	@MockBean
	private WelcoemService welcoemService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testWelocmeMethod() throws Exception {
		when(welcoemService.welcomeServiceMethod()).thenReturn("welcome to Rest Api Unit Testing");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult result = resultActions.andReturn();
		MockHttpServletResponse response = result.getResponse();
		//int actual = response.getStatus();
		//assertEquals(302, actual);
		
		String actual = response.getContentAsString();
		assertEquals("welcome to Rest Api Unit Testing", actual);	
	}
	

}
