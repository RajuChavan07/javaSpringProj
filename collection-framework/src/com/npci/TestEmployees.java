package com.npci;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//adding list of employee in a Java.Util.List<Employee>
		List<Employee> list = new ArrayList<>();
		// creating an obj of emp and adding
		//ISO format of date yyyy-MM-dd
	Employee emp1 = new Employee (100, "Raj", 50000, LocalDate.parse("2001-12-15"));
	list.add(new Employee(200,"sham",20050,LocalDate.parse("2002-12-15")));
	list.add(new Employee(201,"shamee",20060,LocalDate.parse("2003-12-15")));
	list.add(new Employee(202,"shamii",20070,LocalDate.parse("2005-12-15")));
	list.add(new Employee(203,"shamyy",20080,LocalDate.parse("2006-12-15")));

	System.out.println("printing list.....");
	print(list);
	list.remove(2);
	System.out.println("After remove printing.....");
	print(list);
	// Sorting List using the sort method it takes comparator as an argument.
	//Comparator functional interface which has the one abstact method compare (T t1, t2)
	// class SortById
	
	/*In java 8 lambda expression is introduced to minimize writing anomus imp
	list.sort(e1, e2) -> e1.getId()-e2.getId();
	
	sorting decs order
	list.sort(e1, e2) -> e2.getId()-e1.getId();
	list.sort(e1, e2) -> Double.compare(e1.getSal()-e2.getSal();
	sorting based on the sal
	*/
	// Appling sort logic using comparator with lamda
	// We can use lambda expression 
	Comparator<Employee> compareById = (e1, e2) -> e2.getId()-e1.getId();
	System.out.println("Sorting by on ID by desc.....");
	list.sort(compareById);
	print(list);
	// lambda expression direclty to sort method withouth ref
	System.out.println("Sorting by on Sal.....");
	list.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
	print(list);
	System.out.println("Sorting by on doj in dec.....");
	//list.sort((e1, e2) -> e2.getDoj.compareTo( e2.getSalary()));
	print(list);

	/*........set to store unic element.........*/
	/* Note: for complex type you must override 2 methodes of obj equal and hascode
	* hashCode:Tells the location of the obj
	* equals:Compare two obj to identify duplicates
	*/
	Set <Employee> set =new HashSet<>();
	set.add(new Employee(203,"shamyy",20080,LocalDate.parse("2006-12-15")));
	set.add(new Employee(203,"shamyy",20080,LocalDate.parse("2006-12-15")));
	set.add(new Employee(201,"shamii",20060,LocalDate.parse("2008-12-15")));
	set.add(new Employee(202,"shamee",20060,LocalDate.parse("2008-12-15")));
	System.out.println("........Pring set.....");
	print(set);

	/*************************************/
	
	/* Java Streams * These are data in the collection which you can process in an efficient way (without changing the excising data structure)
	 with less code like filtering, sorting, transforming, iterating*/
	}
	
	public static void print(Collection<Employee> collection) {
		for(Employee e: collection) {
			System.out.println(e);
		}
	}
}
