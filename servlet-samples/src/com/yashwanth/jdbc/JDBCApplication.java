package com.yashwanth.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCApplication {
	public static void main(String[] args) {
		
		try {
			
			Connection con=DriverManager.getConnection("jdbc:sqlserver://ggku2ser6;databaseName=Yashwanth","jdbcsamples","jdbcsamples@1");
			
			 // connection success
			System.out.println("connection success");
			
			Statement statement;
			PreparedStatement preparedStatement;
			ResultSet result;
			boolean executionStatus;
			int effectedRows;
			
			
			/*
			 * STATEMENT
			 */
			
			statement=con.createStatement();
			statement.execute( 
					"CREATE TABLE [dbo].[Products](" + 
					"	[id] [int] IDENTITY(1,1) NOT NULL," + 
					"	[productName] [varchar](20) NOT NULL," + 
					"	[price] [int] NOT NULL," + 
					"	[category] [int] NOT NULL)");
			
			//--------INSERT_STATEMENT-------//
			
			statement.execute("INSERT INTO dbo.Products values('Dell inspiron',25000,2)");
			System.out.println("Inserted Dell inspiron into prodcuts");
			
			//--------READ_STATEMENT-------//
			
			result=statement.executeQuery("SELECT * FROM Products WHERE category=2");
			while(result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2));
			}
			
			//--------UPDATE_STATEMENT-------//
			
			executionStatus=statement.execute("UPDATE Products set productName='DELL Inspiron' where id=1");
			if(executionStatus) 	
				System.out.println("Updated Products on id=1");
			else 
				System.out.println("No records found for DELL Inspiron");
			
			//--------DELETE_STATEMENT-------//
			
			effectedRows=statement.executeUpdate("DELETE FROM Products where id=1");
			if(effectedRows>0)
				System.out.println("Records of DELL Inspisron are deleted");
			else 
				System.out.println("No records found for DELL Inspiron");
			
			
			
			/*
			 * PREPARED STATEMENT 
			 */
			
			//--------INSERT_CREATE_STATEMENT-------//
			
			
			preparedStatement=con.prepareStatement("INSERT INTO Products values(?,?,?)");
			for(Product p:Db.products) {
				 preparedStatement.setString(1, p.getProductName()); 
				 preparedStatement.setInt(2, p.getPrice());
				 preparedStatement.setInt(3, p.getCategory());
				 preparedStatement.execute();
			}
			
			//--------READ_CREATE_STATEMENT-------//
			
			preparedStatement=con.prepareStatement("SELECT * FROM Products WHERE category=?");
			preparedStatement.setInt(1, 2);
			result=preparedStatement.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2));
			}
			
			int id=1;
			String oldName="DELL Inspiron";
			
			//--------UPDATE_CREATE_STATEMENT-------//
			
			preparedStatement=con.prepareStatement("UPDATE Products SET productName=? WHERE id=?");
			preparedStatement.setInt(2, 1);
			preparedStatement.setString(1, oldName);
			executionStatus=preparedStatement.execute();
			if(executionStatus) 
				System.out.println("Updated Products on id="+id);
			else 
				System.out.println("No records found for id "+id);
			
			//--------DELETE_CREATE_STATEMENT-------//
			
			preparedStatement=con.prepareStatement("DELETE FROM Products where id=?");
			preparedStatement.setInt(1, 1);
			effectedRows=preparedStatement.executeUpdate();
			if(effectedRows>0)
				System.out.println("Records of DELL Inspisron are deleted");
			else 
				System.out.println("No records found for DELL Inspiron");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
