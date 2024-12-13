package com.codingclub.banking.test;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastExample {
	
	
public static void main(String[] args) {
	
	Cloning o = new Cloning();
	o.i=1;
	o.j=1;
	
	Cloning p = o;
	
	Cloning obj1 = new Cloning();
	
	obj1.i=3;
	obj1.j=4;
	
	Cloning obj2 = new Cloning();
	
	obj2.i=obj1.i;
	obj2.j=obj1.j;
	
	obj2.i=0;
	System.out.println("Shadow copying obj1 :: "+ obj1.i);
	System.out.println("Shadow copying obj2  :: "+ obj2.i);
	System.out.println("Shadow copying  obj2 :: "+ obj2.j);
	
	
	System.out.println("Shadow copying  :: "+ p.i);
	HashMap<Integer , String > hashmap = new HashMap<Integer, String>();
	
	p.i=3;
	System.out.println("Shadow copying 1 :: "+ o.i);
	hashmap.put(1, "One");
	hashmap.put(2,"two");
	
	Iterator<Map.Entry<Integer, String >> iterator = hashmap.entrySet().iterator();
	
	hashmap.put(3,"three");
	System.out.println("Exception :: "+ hashmap);
	try {
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    } catch (ConcurrentModificationException e) {
        System.out.println("Caught ConcurrentModificationException: " + e);
    }
	
	
	HashMap<Integer , String> hashmapone = new HashMap<Integer, String>();
	
	hashmapone.put(1, "TCS");
	hashmapone.put(2, "TATA");
	
	//Iterator<Map.Entry<Integer, String>> iteratoring = hashmapone.entrySet().iterator();
	
	Iterator<Map.Entry<Integer, String>>iteratoring = hashmapone.entrySet().iterator();
	hashmapone.put(3,"TATA STEEL");
	try {
		while(iteratoring.hasNext()) {
			Map.Entry<Integer, String> mapiterating = iteratoring.next();
			System.out.println("Key : "+ mapiterating.getKey() + " -   "+ "Value : "+ mapiterating.getValue());
 		}
		
	}catch(Exception Exe) {
		System.out.println("Cauth Concurrent Modification Exception :: "+ Exe);
		
	}
	
	
	
	
}
}
