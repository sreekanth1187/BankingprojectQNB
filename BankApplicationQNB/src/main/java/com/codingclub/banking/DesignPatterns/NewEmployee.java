package com.codingclub.banking.DesignPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewEmployee {
	
	private int id;
	private String name ;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "NewEmployee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public NewEmployee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	
	
	
	

}


class Manager{
	
	
	private int id;
	private String  name;
	private List<NewEmployee> employee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<NewEmployee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<NewEmployee> employee) {
		this.employee = employee;
	}
	public Manager(int id, String name, List<NewEmployee> employee) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}
	
	
}


