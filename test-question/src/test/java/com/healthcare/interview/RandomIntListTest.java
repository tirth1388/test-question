package com.healthcare.interview;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class RandomIntListTest {
	
	List<Integer> randomIntList;
	
	@Before
	public void init() {
		randomIntList = RandomIntListUtil.generateRandIntList();
	}
	
	@Test
	public void sizeTest() {
		assertTrue(randomIntList.size() == 1000);
		assertNotNull(randomIntList.get(999));
	}
	
	@Test
	public void maxValueTest() {
		assertTrue(randomIntList.stream().noneMatch(x -> x > 1000));	
	}
	
	@Test
	public void containsDuplicateTest() {
		Set<Integer> randomIntSet = new HashSet<>(randomIntList);
		assertSame(randomIntSet.size()!=randomIntList.size(), RandomIntListUtil.containsDuplicate(randomIntList));
	}	

}
