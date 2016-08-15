package com.mystery.domain;

import java.sql.Date;

public class Person {
	public int pid;
	public String pname;
	public double psalary;
	public Date pbirthday;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPsalary() {
		return psalary;
	}
	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}
	public Date getPbirthday() {
		return pbirthday;
	}
	public void setPbirthday(Date pbirthday) {
		this.pbirthday = pbirthday;
	}
	public Person() {
		super();
	}

	
}
