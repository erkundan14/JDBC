package com.sp.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayValue {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_a3","root","73017");
		
		PreparedStatement ps=con.prepareStatement("select * from student1");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) 
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String city=rs.getString("city");
			
			System.out.println(id+" "+name+" "+city);
		}
		con.close();
	}
	  catch(ClassNotFoundException | SQLException e) {
		  e.printStackTrace();
      }
	}
}

