package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Report1;
import com.bean.Report2;
import com.bean.Report3;
import com.bean.User;

public class DatabaseDAO {
	
	
	
	//try{
		/*	System.out.println("Inside");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Class loaded");
		
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			System.out.println("Connection established" + conn);
			Statement statement = conn.createStatement();
		*/
			


		    public static Connection getConnection() throws SQLException,ClassNotFoundException {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
		    	String pass = "Tyga2018";
		        String userDB = "aa79444";
		        Connection conn = DriverManager.getConnection(
		                "jdbc:oracle:thin:@MSB-MSITM.austin.utexas.edu:1521:ORCL", userDB, pass);
		        System.out.println("connection established !!!");
		        return conn;
		    }
			
		    
		    public static User validateAdmin(String uname,String pwd) throws SQLException,ClassNotFoundException {
		        Connection conn = getConnection();
		        User user = null;
		        Statement st = conn.createStatement();
		        //PreparedStatement ps1 = conn.prepareStatement("{call employee_security.get_hash(?,?)}");
		        //ps1.setString(1, uname);
		        //ps1.setString(2, pwd);
		        //ResultSet rs1 =  ps1.executeQuery();
		        
		        //String hash_value = rs1.getString(1);
		        PreparedStatement ps = conn.prepareStatement("select * from employee where employee_name=?");
		        ps.setString(1, uname);
		       // ps.setString(2, hash_value);
		        
		        ResultSet rs =  ps.executeQuery();
		        
		        while(rs.next()){
		        	user = new User();
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2)); 
					System.out.println(rs.getString(3)); 
					System.out.println(rs.getString(4)); 
					
					user.setEmployeeId(rs.getString(1));
					user.setUserName(rs.getString(2));
					user.setUserPwd(rs.getString(3));
					user.setAdmin(rs.getString(4));
					
				}
		    	return user;

		    }
		  
		    public static void insertTxnDetails(String from,Integer to,String amount,String message)
		    		throws SQLException,ClassNotFoundException{
		    	System.out.println("Inside InserTxnDetails");
		    	Connection conn = getConnection();
		    	PreparedStatement pstmt = conn.prepareStatement("{call insert_employee_transaction(?,?,?,?,?)}");
		    	pstmt.setString(1, from);
		    	pstmt.setInt(2, to);
		    	pstmt.setString(3, amount);
		    	pstmt.setString(4, message);
		    	pstmt.setString(5,"");
		    	pstmt.executeQuery(); 
		    	System.out.println("Succesful excecution insert_employee_transaction");
		    	PreparedStatement pstmt1 = conn.prepareStatement("{call given_and_received_proc(?,?,?)}");
		    	pstmt1.setString(1, from);
		    	pstmt1.setInt(2, to);
		    	pstmt1.setString(3, amount);
		    	pstmt1.executeQuery();
		    	System.out.println("Succesful excecution given_and_received_proc ");

		    }
		    
		    
		    public static String getRedeemPoints(String empId)
					throws SQLException,ClassNotFoundException{
				
				System.out.println("Inside getRedeemPoints");
		    	Connection conn = getConnection();
		    	String left_points = null;
		    	ResultSet rs = null;
		    	PreparedStatement pstmt = conn.prepareStatement("{call redeem_points(?)}");
		    	pstmt.setString(1, empId);
		    	
		    	pstmt.executeQuery();
		    	
		    	PreparedStatement pstmt2 = conn.prepareStatement("select Received_Points from employee_balance where EMPLOYEE_ID="+empId);
		    	rs = pstmt2.executeQuery();
		    	while(rs.next()){
		    		left_points = rs.getString(1);
		    	}
		    	return left_points;
			}
		    
		    
		    public static boolean adminReset()
		    		throws SQLException,ClassNotFoundException{
			 
		    	System.out.println("Inside adminReset");
		    	String abc = "abc";
		    	Connection conn = getConnection();
		    	PreparedStatement pstmt = conn.prepareStatement("{call admin_reset}");

		    
		    	boolean flag = pstmt.execute(); 
		    	if(flag)
		    		System.out.println("Succesful excecution");
		    	else
		    		System.out.println("Failed to execute admin_reset");
		    
		    	return true;
		    }
			
			//	ResultSet rs = statement.executeQuery("select * from Employee where UNAME=\'"+uname+"\'");
			//	ResultSet rs = statement.executeQuery(query);
			
		    public static ArrayList<User> getAllUsersDetails() 
						throws SQLException,ClassNotFoundException {
					ArrayList<User> users = new ArrayList<User>();
					String sql = "select * from Employee";
					Connection conn = getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						User user = new User();
						user.setEmployeeId(rs.getString(1));
						user.setUserName(rs.getString(2));
						user.setUserPwd(rs.getString(3));
						user.setAdmin(rs.getString(4));
						users.add(user);
					}
					return users;
				}
				
			
			public static ArrayList<Report1> getReport1()
					throws SQLException,ClassNotFoundException{
				ArrayList<Report1> reports1 = new ArrayList<Report1>();
				String sql =  "SELECT * from Report_1";
						
						
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
				Report1 rep = new Report1();
				System.out.println(rs.getString(2));
				rep.setAssociate(rs.getString(1));
				rep.setRewardGiven(rs.getString(2));
				rep.setRewardRecieved(rs.getString(3));
				rep.setMonthlyReport(rs.getString(4));
				//rep.setRank(rs.getString(5));
				reports1.add(rep);
				}
				return reports1;
			}
			
			public static ArrayList<Report2> getReport2()
					throws SQLException,ClassNotFoundException{
				ArrayList<Report2> reports2 = new ArrayList<Report2>();
				String sql =  "SELECT * from Report_2";
						
						
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
				Report2 rep2 = new Report2();
				System.out.println(rs.getString(1));
				rep2.setEmpId(rs.getString(1));
				rep2.setStatusMessage(rs.getString(2));
				
				//rep.setRank(rs.getString(5));
				reports2.add(rep2);
				}
				return reports2;
			}
			
			public static ArrayList<Report3> getReport3()
					throws SQLException,ClassNotFoundException{
				ArrayList<Report3> reports3 = new ArrayList<Report3>();
				String sql =  "SELECT * from Report_3";
						
						
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
				Report3 rep3 = new Report3();
				System.out.println(rs.getString(1));
				rep3.setEmpId(rs.getString(1));
				rep3.setTotalRedemption(rs.getString(2));
				rep3.setMonth(rs.getString(3));
				
				//rep.setRank(rs.getString(5));
				reports3.add(rep3);
				}
				return reports3;
			}
	 
	}

