package com.mystery.refl;

import java.sql.Date;

public class Person {
	private int age;
	private String name;
	private Date birthday;
	
	
	public Person() {
		super();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void sayChina(){
        System.out.println("hello ,china");
    }

    public void sayHello(String name, int age){
        System.out.println(name+"  "+age);
    }
	
	@Override
	public String toString() {
		return "姓名："+name+"       生日:"+birthday;
	}
	
}
