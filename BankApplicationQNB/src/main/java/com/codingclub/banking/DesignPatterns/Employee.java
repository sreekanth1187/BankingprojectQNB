package com.codingclub.banking.DesignPatterns;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.el.stream.Optional;

public class Employee {
	
	private String name;
	private String Dept;
	private int age ;
	
	
	private long salary;
	private String gender;
	
	private int performancescore;
	private int tenureCompany;
	
	public int getPerformancescore() {
		return performancescore;
	}
	public void setPerformancescore(int performancescore) {
		this.performancescore = performancescore;
	}
	public int getTenureCompany() {
		return tenureCompany;
	}
	public void setTenureCompany(int tenureCompany) {
		this.tenureCompany = tenureCompany;
	}
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
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}


	

	
	
	public Employee(String name, String dept, int age, long salary, String gender, int performancescore,
			int tenureCompany) {
		super();
		this.name = name;
		Dept = dept;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.performancescore = performancescore;
		this.tenureCompany = tenureCompany;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", Dept=" + Dept + ", age=" + age + ", performancescore=" + performancescore
				+ ", tenureCompany=" + tenureCompany + ", salary=" + salary + ", gender=" + gender + "]";
	}
	public static void main(String[] args) {
		
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		
		emplist.add(new Employee("Allen","HR",12,1000,"Male",10,2));
		emplist.add(new Employee("Sarah","Finance",14,2000,"Female",6,4));
		emplist.add(new Employee("Gopi","Eng",14,3000,"Male",3,4));
		emplist.add(new Employee("Job Fen","HR",14,4000,"Male",1,2));
		emplist.add(new Employee("Sam","Finance",14,4000,"Female",9,3));
		emplist.add(new Employee("KilleN","Eng",14,69000,"Male",3,4));
		emplist.add(new Employee("Goutham","HR",14,69000,"Male",3,3));
		emplist.add(new Employee("Farah","Finance",15,69000,"Female",3,4));
		emplist.add(new Employee("Munneeb","ENG",17,9000,"Female",7,7));
		
	
	List<String> emplistsorted=	emplist.stream().filter(emp-> emp.getPerformancescore()>3).filter(emp1->emp1.getTenureCompany()>1)
			.map(Employee::getName).sorted().collect(Collectors.toList());
		
	System.out.println(" emplistsorted : "+ emplistsorted);
		
		List<String> arraylist = Arrays.asList("Sreekanth","Raghu","Madhu","Kavin","Puli");
		
		
		List<String> listodtech = Arrays.asList("Spring Boot","Java","Microservices","API","Spring Cloud");
		
		String input="Spring";
		List<String> commonelement = listodtech.stream().filter(t->t.contains(input)).collect(Collectors.toList());
		
		System.out.println("commonelement : "+ commonelement);
		Map<String , Long> genderlist = emplist.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		
		java.util.Optional<Employee> grouingbymale = emplist.stream().filter(e->e.getGender().equals("Male") && e.getDept().equals("HR"))
				.max(Comparator.comparingLong(Employee::getSalary));
		
		
		
		System.out.println("grouingbymale : "+ grouingbymale);
		
		
		
	//Map<String,Long>groupingByDept =emplist.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
		
//	emplist.stream()
//		    .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
//
//		
//		
		
		//emplist.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting());
		
		
//	String  =  arraylist.stream()
//		            .collect(Collectors.joining(","));
//	
//	//System.out.println("Stream : "+ );
//		
//		
//		
//		//System.out.println(": output : "+ arm.get());
//		
//		 java.util.Optional<Employee>  = emplist.stream()
//				.max(Comparator.comparingLong(Employee::getSalary));
//		
		
		
		
		
		
		
		
		
		
	}

}
