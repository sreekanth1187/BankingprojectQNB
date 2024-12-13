package com.codingclub.banking.DesignPatterns.abstractfactory;

public class AbstractFactoryProvider {

	
public static abstractfactoryclass getprofession(boolean professiontype) {
		
		if(professiontype) {
			return new Professionabstarctfactory();
		}else {
			return new TraineeabstractFactory();
		}
		//retun null;
	}
}
