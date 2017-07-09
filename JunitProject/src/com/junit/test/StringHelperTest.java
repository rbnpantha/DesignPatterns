package com.junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rbn.practice.StringHelper;

public class StringHelperTest {
	StringHelper stringHelper = new StringHelper();
	@Test
	public void testStrWith2CharReversed() {
		
		assertEquals("BA", stringHelper.SwapLast2Char("AB"));
	}

	@Test
	public void testStrWith4CharReversed() {
		
		assertEquals("ABDC", stringHelper.SwapLast2Char("ABCD"));
	}
	
	@Test
	public void testStrWith10CharReversed() {
		
		assertEquals("ABCDEFGHJI", stringHelper.SwapLast2Char("ABCDEFGHIJ"));
	}
	
	@Test
	public void testStrWith1CharReversed() {
		
		assertEquals("A", stringHelper.SwapLast2Char("A"));
	}
	
	@Test
	public void testStrWith0CharReversed() {
		
		assertEquals("", stringHelper.SwapLast2Char(""));
	}
	
}
