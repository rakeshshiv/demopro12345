package com.crm.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchTheDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable 
	{
		Driver driver_ref = new Driver();
		DriverManager.registerDriver(driver_ref);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connect.createStatement();
		String query1 = "select * from project";
		ResultSet result1 = statement.executeQuery(query1);
		try {
		while (result1.next())
		{
		System.out.println(result1.getString(1)+" "+result1.getString(2));
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			connect.close();
		}

	}

}
