package com.codingclub.banking.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeExample {

	
	public static void main(String[] args) {
		
		
		ConcurrentHashMap<Integer, String> concurrenthashmap = new ConcurrentHashMap<>();
		concurrenthashmap.put(1, "one");
		concurrenthashmap.put(2, "two");
		
		Iterator<Entry<Integer, String>> iterator = concurrenthashmap.entrySet().iterator();
		
		
		concurrenthashmap.put(4, " ");
		
		try {
			
		
		 while(iterator.hasNext()) {
			 Map.Entry<Integer, String> map = iterator.next();
			 System.out.println("Key : "+ map.getKey() + " and Value :   "+map.getValue() );
		 }
		}catch(Exception e ) {
			System.out.println("Exception occured :: "+ e);
		}
	}
}
