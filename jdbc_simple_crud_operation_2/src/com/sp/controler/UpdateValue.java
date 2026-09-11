package com.sp.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateValue {
	public static void main(String[] args) {
		try {
			// 1. class Loader
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Create connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_a3","root","73017");
			
			// 3. Create PreparedStatement
			String updatequery=("Update student1 set city=? where id=?");
			PreparedStatement ps=con.prepareStatement(updatequery);
			
			// 4.set value
			ps.setString(1,"Delhi");
			ps.setInt(2,1);
			// 5. execute query
			int x=ps.executeUpdate();
			if(x==1) {
				System.out.println("Data Successfully Updated");
			}
			else {
				System.out.println("Data not Match");
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}

}
