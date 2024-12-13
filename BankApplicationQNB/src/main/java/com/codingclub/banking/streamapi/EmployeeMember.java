package com.codingclub.banking.streamapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.comparator.Comparators;

public class EmployeeMember {
	
	private String name;
	private double salary;
	private int age;
	private String  gender;
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	public EmployeeMember(String name, double salary, int age, String gender) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.gender = gender;
	}
	
	
	
	
	@Override
	public String toString() {
		return "EmployeeMember [name=" + name + ", salary=" + salary + ", age=" + age + ", gender=" + gender + "]";
	}
	public static void main(String[] args) {
		
		ArrayList<EmployeeMember> employee = new ArrayList<EmployeeMember>();
		
		employee.add( new EmployeeMember("Sreekanth",1000,14,"Male"));
		employee.add( new EmployeeMember("Gopal",2000,18,"Male"));
		employee.add( new EmployeeMember("Mishra",3000,19,"Male"));
		employee.add( new EmployeeMember("Goutham",4000,19,"Male"));
		employee.add( new EmployeeMember("Mira",5000,2,"Female"));
		employee.add( new EmployeeMember("nivisha",5000,2,"Female"));
		employee.add( new EmployeeMember("veena",5000,2,"Female"));
		employee.add( new EmployeeMember("gouri",5000,20,"Female"));
		
		List<EmployeeMember> employeelist = employee.stream().filter(E -> E.getAge() > 19).collect(Collectors.toList());
		
		System.out.println("Greater than 19 : "+ employeelist );
		
	List<EmployeeMember> emplist = employee.stream().filter(employeee->"Male".equalsIgnoreCase(employeee.getGender())).collect(Collectors.toList());
		
	System.out.println(emplist);
	
		Optional<EmployeeMember> Highestsalary = employee.stream()
				.max(Comparator.comparingDouble(EmployeeMember::getSalary));
		
		Optional<Double> employeesecond = Optional.of(employee.stream().map(EmployeeMember::getSalary).distinct().sorted(Collections.reverseOrder()).skip(1).findFirst().orElse(null));
		
		System.out.println(employeesecond);
		
		
		if(Highestsalary.isPresent()) {
			System.out.println(Highestsalary);
		}
		
		
	}
	
	

}
