package com.codingclub.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="OD_USERS_MB")
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationMaster {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_NUMBER")
	private int id;

	@Column(name="od_user_no")
	private String usernumber;
	
	
	@Column(name="OD_FUNCTION_CODE")
	private String function_Code;
	
	@Column(name="OD_PRODUCT_CODE")
	private String product_code;
	
	@Column(name="OD_SUBPROD_CODE")
	private String subprod_code;
	

	@Column(name="USER_TYPE")
	private String usertype;
	@Column(name="SELFAUTH_IND")
	private String selfauthindicator;
	
	@NotNull(message="self auth amount is not empty , above 1")
	@Min(1)
	@Column(name="SELF_AUTH_AMT")
	private long selfauthamount;

	@NotNull(message="Login ID Shouldn't Empty")
	@Column(name="OD_LOGIN_ID")
	private String loginid;
	
	@Email(message="Please enter valid email.")
	@Column(name="Email_ID")
	private String emailID;
	
	@Min(18)
	@Max(60)
	private String age;

	@NotBlank
	private String gender;
	
	@Pattern(regexp = "^\\d{10}$",message="please enter valid mobile number.")
	@Column(name="MObile_Number")
	private String mobilenum;
	
	@NotBlank
	private String nationality;
	
	@Column
	private String password;
	@Column
	private String roles;
	
	
	

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getSelfauthindicator() {
		return selfauthindicator;
	}

	public void setSelfauthindicator(String selfauthindicator) {
		this.selfauthindicator = selfauthindicator;
	}

	public long getSelfauthamount() {
		return selfauthamount;
	}

	public void setSelfauthamount(long selfauthamount) {
		this.selfauthamount = selfauthamount;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	private boolean deleted;

	

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}




	public String getFunction_Code() {
		return function_Code;
	}

	public void setFunction_Code(String function_Code) {
		this.function_Code = function_Code;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getSubprod_code() {
		return subprod_code;
	}

	public void setSubprod_code(String subprod_code) {
		subprod_code = subprod_code;
	}
	
	
	

	/*
	 * public void generateUserNumber() { LocalDateTime now = LocalDateTime.now();
	 * String timestamp = now.toString().replace("-", "").replace(":",
	 * "").replace("T", "").replace(".", ""); String sequentialNumber =
	 * String.format("%010d", id); // Ensure id is padded with leading zeros
	 * this.usernumber = timestamp.substring(2) + sequentialNumber; // Concatenate
	 * timestamp and sequential number }
	 */



}
