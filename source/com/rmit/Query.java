package com.rmit;

public class Query 
{
	public static final String GET_USER_BY_GIVEN_NAME = "SELECT "
			+ "GIVEN_NAME, "
			+ "FAMILY_NAME, "
			+ "USERNAME, "
			+ "PASSWORD, "
			+ "ADDRESS, "
			+ "CREATED_USER, "
			+ "CREATED_DATE, "
			+ "MODIFIED_USER, "
			+ "MODIFIED_DATE, "
			+ "PHONE_NUMBER FROM USERS ";
	
	public static final String INSERT_USER = "INSERT INTO USERS ("
			+ "GIVEN_NAME, "
			+ "FAMILY_NAME, "
			+ "USERNAME, "
			+ "PASSWORD, "
			+ "ADDRESS, "
			+ "PHONE_NUMBER, "
			+ "CREATED_USER, "
			+ "CREATED_DATE, "
			+ "MODIFIED_USER, "
			+ "MODIFIED_DATE) VALUES ( ";
}
