package com.sp.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUserInput {
public static void main(String[] args) {
	try {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();
		sc.nextLine();
	
		System.out.println("Enter the name");
		String name=sc.nextLine();
		
		System.out.println("Enter the City Name");
		String city=sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_a3","root","73017");
		
		String insertQuery="Insert into student1(id,name,city)values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(insertQuery);
		 ps.setInt(1, id);
         ps.setString(2, name);
         ps.setString(3, city);

		ps.executeUpdate();
		
		System.out.println("Data Successfully Stored");
		con.close();
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		
		System.out.println("Data not Store");
	}
   }
}
