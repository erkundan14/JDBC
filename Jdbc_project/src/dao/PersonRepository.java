package dao;

import java.sql.ResultSet;
import connection.Person_Connection;
import dto.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    Connection connection=null;
    Person_Connection person_connection=new Person_Connection();

   public void insertPerson(Person person){
       connection = person_connection.getConnection();
       String query="insert into person(id,name,age,address,email,phone) value(?,?,?,?,?,?)";
       try {
           PreparedStatement ps = connection.prepareStatement(query);
           ps.setInt(1,person.getId());
           ps.setString(2,person.getName());
           ps.setInt(3,person.getAge());
           ps.setString(4,person.getAddress());
           ps.setString(5,person.getEmail());
           ps.setLong(6,person.getPhone());
           ps.execute();
       }catch (SQLException e){
           throw new RuntimeException(e);
       }
   }
    public void updatePerson(int id,String name,int age){
       connection = person_connection.getConnection();
       String query="update Person set name=?,age=? where id=?";
       try {
           PreparedStatement ps=connection.prepareStatement(query);
           ps.setInt(3,id);
           ps.setString(1,name);
           ps.setInt(2,age);
           ps.execute();
       }
       catch (SQLException e){
           throw new RuntimeException(e);
       }
    }
    public void deletePerson(int id){
        connection = person_connection.getConnection();
        String query = "delete from Person where id=?";

       try {
           PreparedStatement ps=connection.prepareStatement(query);
           ps.setInt(1,id);
           ps.execute();
       }
       catch (SQLException e){
           throw new RuntimeException(e);
       }
    }
    public List<Person> getPersons(){
       connection = person_connection.getConnection();
        String query="select * from person";
       try {
           PreparedStatement ps=connection.prepareStatement(query);
           ResultSet resultset = ps.executeQuery();
           List<Person> list=new ArrayList<>();
           while (resultset.next()) {
               Person person=new Person();
               person.setId(resultset.getInt("id"));
               person.setName(resultset.getString("name"));
               person.setAge(resultset.getInt("age"));
               person.setAddress(resultset.getString("address"));
               person.setEmail(resultset.getString("email"));
               person.setPhone(resultset.getLong("phone"));
               list.add(person);
           }
           return list;
       }catch (SQLException e){
           throw new RuntimeException(e);
       }

    }
}
