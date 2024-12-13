package com.codingclub.banking.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
	
	
	private String name;
	private List<String> phonenumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(List<String> phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", phonenumber=" + phonenumber + "]";
	}
	
	public Person(String name, List<String> phonenumber) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
	}
	
	
	public static void main(String[] args) {
		
		
		ArrayList<Person> person = new ArrayList<Person>();
		
		person.add(new Person("sree",Arrays.asList("123-456-789","2345-2345-234","3456-3434-3232")));
		person.add(new Person("giri",Arrays.asList("121-23-782","23-34-234","32-3434-3232")));
		person.add(new Person("gopal",Arrays.asList("00-456-0009","2354-2345-234","345546-23-23")));
		person.add(new Person("madhu",Arrays.asList("123-324-789","23-2345-23","1212-34-123332")));
	}

}
