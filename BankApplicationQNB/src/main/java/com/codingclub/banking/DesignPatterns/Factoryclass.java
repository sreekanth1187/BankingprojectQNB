package com.codingclub.banking.DesignPatterns;

public class Factoryclass{

	
	public Transaction getTransactionType(String transactiontype) {
		
		if("Internationalfundtransfer".equalsIgnoreCase(transactiontype)) {
			return new Internationalfundtransfer();
			
		}else if ("BookTransfer".equalsIgnoreCase(transactiontype)) {
			return new BookTransfer();
		}else if("DomesticFundTransfer".equalsIgnoreCase(transactiontype)) {
			return new DomesticFundTransfer();
		}
		return null;
	}
}
