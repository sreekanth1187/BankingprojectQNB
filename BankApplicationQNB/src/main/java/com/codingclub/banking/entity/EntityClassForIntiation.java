package com.codingclub.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "OD_TXN_MASTER")
public class EntityClassForIntiation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String debitaccountnumber;

	private String debitaccname;
	private double  availablebal;
	private String debitcurrency;

	private String beneaccountnumber;
	private String benename;
	private String benecurrency;
	private String sortcode;
	private String beneaddress;
	private String beneemail;
	private String odverionno;
	private String odaction;
	private String benephonenumber;
	private String odstatus;
	private String txntype;
	private String product;
	private String subproduct;
	private String txndesc;
	private String statusdesc;
	
	
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
	public String getBeneaccountnumber() {
		return beneaccountnumber;
	}
	public void setBeneaccountnumber(String beneaccountnumber) {
		this.beneaccountnumber = beneaccountnumber;
	}
	public String getBenename() {
		return benename;
	}
	public void setBenename(String benename) {
		this.benename = benename;
	}
	public String getBenecurrency() {
		return benecurrency;
	}
	public void setBenecurrency(String benecurrency) {
		this.benecurrency = benecurrency;
	}
	public String getSortcode() {
		return sortcode;
	}
	public void setSortcode(String sortcode) {
		this.sortcode = sortcode;
	}
	public String getBeneaddress() {
		return beneaddress;
	}
	public void setBeneaddress(String beneaddress) {
		this.beneaddress = beneaddress;
	}
	public String getBeneemail() {
		return beneemail;
	}
	public void setBeneemail(String beneemail) {
		this.beneemail = beneemail;
	}
	public String getOdverionno() {
		return odverionno;
	}
	public void setOdverionno(String odverionno) {
		this.odverionno = odverionno;
	}
	public String getOdaction() {
		return odaction;
	}
	public void setOdaction(String odaction) {
		this.odaction = odaction;
	}
	public String getBenephonenumber() {
		return benephonenumber;
	}
	public void setBenephonenumber(String benephonenumber) {
		this.benephonenumber = benephonenumber;
	}
	public String getOdstatus() {
		return odstatus;
	}
	public void setOdstatus(String odstatus) {
		this.odstatus = odstatus;
	}
	public String getTxntype() {
		return txntype;
	}
	public void setTxntype(String txntype) {
		this.txntype = txntype;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSubproduct() {
		return subproduct;
	}
	public void setSubproduct(String subproduct) {
		this.subproduct = subproduct;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDebitaccountnumber() {
		return debitaccountnumber;
	}
	public void setDebitaccountnumber(String debitaccountnumber) {
		this.debitaccountnumber = debitaccountnumber;
	}


	public String getDebitaccname() {
		return debitaccname;
	}
	public void setDebitaccname(String debitaccname) {
		this.debitaccname = debitaccname;
	}
	public double getAvailablebal() {
		return availablebal;
	}
	public void setAvailablebal(double availablebal) {
		this.availablebal = availablebal;
	}
	public String getDebitcurrency() {
		return debitcurrency;
	}
	public void setDebitcurrency(String debitcurrency) {
		this.debitcurrency = debitcurrency;
	}
	public EntityClassForIntiation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EntityClassForIntiation(int id, String debitaccountnumber, String debitaccname, double availablebal,
			String debitcurrency, String beneaccountnumber, String benename, String benecurrency, String sortcode,
			String beneaddress, String beneemail, String odverionno, String odaction, String benephonenumber,
			String odstatus, String txntype, String product, String subproduct) {
		super();
		this.id = id;
		this.debitaccountnumber = debitaccountnumber;
		this.debitaccname = debitaccname;
		this.availablebal = availablebal;
		this.debitcurrency = debitcurrency;
		this.beneaccountnumber = beneaccountnumber;
		this.benename = benename;
		this.benecurrency = benecurrency;
		this.sortcode = sortcode;
		this.beneaddress = beneaddress;
		this.beneemail = beneemail;
		this.odverionno = odverionno;
		this.odaction = odaction;
		this.benephonenumber = benephonenumber;
		this.odstatus = odstatus;
		this.txntype = txntype;
		this.product = product;
		this.subproduct = subproduct;
	}



}
