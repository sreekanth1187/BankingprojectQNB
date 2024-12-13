package com.codingclub.banking.streamapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTwo {
	
	// write a programm to list who are all above 18
	
	
	private int empid;
	private String name;
	private int age;
	private double salary ;
	private String dept;
	private String gender;
	
	public EmployeeTwo(int empid, String name, int age, double salary, String dept, String gender) {
		super();
		this.empid = empid;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dept = dept;
		this.gender = gender;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	@Override
	public String toString() {
		return "EmployeeTwo [empid=" + empid + ", name=" + name + ", age=" + age + ", salary=" + salary + ", dept="
				+ dept + ", gender=" + gender + "]";
	}

	public static void main(String[] args) {
		
	 ArrayList<EmployeeTwo> employee = new ArrayList<EmployeeTwo>();
	 
	 employee.add(new EmployeeTwo(1,"mallesh",12,3000,"Eng","Male"));
	 employee.add(new EmployeeTwo(2,"Anu",32,5000,"HR","Female"));
	 employee.add(new EmployeeTwo(3,"Bharath",22,4000,"Doc","Male"));
	 employee.add(new EmployeeTwo(4,"bhupathi",23,6000,"Loyer","Male"));
	 employee.add(new EmployeeTwo(5,"Gopi",17,2000,"Teacher","Male"));
	 employee.add(new EmployeeTwo(6,"Radha",13,9000,"Tester","Female"));
	 
	 
	 List<EmployeeTwo> filteremployee = employee.stream().filter(e->e.getAge()>18).collect(Collectors.toList());
	 
	 List<EmployeeTwo> employelastandfirst = employee.stream().filter(e->e.getName().startsWith("R") && e.getName().endsWith("a"
	 		+ "")).collect(Collectors.toList());
	 
	 List<EmployeeTwo> maleEmp=employee.stream().filter(e->e.getGender().equals("Male")).collect(Collectors.toList());
	 
	Optional<EmployeeTwo> malehighest = employee.stream().
			 filter(e->e.getGender().equals("Male")).
			 max(Comparator.comparingDouble(EmployeeTwo::getSalary));

	

	 System.out.println(employelastandfirst);
        
		
	}
	
	
	

}
