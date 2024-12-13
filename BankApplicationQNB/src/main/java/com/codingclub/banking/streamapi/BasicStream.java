package com.codingclub.banking.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicStream {

	public static void main(String[] args) {
		List<Integer> listnumber = Arrays.asList(11,22,13,14,25);
		
		int maxnumber = listnumber.stream().max(Comparator.comparing(Integer::valueOf)).get();

		Optional<Integer> sumofnumbers =  listnumber.stream().reduce((a,b)->a+b);
		double averageofnumber = listnumber.stream().mapToInt(e->e).average().getAsDouble();
		
		List<Integer> squaring = listnumber.stream().map(a->a*a).sorted().collect(Collectors.toList());
		
		List<Integer> filteringumber = listnumber.stream().map(a->a*a).filter(b->b>5).collect(Collectors.toList());
		
		double averageoflistfiltered = listnumber.stream().map(c->c*c).filter(a->a>5).mapToInt(b->b).average().getAsDouble();
		
	List<Integer> evenNumbers=	listnumber.stream().filter(a->a%2 ==0).collect(Collectors.toList());
	
	List<Integer> startwith = listnumber.stream().
			map(a->a.toString()).
			filter(b->b.startsWith("2")).
			map(Integer::valueOf).collect(Collectors.toList());
	
	
	String strname = "pojoclass";
	
	Map<Character, Long> groupingby = strname.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e,Collectors.counting()));
	
	//groupingby.entrySet().stream().filter(e->e.getValue()>1).forEach(e-> System.out.println(e.getKey() + " :: "+ e.getValue()));
	
	
	
//	   System.out.println("maximum number : "+ maxnumber);
//		System.out.println("sumofnumbers : "+ sumofnumbers.get());
//		System.out.println("averageofnumber number : "+ averageofnumber);
//		System.out.println("squaring number : "+ squaring);
//		System.out.println("filteringumber number : "+ filteringumber);
//		System.out.println("averageoflistfiltered number : "+ averageoflistfiltered);
//		System.out.println("evenNumbers number : "+ evenNumbers);
//		System.out.println("startwith number : "+ startwith);
//		
		// Write a program to find the count of each occuance in each letter.
		
		String name = "POJOCLAASS";
		
		HashSet hash = new HashSet();
		
		//name.chars().mapToObj(c->(char)c).filter(e->)
		
		
		Optional<Entry<Character, Long>> Occurance= name.chars()
				.mapToObj(c->(char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry->entry.getValue() > 1).findFirst();
				//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		Optional<Character> ch = name.chars().mapToObj(e->(char)e).distinct().findFirst();
		
		//name.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e),);
		
		
		//System.out.println(" Second non repeated character ::  "+ ch.get());
		
		System.out.println(" Occurance :: "+ Occurance);
		
		
		List<Integer> numbers = Arrays.asList(1,2,32,24,5,6,7,8,9);
		
		Optional<Integer> sumofnumber = numbers.stream().reduce((a, b)->a+b);
		
	//	System.out.println(sumofnumber.get());
		
		OptionalDouble db = numbers.stream().mapToInt(a->a).average();
		
		//System.out.println("average of list :: "+ db.getAsDouble());
		
		List<Integer> evennumbers =numbers.stream().filter(e->e%2==0).collect(Collectors.toList());
		
		//System.out.println("Even Numbers :: "+ evennumbers);
		
		List<Integer> startswithtwo = numbers.stream().map(a->a.toString()).filter(a->a.startsWith("2")).map(Integer::valueOf)
		.collect(Collectors.toList());
		
		//System.out.println(" Starts With 2 :: "+ startswithtwo);
		
		List<Integer> contains = numbers.stream().map(a->a.toString()).filter(a->a.contains("2")).map(Integer::valueOf)
		.collect(Collectors.toList());
		
	//	System.out.println("Contains 2 "+ contains);
		
		Optional<Integer> maxnumberby = numbers.stream().max(Comparator.comparingInt(e->e));
		
		
		//System.out.println(" maxnumberby :  "+ maxnumberby);
		
		List<Integer> limit5 =numbers.stream().map(e->e).limit(5).collect(Collectors.toList());
		
		List<Integer> skip5numbers =numbers.stream().map(e->e).skip(5).collect(Collectors.toList());
		
		//System.out.println("skip 5 numbers :: "+ skip5numbers);
		
		//System.out.println("limit 5 numbers :: "+ limit5);
		
		 List<Integer> list = Arrays.asList(0, 1, 1, 1, 2, 3, 3);
	        Set<Integer> uniqueElements = new HashSet<>(); // Set to track unique elements
	        Set<Integer> duplicates = new HashSet<>();     // Set to track duplicate elements

	        // Using a stream to process the list
	        list.stream()
	            .forEach(e -> {
	                // Check if the element was added to the uniqueElements set
	                if (!uniqueElements.add(e)) { // If false, it's a duplicate
	                    duplicates.add(e); // Add to duplicates set
	                }
	            });

	        System.out.println("Number of unique duplicate elements: " + duplicates.size());
	        
	        List listcall = Arrays.asList(0,1,1,1,2,3,3);


	        HashSet set= new HashSet();

	       long count = list.stream().filter( e->!set.add(e)).collect(Collectors.toList()).size();
	       System.out.println("count" + count);
	}

}
