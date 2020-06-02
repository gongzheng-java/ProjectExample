package com.yichuan.entity;

/**
 * 员工 实体类
 * @author gongZheng
 * @Date 2017年8月14日上午11:22:38
 * @version 1.0
 */
public class Emp {
	
	private Integer id;
	private String name;
	private Integer age;
    private String gender;
	private String email;
	private Integer deptNo;
	
	private Dept dept;
	
	
	public Dept getDept() {
		return dept;
	}
	
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	



	public Emp() {
		super();
	}



	public Emp(String name, Integer age, String emali, Integer deptNo) {
		super();
		this.name = name;
		this.age = age;
		this.email = emali;
		this.deptNo = deptNo;
	}



	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

	public String getEmail() {
		return email;
	}
	



	public void setEmail(String email) {
		this.email = email;
	}
	



	public Integer getDeptNo() {
		return deptNo;
	}
	
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getGender() {
		return gender;
	}
	

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

	
	
	

	
	
	

}
