package com.npci.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.Driver;

import com.npci.beans.Profile;

public class TestDB {
	
	public static void main(String[] args) {
		// storing records with for loop
		/*
		 * for(int i=0; i<=5; i++) { Profile p= new Profile("Profile:"+i, 9345345*i,
		 * LocalDate.now()); int status = save(p);
		 * System.out.println("******** "+status+" row created"); }
		 */
		
		// 
		
		System.out.println("***************retriving List of all records**********");
		List<Profile> list =findAll();
		list.forEach(item -> System.out.println("ID:"+item.getId()+"\tName:"+item.getName()+"\tPhone Numbers:"+item.getPhone()+"\tDate of birth"+item.getDob()));
		
	}
	// Retrive: Find all method
	
	public static List<Profile> findAll() {
		List <Profile> list = new ArrayList();
		
		try {
			Class.forName(Driver.class.getName());  // else can use forName("org.postgresql.Driver")
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/npci_db","postgres","Welcome@2024");
					String sqlQuery ="select * from profile";		
					PreparedStatement ps=con.prepareStatement(sqlQuery);		
					ResultSet result = ps.executeQuery();
					  while(result.next()){
						   Profile profile = new Profile(
								   result.getString(2),result.getLong(3),result.getDate(4).toLocalDate());
						   profile.setId(result.getInt(1));
						   list.add(profile);
						 }
					ps.close();
					con.close();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/*String query = "select * from profile";
	   PrepareStament statement = connection.prepareStatement(query);
	   ResultSet result =statement.execureQuery();
	
	 * while(result.next()){
	 *  Profile p = new Profile(result.getString(2),result.getLong(3),result.getDate(4).toLocalDate());
	 *  p.setId(result.getInt(1);
	 *  list.add(p);
	 * }
	 */	
	// a save method that accepts profile obj to store in the db
	public static int save(Profile profile) {
		// intially save return 0 returns the number rows updated
		int count =0;
		//now we must load the driver, establish connection, prepare statement and run query
		try {
			Class.forName(Driver.class.getName());  // else can use forName("org.postgresql.Driver")
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/npci_db","postgres","Welcome@2024");
		String sqlQuery ="insert into profile(name, phone, dob)values(?,?,?)";
		
					PreparedStatement ps=con.prepareStatement(sqlQuery);		
					ps.setString(1, profile.getName());
					ps.setLong(2, profile.getPhone());
					ps.setDate(3, Date.valueOf(profile.getDob()));
					
					count = ps.executeUpdate();
					ps.close();
					con.close();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
