package com.cglia.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCount {
public static void main(String[] args) throws SQLException {
	 //Registering the Driver
    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    //Getting the connection
    String mysqlUrl = "jdbc:mysql://192.168.60.22:3306/habeeba";
    Connection con = DriverManager.getConnection(mysqlUrl, "HABEEBA", "HABEEBA@12345");
    System.out.println("Connection established......");
    //Creating the Statement object
    Statement stmt = con.createStatement();
    //Query to get the number of rows in a table
    String query = "select count(*) from user";
    //Executing the query
    ResultSet rs = stmt.executeQuery(query);
    //Retrieving the result
    rs.next();
    int count = rs.getInt(1);
    System.out.println("Number of records in the user table: "+count);
}
}
