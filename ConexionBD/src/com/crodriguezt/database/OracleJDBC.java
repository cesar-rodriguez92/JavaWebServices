package com.crodriguezt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class OracleJDBC {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = null;
			String user = "system";
			String pass = "oracle";
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.71:1521:XE", user, pass);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String args[]) {
		Connection conn;
		Statement stmt = null;
		String SQL = "select * from hr.employees";
		ResultSet rs = null;
		ResultSetMetaData rsmd=null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while(rs.next()){
//				String firstName = rs.getString("FIRST_NAME");
//				String lastName = rs.getString("LAST_NAME");
//				String salary = rs.getString("salary");
//				System.out.println("-->\t" + firstName + " " +lastName + "\tearns:\t"+ salary);
				for (int i = 1; i < columnsNumber; i++) {
					if (i>1)System.out.print(",\t"); {
						String columnValue = rs.getString(i);
						System.out.print(columnValue + " " + rsmd.getColumnName(i));
					}
				}
				System.out.println("");
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
