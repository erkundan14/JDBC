package com.sp.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection
{
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_a3","root","73017");

            Statement st = con.createStatement();

            int x = st.executeUpdate("insert into student1(id,name,city) values(2,'kunal','up')");

            System.out.println(x + " Data stored Successful");

            con.close();
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            System.out.println("Data not stored");
        }
    }
}