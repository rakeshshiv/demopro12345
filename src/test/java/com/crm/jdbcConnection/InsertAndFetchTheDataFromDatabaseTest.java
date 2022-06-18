package com.crm.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertAndFetchTheDataFromDatabaseTest 
{
	public static void main(String[] args) throws Throwable {
		Driver driver_ref = new Driver();
		DriverManager.registerDriver(driver_ref);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connect.createStatement();
		String query = "insert into project values('TY_PROJ_005','Realiaaaa','03/06/2022','rakiiii','created','5')";
		int result = statement.executeUpdate(query);
		try {
			if(result==1)
			{
				System.out.println("updated");
			}
			else
			{
				System.out.println("not updated");
			}}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally 
		{
			connect.close();
		
		}
		
	}
}
