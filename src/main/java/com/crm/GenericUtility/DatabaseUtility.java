package com.crm.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	Connection con=null;
	/**
	 * This method is used to register and get connection for database
	 * @author Admin
	 * @throws SQLException
	 */
	public void getconnectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbUrl, IPathConstants.dbUsername, IPathConstants.dbPassword);
	}

	/**
	 *This method is used to execute query 
	 * @param query
	 * @param colomNo
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQuery(String query, int columnNo, String expData) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actdata = result.getString(columnNo);
			if(actdata.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("---Data is Fetched----");
			return expData;
		}
		else {
			System.out.println("----Data is not present----");
			return "";
		}
	}
	/**
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}
