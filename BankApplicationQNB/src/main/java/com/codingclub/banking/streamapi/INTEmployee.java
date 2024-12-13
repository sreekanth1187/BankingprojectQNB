package com.codingclub.banking.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class INTEmployee {
	
	private String name;
	private double salary;
	private int age;
	private String dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public INTEmployee(String name, double salary, int age, String dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "INTEmployee [name=" + name + ", salary=" + salary + ", age=" + age + ", dept=" + dept + "]";
	}
	
	
	public static void main(String[] args) {
		
		
		ArrayList<INTEmployee> employee = new ArrayList<INTEmployee>();
		
		employee.add(new INTEmployee("Sreekanth",1500,24,"Engineering"));
		employee.add(new INTEmployee("Bhupathi",80000,23,"Doctor"));
		employee.add(new INTEmployee("Bharath",80000,22,"Loyyer"));
		employee.add(new INTEmployee("Srinu",27000,34,"Bank Clerk"));
		employee.add(new INTEmployee("Ramya",4500,23,"Engineering"));

		
		double thersold = 50000;
		
		Optional<INTEmployee> highestsalary= employee.stream().max(Comparator.comparingDouble(INTEmployee::getSalary));
		
		
		double maxsalaryc = highestsalary.get().getSalary();
		
		employee.stream().filter(e->e.getSalary()== maxsalaryc)
		.forEach(e -> System.out.println(" Name :: " + e.getName() + " Salary ::  " + e.getSalary()));
		
		
	//System.out.println(" highestsalary : "+ highestsalary);
		
		//Find Second highest salary :
		
		Map<String, Long> grouping = employee.stream()
				.collect(Collectors.groupingBy(INTEmployee::getDept,Collectors.counting()));
		
		Map<String, Double> groupingdept = employee.stream()
				.collect(Collectors.groupingBy(INTEmployee::getDept,Collectors.averagingDouble(INTEmployee::getSalary)));
		
		//System.out.println(" grouping "+ grouping);
		System.out.println(" groupingdept "+ groupingdept);
		Optional<INTEmployee> maxsalary =employee.stream().max(Comparator.comparingDouble(INTEmployee::getSalary));
		
		double maxsalaryis = maxsalary.get().getSalary();
	//	System.out.println(" Max salary :: "+ maxsalary.get().getSalary());
		
//		employee.stream().filter(e->e.getSalary()== maxsalaryis)
//		.forEach(e-> System.out.println("Name :: "+ e.getName() + "  Salary :: "+ e.getSalary()) );
//		
		
		
	
	}
	
	
	
	
	
	public static List<INTEmployee>  aboveThresholdEmployees(ArrayList<INTEmployee> employee,double thersold){
		
		
		return employee.stream().filter(e ->e.getSalary()>50000).collect(Collectors.toList());
		
		
		
		
		
	}
	

}
