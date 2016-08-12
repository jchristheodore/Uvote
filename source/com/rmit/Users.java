package com.rmit;

import java.sql.ResultSet;
import java.sql.Date;

public class Users 
{
	/*public static void main(String[] args) throws Exception
	{
		System.out.println("Enter User GivenName: ");
		Scanner scan = new Scanner(System.in);
		String givenName = scan.next();
		System.out.println("Enter User FamilyName: ");
		Scanner scan2 = new Scanner(System.in);
		String familyName = scan2.next();
		System.out.println("Enter User Address: ");
		Scanner scan3 = new Scanner(System.in);
		String address = scan3.next();
		System.out.println("User in DB: "+insertUserInDB(givenName,familyName,address,0));
	}*/
	
	public static boolean checkIfUserExists(String givenName, String familyName) throws Exception
	{
		String queryText = Query.GET_USER_BY_GIVEN_NAME;
		boolean conditionSet = false;
		if(!Util.isNullorEmpty(givenName))
		{
			queryText += "WHERE LOWER(GIVEN_NAME) LIKE LOWER('%"+givenName.trim()+"%') ";
			conditionSet = true;
		}
		if(!Util.isNullorEmpty(familyName))
		{
			if(conditionSet)
			{
				queryText += "AND LOWER(FAMILY_NAME) LIKE LOWER('%"+familyName.trim()+"%')";
			}
			else
			{
				queryText += "WHERE LOWER(FAMILY_NAME) LIKE LOWER('%"+familyName.trim()+"%')";
				conditionSet = true;
			}
		}
		//System.out.println("Executed Query is : "+queryText);
		ResultSet rsObj = VotingDBAccess.getQuery(queryText);
		while(rsObj.next())
		{
			String userGivenName = rsObj.getString("GIVEN_NAME").toLowerCase();
			String userFamilyName = rsObj.getString("FAMILY_NAME").toLowerCase();
			if((!Util.isNullorEmpty(givenName) && userGivenName.toLowerCase().contains(givenName.toLowerCase().trim())) 
					|| (!Util.isNullorEmpty(familyName) && userFamilyName.contains(familyName.trim())))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean validateUser(String userName, String password) throws Exception
	{
		String queryText = Query.GET_USER_BY_GIVEN_NAME;
		if(!Util.isNullorEmpty(userName) && !Util.isNullorEmpty(password))
		{
			queryText += "WHERE LOWER(USERNAME) LIKE LOWER('%"+userName.trim()+"%') "
					  + "AND LOWER(PASSWORD) LIKE LOWER('%"+password.trim()+"%')";
		}
		else
		{
			throw new Exception("Username & Password is Mandatory.");
		}
		//System.out.println("Executed Query is : "+queryText);
		ResultSet rsObj = VotingDBAccess.getQuery(queryText);
		while(rsObj.next())
		{
			String username = rsObj.getString("USERNAME").toLowerCase();
			String passwordValue = rsObj.getString("PASSWORD").toLowerCase();
			if((!Util.isNullorEmpty(username) && username.toLowerCase().contains(userName.toLowerCase().trim())) 
					|| (!Util.isNullorEmpty(passwordValue) && passwordValue.contains(password.trim())))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean insertUserInDB(String givenName, String familyName, String address, 
			int phoneNumber, String username, String password) throws Exception
	{
		String queryText = Query.INSERT_USER;
		if(!Util.isNullorEmpty(givenName) && !Util.isNullorEmpty(familyName) 
				&& !Util.isNullorEmpty(address))
		{
			queryText += "'"+givenName+"','"+familyName+"','"+username+"','"+password+"','"+address+"','"+phoneNumber+"',";
			queryText +="'Admin',"+new Date(System.currentTimeMillis())+",'Admin',"+new Date(System.currentTimeMillis())+")";
		}
		else
		{
			throw new Exception("Given Name, Family Name, Address and Phone Number is Mandatory.");
		}

		//System.out.println("Executed Query is : "+queryText);
		if(VotingDBAccess.insertQuery(queryText) == 1)
		{
			return true;
		}
		return false;
	}
}
