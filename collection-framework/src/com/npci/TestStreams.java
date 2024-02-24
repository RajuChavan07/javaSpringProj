package com.npci;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating an immutable list having some employees 
		List<Employee> employees = List.of(
				new Employee(500,"shami",50080,LocalDate.parse("2000-12-15")),
				new Employee(200,"shamii",60080,LocalDate.parse("2006-12-15")),
				new Employee(300,"shamiii",70080,LocalDate.parse("2007-12-15")),
				new Employee(600,"shamiiii",80080,LocalDate.parse("2008-12-15")),
				new Employee(700,"shamiiiii",90080,LocalDate.parse("2009-12-15")),
				new Employee(100,"shamy",10080,LocalDate.parse("2010-12-15")),
				new Employee(900,"shamyy",60080,LocalDate.parse("2011-12-15")),
				new Employee(800,"Raj",40080,LocalDate.parse("2012-12-15")),
				new Employee(800,"AmitRaj",40080,LocalDate.parse("2012-12-15"))
				);
		
		/* Stream make data processing simpler becox it works in -memory without changing the 
		existing data-stucture most of the stream method take functional interface - lamda
		filter(Consumer):Consumer has a method: boolean test(T t)
		*/
		// ForEach(Consumer):It is to iterate element: Cunsumer has method : void accept(T t)
		// forEach(x-> System.out.println(x)
		// Printing employees who have salary > 70k
		System.out.println("**************** sal > 70 *****************");
		employees.stream().filter(x -> x.getSalary() > 70000).forEach(x-> System.out.println(x));
		// Stream has not modified the exisitng data structure
		employees.forEach(x-> System.out.println(x));
		// converting or coping all the element to set: you must use collect method  collect(Collectors.toSet(), collect(Collectors.toList())
		System.out.println("**************** Coping the list  to set *****************");
		Set<Employee> empSet = employees.stream().collect(Collectors.toSet());
		System.out.println("**************** Print the set using forEach *****************");
		empSet.forEach(x-> System.out.println(x));
		// Apply multiple filters: filters: filter().filter().filter()
		//apply multiple filter: that gives emp having sal > 70k and doj > 2010
		System.out.println("**************** Filter. Filter *****************");
		employees.stream().filter(x -> x.getSalary() > 60000)
		.filter(x -> x.getDoj().getYear() > 2010).forEach(x-> System.out.println("filteer"+x));
		
		/*******************************************************/
		//*intermendiate operations filte, sort, map, givea new stream so that we can chain the method e.g stream().filter /.sorted().map()
		//*terminal operation : forEach, collect we cant chain eg. steam().forEach()
		//*filter(): condition ->get only those data
		//*sorted (): sorting logic using comparator
		//*map():transform a stream into another form
		//*collect: convert one collection to another
		//forEach(): itteration.
		/***********************************************************/
		//*map():transform a stream into another form
		// getting only name of the emp in seperatre list
		System.out.println("**************** Transform emp to stream *****************");
		// map(Function): Function has a method :R apply (T t) R and T is the diffrent 
		List<String> names = employees.stream().map(x->x.getName()).collect(Collectors.toList());
		names.forEach(x->System.out.print("\n"+x));
		
		System.out.println("\n"+"**************** Transform emp to Duble with increase in sal 10% *****************");
		List<Double> increseSal = employees.stream()
				.map(x-> x.getSalary()*1.1).collect(Collectors.toList());
		increseSal.forEach(x->System.out.print("\n"+x));
		
		// Applying map to get emp with increase sal by 10% in new list
		System.out.println("\n"+"**************** Transform emp to Duble with increase in sal 10% new list*****************");
		List<Employee> empwithIncrSal = employees.stream()
				.map(x-> new Employee (x.getId(),x.getName(),x.getSalary()*1.1, x.getDoj())).collect(Collectors.toList());
		empwithIncrSal.forEach(x->System.out.print("\n"+x));
		
		/* ***************************** Comparable vs Comparator **************************/
		//comparable : defualt shorting /natural order. e.g Integer, Double LocalDate i.e asc ord
		// must be implemented in same call that want to compare, method: compareTo(T t)
		//comparator: override the default sorting tech
		// method : compare(T t1, t2), implement in diff class {lambda for comparator}
		
		System.out.println("\n"+"*******Sorting emp with comparable *****");
		employees.stream().sorted().forEach(x -> System.out.print("\n"+x));   // excuted after impl Comparable with Employee class else below error
		// Employee cannot be cast to class java.lang.Comparable
		
		System.out.println("\n"+"*******Sorting emp with comparator  *****");
		employees.stream().sorted((x,y) -> x.getName().compareTo(y.getName()))
		.forEach(x->System.out.println(x));
	}

}
