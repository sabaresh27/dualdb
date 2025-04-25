package com.casestudy.doubledatabase.dto;

public class EmployeeResponse {
	
	 private Long id;
	   private String name;
	   private String phone;
	   private String department;
	   private Double salary;
	   
	   public EmployeeResponse(Long id, String name, String phone, String department, Double salary) {
	       this.id = id;
	       this.name = name;
	       this.phone = phone;
	       this.department = department;
	       this.salary = salary;
	   }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}


}
