package com.codingclub.banking.DesignPatterns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class TopMangerBysalary{
	
	
	public static void main(String[] args) {
		
		ArrayList<NewEmployee> employeemanager1 = new ArrayList<NewEmployee>();
		
		employeemanager1.add(new NewEmployee(11,"Allen",121000));
		employeemanager1.add(new NewEmployee(12,"Sarah",2000));
		employeemanager1.add(new NewEmployee(13,"Gopi",3000));
		employeemanager1.add(new NewEmployee(14,"Job Fen",4000));
		employeemanager1.add(new NewEmployee(15,"Sam",4000));
		ArrayList<NewEmployee> employeemanager12 = new ArrayList<NewEmployee>();
		employeemanager12.add(new NewEmployee(16,"KilleN",10000));
		employeemanager12.add(new NewEmployee(17,"Goutham",69000));
		employeemanager12.add(new NewEmployee(18,"Farah",7000));
		employeemanager12.add(new NewEmployee(19,"Munneeb",9000));
		employeemanager12.add(new NewEmployee(20,"Waseb",9000));
		
		ArrayList<Manager> managers = new ArrayList<Manager>();
		
		managers.add(new Manager(1,"Venkat", employeemanager1));
		managers.add(new Manager(1,"Sathish", employeemanager12));
		
		
		java.util.Optional<NewEmployee> newEmployeenamager1 = employeemanager1.stream().max(Comparator.comparingDouble(NewEmployee::getSalary));
		
		java.util.Optional<NewEmployee> newEmployeenamager2 = employeemanager12.stream().max(Comparator.comparingDouble(NewEmployee::getSalary));
		
		managers.forEach(manager ->{ 
			java.util.Optional<NewEmployee> employee =	manager.getEmployee().stream().max(Comparator.comparingDouble(NewEmployee::getSalary));
			
			System.out.println("Managers : "+ manager.getName() + " : "+ employee );
		}
		
		);
		
	//	System.out.println("newEmployeenamager1 : "+ newEmployeenamager1.orElse(null));
	//	System.out.println("newEmployeenamager2 : "+ newEmployeenamager2.orElse(null));
		 
//	System.out.println("managerlistbygroup :"+ managerlistbygroup);
	}
}