package com.codingclub.banking.DesignPatterns;

import java.util.HashSet;

//import com.codingclub.banking.DesignPatterns.Transaction;
 
public class Mainclassofclient {

	
	
	public static void main(String[] args) {
		Factoryclass factoryclass = new Factoryclass();
		
			Transaction transaction  = factoryclass.getTransactionType("Internationalfundtransfer");
			transaction.Payment();
			
			String str = "SREEkaanth ";
			HashSet hash = new HashSet<>();
			char[] chart = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			StringBuilder db = new StringBuilder();
			for (char charm : chart) {

				if (!hash.add(charm)) {

					sb.append(charm).append(",");

				}else {
					db.append(charm).append(",");
				}

			}
			
			String reve="";
			StringBuffer sb1= new StringBuffer();
			for(int i=str.length()-1 ; i>=0;i--) {
				
				
			 reve	+= str.charAt(i);
				
				//sb1.append(charmm).append(",");
				
				
				
			}
			System.out.println(" Reverse :: "+ reve);
			
			System.out.println("Unique value :" + sb.toString() + "repeated : "+ db.toString());
			
		
	}
}
