package com.rmit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VotingDBAccess 
{
	private static Connection conObj;
	
	static
	{
		try 
		{
			initializeConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void initializeConnection() throws Exception
	{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String userName = "Chris";
        String password = "chris123";
        String server = "CHRIS\\SQLEXPRESS";
        String port = "1433";
        String user = "Chris";
        String database = "VotingSystem";
        String jdbcUrl = "jdbc:sqlserver://" + server + ":" + port + ";user=" + user + ";password=" + password + ";databasename=" + database + "";
        conObj = DriverManager.getConnection(jdbcUrl, userName, password);
	}
	
	public static ResultSet getQuery(String queryText) throws Exception
	{
		 PreparedStatement ps = conObj.prepareStatement(queryText);
         ResultSet rs = ps.executeQuery();
         return rs;
	}
	
	public static int insertQuery(String queryText) throws Exception
	{
		 PreparedStatement ps = conObj.prepareStatement(queryText);
         return ps.executeUpdate();
	}
}
