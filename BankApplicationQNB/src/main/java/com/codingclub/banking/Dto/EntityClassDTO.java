package com.codingclub.banking.Dto;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EntityClassDTO {

	private int id;
	private String txndesc;
	private String statusdesc;
	
	
	
	private String confirmation ="Transaction Intiated Sucessfully";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTxndesc() {
		return txndesc;
	}

	public void setTxndesc(String txndesc) {
		this.txndesc = txndesc;
	}

	public String getStatusdesc() {
		return statusdesc;
	}

	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	



	@Override
	public String toString() {
		return "EntityClassDTO [id=" + id + ", txndesc=" + txndesc + ", statusdesc=" + statusdesc + ", confirmation="
				+ confirmation + "]";
	}



}
