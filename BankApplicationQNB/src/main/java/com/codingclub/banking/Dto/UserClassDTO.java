package com.codingclub.banking.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class UserClassDTO {
	
	
	private String loginid;
	
	
	private String User_Status="Active";

	
      private String product_code;
	

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getUser_Status() {
		return User_Status;
	}

	public void setUser_Status(String user_Status) {
		User_Status = user_Status;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	@Override
	public String toString() {
		return "UserClassDTO [login_ID=" + loginid + ", User_Status=" + User_Status + ", getLogin_ID()="
				+ getLoginid() + ", getUser_Status()=" + getUser_Status() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	

}
