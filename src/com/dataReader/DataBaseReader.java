package com.dataReader;

import com.codingTask.ReadTheseFiles;
import java.sql.*;
public class DataBaseReader implements ReadTheseFiles {

	@Override
	public void Read(String loc) {
		try {
			Connection myConn = DriverManager.getConnection(loc,"root","1995");
			Statement mysqlSTM = myConn.createStatement();
			//ResultSet retRes = mysqlSTM.executeQuery("SELECT * FROM coding_task_db.student_info;")
			  ResultSet retRes = mysqlSTM.executeQuery("SELECT * FROM student_info;");
			  while(retRes.next()) {
				  System.out.println(retRes.getString("id")+" "+retRes.getString("fname")
						  			+retRes.getString("lname")+" "+retRes.getString("gender")
						  			+retRes.getString("school"));
			  }
		} catch (SQLException e) {
			System.out.println("mysql driver not found");
		}
	}

	@Override
	public void Print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Save() {
		// TODO Auto-generated method stub
		
	}

}
