package com.sp.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletevValue {
public static void main(String[]args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_a3","root","73017");
		 
		 String deletequery=("delete from student1 where id=? ");
		 PreparedStatement ps=con.prepareStatement(deletequery);
		 
		 ps.setInt(1, 1);
		 
		 int x=ps.executeUpdate();
		 
		 if(x==1) {
			 System.out.println("Deta Successfully Deleted!");
		 }else {
			 System.out.println("Data not Found");
		 }
		 con.close();
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
}
