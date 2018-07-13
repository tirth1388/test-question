package com.healthcare.interview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.healthcare.interview.RandomIntListUtil.*;

public class ApplicationRandomInteger {

	public static void main(String[] args) {
		List<Integer> randomIntegers = generateRandIntList();
		//does it contain duplicate
		System.out.println("Does the list contains duplicate:\t\t" + containsDuplicate(randomIntegers));
		
		//print the duplicate numbers
		System.out.println("\nPrinting duplicate numbers only");
		List<Integer> duplicateNumbers = reduceToDuplicates(randomIntegers);
		Set<Integer> duplicateNumberSet = new HashSet<>(duplicateNumbers);
		duplicateNumberSet.forEach(System.out::println);
		
		//print the intersection of another list
		System.out.println("\nPrinting intersections of two list only, in order");
		List<Integer> anotherRandomIntegers = generateRandIntList();
		List<Integer> intersectionList = findOrderedIntersection(randomIntegers, anotherRandomIntegers);
		intersectionList.forEach(System.out::println);
	}

}
