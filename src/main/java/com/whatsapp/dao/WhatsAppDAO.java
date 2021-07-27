package com.whatsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsAppDAO implements WhatsAppDAOInterface {

	public int createProfileDAO(WhatsappUser ws) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","Dikhita");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1, ws.getName());
			ps.setString(2, ws.getPassword());
			ps.setString(3, ws.getEmail());
			ps.setString(4, ws.getAddress());
			//step 4 execute query
			
			i=ps.executeUpdate(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public WhatsappUser viewProfile(WhatsappUser ws) {
		WhatsappUser ww=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","Dikhita");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where email=?");
			ps.setString(1, ws.getEmail());
			
			//step 4 execute query
			
			ResultSet res=ps.executeQuery(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			if(res.next()) {
				ww=new WhatsappUser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ww;
	}

	public List<WhatsappUser> viewAllProfile() {
		List<WhatsappUser> ll=new ArrayList<WhatsappUser>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","Dikhita");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser");
			
			
			//step 4 execute query
			
			ResultSet res=ps.executeQuery(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			while(res.next()) {
				WhatsappUser ww=new WhatsappUser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
				
				ll.add(ww);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	public WhatsappUser searchProfile(WhatsappUser ws2) {
		WhatsappUser ww6=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","Dikhita");
        	PreparedStatement ps = con.prepareStatement("SElECT * FROM whatsappuser WHERE name=?");
        	ps.setString(1, ws2.getName());
        	
        	
        	ResultSet res = ps.executeQuery();
        	if(res.next())
        	{
        		 System.out.println("User Found --->");
			       ww6 = new WhatsappUser();
			       ww6.setName(res.getString(1));
				      ww6.setEmail(res.getString(2));
				      ww6.setAddress(res.getString(3));
				      ww6.setPassword(res.getString(4));
	        	}
	        	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ww6;
			      
	}

	public int deleteProfileDao(WhatsappUser ws3) {
		int j=0;
		try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","Dikhita");
    	PreparedStatement ps = con.prepareStatement("DELETE FROM whatsappuser WHERE email=? ");
    	ps.setString(1, ws3.getEmail());
    	//ps.setString(2, ws3.getName());
    	j = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return j;
	
		
	}

	public int editProfile(WhatsappUser ws5) {
		int e=0;
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","Dikhita");
    	PreparedStatement ps = con.prepareStatement("UPDATE whatsappuser SET name=?,address=?,password=?  WHERE email=?  ");
		
		ps.setString(1, ws5.getName());
		ps.setString(4, ws5.getEmail());
		ps.setString(2, ws5.getAddress());
		ps.setString(3, ws5.getPassword());
		
		e =ps.executeUpdate();
		
	}
catch(Exception es)
	{
		es.printStackTrace();
	}
	return e;
	}

}
