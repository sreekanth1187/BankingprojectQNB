package com.codingclub.banking.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeOne {

	private String empname;
	private double salary;
	private int age;

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
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

	public EmployeeOne(String empname, double salary, int age) {
		super();
		this.empname = empname;
		this.salary = salary;
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeOne [empname=" + empname + ", salary=" + salary + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		
		ArrayList<EmployeeOne> employeelistformanagerone  = new ArrayList<EmployeeOne>();
		
		employeelistformanagerone.add(new EmployeeOne("Sreekanth",10000,24) );
		employeelistformanagerone.add(new EmployeeOne("Gopal",20000,23) );
		employeelistformanagerone.add(new EmployeeOne("Krishna",50000,22) );
		employeelistformanagerone.add(new EmployeeOne("Venkatesh",70000,25) );
		
		ArrayList<EmployeeOne> employeelistformanagertwo = new ArrayList<EmployeeOne>();

		employeelistformanagertwo.add(new EmployeeOne("Kiran", 80000, 24));
		employeelistformanagertwo.add(new EmployeeOne("Yadav", 20000, 23));
		employeelistformanagertwo.add(new EmployeeOne("Bhupal", 80000, 22));
		employeelistformanagertwo.add(new EmployeeOne("Komali", 880000, 25));
		
		
		ArrayList<Manager> managerone = new ArrayList<Manager>();
		
		managerone.add(new Manager("Pallavi",45,employeelistformanagerone));
		managerone.add(new Manager("Venu",45,employeelistformanagertwo));
		
		Map<String,Optional<EmployeeOne>> listofemployeeineachmanager = managerone.stream().
		collect(Collectors.toMap(Manager::getManagerName,
				manager->manager.getEmployeemapped().stream().max(Comparator.comparingDouble(EmployeeOne::getSalary)) ));
	
		System.out.println("listofemployeeineachmanager" + listofemployeeineachmanager);
		
		listofemployeeineachmanager.forEach((manager,emplist)->
		
		{
			if(emplist.isPresent()) {
				
				System.out.println("Manager Name :: "+ manager + " Emplist :: "+emplist );
				
			}
			
		}
				
				
				);
		
		
	}

}

class Manager {

	private String managerName;
	private int age;
	private List<EmployeeOne> employeemapped;

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<EmployeeOne> getEmployeemapped() {
		return employeemapped;
	}

	public void setEmployeemapped(List<EmployeeOne> employeemapped) {
		this.employeemapped = employeemapped;
	}

	public Manager(String managerName, int age, List<EmployeeOne> employeemapped) {
		super();
		this.managerName = managerName;
		this.age = age;
		this.employeemapped = employeemapped;
	}

	@Override
	public String toString() {
		return "Manger [managerName=" + managerName + ", age=" + age + ", employeemapped=" + employeemapped + "]";
	}
   

}
