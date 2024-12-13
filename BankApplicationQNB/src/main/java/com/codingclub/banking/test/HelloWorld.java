package com.codingclub.banking.test;

import java.util.HashMap;
import java.util.HashSet;

class HelloWorld {
	public static void main(String[] args) {

		String str = "Sreekaanth";
		char[] character = str.toCharArray();
		
		/*
		 * HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		 * 
		 * char repetedchar = 0; int repeatedcount = 0;
		 * 
		 * for (int i = 0; i < str.length(); i++) { char c = str.charAt(i);
		 * hash.put(c,hash.getOrDefault(c, 0) +1); if(repeatedcount<hash.get(c)) {
		 * repeatedcount = hash.get(c); repetedchar = c; } }
		 */
		
		//System.out.println("repeated char : "+ repetedchar + "  Count of : "+ repeatedcount );
		HashSet uniquecharacters = new HashSet();
	    HashMap<Character , Integer> countmap = new HashMap<Character, Integer>();
		
		for(char c : character) {
			
			if(!uniquecharacters.add(c)) {
				
				countmap.put(c,countmap.getOrDefault(c, 1)+1);
			}
			
		}
		System.out.println("Repeated charcters : "+ countmap);
	}
}