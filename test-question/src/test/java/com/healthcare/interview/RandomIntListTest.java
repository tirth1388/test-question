package com.healthcare.interview;

import static com.healthcare.interview.RandomIntListUtil.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
public class RandomIntListTest {
	
	List<Integer> randomIntList;
	
	@Before
	public void init() {
		randomIntList = generateRandIntList();
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
		assertSame(randomIntSet.size()!=randomIntList.size(), containsDuplicate(randomIntList));
	}
	
	@Test
	public void reduceToDuplicatesTest() {
		List<Integer> testList = Arrays.asList(11, 12, 13, 13, 14, 14, 15, 15, 16); //two of each for 13, 14 and 15
		Set<Integer> expectedSet = new HashSet<>(Arrays.asList(13, 14, 15));  //expected result
		Set<Integer> resultSet = new HashSet<>(reduceToDuplicates(testList)); //get the result set
		
		assertEquals(expectedSet, resultSet);		
	}
	
	@Test
	public void findOrderedIntersectionTest() {
		List<Integer> testList1 = Arrays.asList(11, 12, 13, 13, 14, 14, 15, 15, 16); 
		List<Integer> testList2 = Arrays.asList( 16, 12, 15, 120, 121, 222, 205, 105, 107, 2, 1); // 12, 15, 16 is intersection
		
		List<Integer> expectedIntersection = Arrays.asList(15, 12, 16);  //expected result
		Collections.sort(expectedIntersection); //sort the expected result
		List<Integer> resultedSortedList = findOrderedIntersection(testList1, testList2); //get the result set
		
		//test
		//first assert they contain the same elements and same length
		assertEquals(expectedIntersection, resultedSortedList); 
		
		//assert they are ordered too
		for(int i = 0; i <expectedIntersection.size(); i++) {
			assertEquals(expectedIntersection.get(i), resultedSortedList.get(i)); 
		}	
	}
}
