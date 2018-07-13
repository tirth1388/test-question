package com.healthcare.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RandomIntListUtil {
	
	public static List<Integer> generateRandIntList(){
		List<Integer> randomIntList = new ArrayList<Integer>(1001);
		populateRandomIntList(randomIntList);
		return randomIntList;
	}
	
	private static void populateRandomIntList(List<Integer> randomIntList) {
		Random random = new Random();
		for(int i = 0; i < 1000; i++) {
			randomIntList.add(random.nextInt(1000));
		}
	}
	
	public static boolean containsDuplicate(List<Integer> randomIntList) {
		Set<Integer> randIntSet = new HashSet<>(randomIntList);
		return randIntSet.size() != randomIntList.size();
	}
	
	public static List<Integer> reduceToDuplicates(List<Integer> randomIntList) {
		return randomIntList
				.stream()
				.filter(i -> Collections.frequency(randomIntList, i) > 1)
				.collect(Collectors.toList());
	}
	
	public static List<Integer> findOrderedIntersection(List<Integer> randomIntList, List<Integer> anotherIntList) {
		
		SortedSet<Integer> ss = new TreeSet<>(anotherIntList);
		return randomIntList
				.stream()
				.filter(x -> ss.contains(x))
				.distinct()
				.sorted()
				.collect(Collectors.toList());	
	}
	
}
