package com.junit.caluculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("TestCaluculatorClass")
public class CaluculatorTest {

	private static Caluculator c=null;
	
	@BeforeAll
	public static void init() {
		c=new Caluculator();
	}
	
	@AfterAll
	public static void destroy() {
		c=null;
	}
	
	@Test
	public void testAdd() {
		int actual = c.add(1,2);
		int expected=3;
		assertEquals(expected, actual);	
	}
	
	@Test
	@DisplayName("Multiplication Test")
	public void testProduct() {
		int actual = c.product(2, 6);
		int expected=12;
		assertEquals(expected,actual);
	}
	
	@ParameterizedTest
	@DisplayName("Parameterized test with csv source not file source")
	@CsvSource({"1,2,3","2,3,5","6,7,13"})
	public void testAddWithParams(int a,int b,int expected) {
		int actual = c.add(a, b);
		assertEquals(expected, actual);	
		
	}
	
	@ParameterizedTest
	@CsvSource({"Naresh,Yadav,NareshYadav","Yelladri,Yadav,YelladriYadav","Ramesh,Yadav,RameshYadav"})
	@DisplayName("welcome message test")
	public void testWelocmeMesssage(String a,String b,String expected) {
		String actual = c.welcomeMessage(a, b);
		assertEquals(expected, actual);
	}
	
	
}
