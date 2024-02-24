package com.npci;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private double salary; 
	private LocalDate doj;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, double salary, LocalDate doj) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.doj = doj;
	}
	//constructors
	//shortcut -right click -source 
	// to sting & generate setters and getters
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", doj=" + doj + "]";
	}
	
	// equal and hashcode only use for set impl
	// short cut --> righ click 
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
/*************/
	//Getters & Setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id - o.getId();
	}
	
}
