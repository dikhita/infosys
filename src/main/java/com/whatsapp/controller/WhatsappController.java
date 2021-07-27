package com.whatsapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.whatsapp.dao.WhatsAppDAO;
import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsappController implements WhatsappControllerinterface {
	
	private BufferedReader br;
	private WhatsAppDAOInterface wdao;
	
	public WhatsappController() {
		br=new BufferedReader(new InputStreamReader(System.in));
		wdao=new WhatsAppDAO();
	}
	

	public void createProfileController()throws Exception {
		System.out.println("enter your name");
		String name=br.readLine();
		
		System.out.println("enter your password");
		String password=br.readLine();
		
		System.out.println("enter your email");
		String email=br.readLine();
		
		System.out.println("enter your address");
		String address=br.readLine();
		
		WhatsappUser ws=new WhatsappUser();
		ws.setName(name);
		ws.setAddress(address);
		ws.setEmail(email);
		ws.setPassword(password);
		
		
		int i=wdao.createProfileDAO(ws);//we shoud transfer data from layer to layer via DTO(data transfer object) design pattern
		
		if(i>0) {
			System.out.println("registration success");
		}
		else {
			System.out.println("registration fail");
		}
		
		
		
		
	}

	public void viewProfileController() throws Exception{
		System.out.println("enter your email to view profile");
		String email=br.readLine();
		
		WhatsappUser ws=new WhatsappUser();
		ws.setEmail(email);
		
		WhatsappUser ww=wdao.viewProfile(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available for given email");
		}
		
		
		
		
	}

	public void deleteProfileController() throws Exception{
		System.out.println("Enter Profile  Email To Delete Profile");
		String ss = br.readLine();
		//System.out.println("Enter Profile  Email To Delete Profile");
		//String dd = b.readLine();
		WhatsappUser ws3 = new WhatsappUser();
		ws3.setEmail(ss);
		int j = wdao.deleteProfileDao(ws3);
		if(j>0)
		{
			System.out.println("Profile Deleted Successfully...");
		}
		else
		{
			System.out.println("Profile Doesn't Found....");
		}
	}

	public void viewAllProfileController() throws Exception{
		
		List<WhatsappUser> ww1=wdao.viewAllProfile();
		
		for(WhatsappUser ww:ww1) {
			System.out.println("******************************");
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
			System.out.println("******************************");
		}
		
		
		
		
	}

	public void searchProfileController() throws Exception{
		System.out.println("Enter Name TO Search Profile:");
		  String aa = br.readLine();
		  WhatsappUser ws2 =new WhatsappUser();
		  ws2.setName(aa);
		  WhatsappUser ww5 =  wdao.searchProfile(ws2);
		  if(ww5 != null)
		  {
			    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			    System.out.println("User Name is "+ww5.getName());
				System.out.println("User Email is "+ww5.getEmail());
				System.out.println("User Address is "+ww5.getAddress());
				System.out.println("User Password is "+ww5.getPassword());

		  }
	}

	public void editProfileController() throws Exception{
		System.out.println("Enter Your Email To Edit Profile:");
		String aa1 = br.readLine(); 
		System.out.println("Enter Your Password To Edit Profile:");
		String aa2 = br.readLine();
		 WhatsappUser ws4 = new WhatsappUser();
		 ws4.setEmail(aa1);
	    ws4.setPassword(aa2);
		WhatsappUser i=wdao.viewProfile(ws4);
		
		
		
		
		 WhatsappUser ws5 = new WhatsappUser();
		 ws5.setEmail(aa1);
       if(i!=null) {
        System.out.println("Enter Your New Name:");
		String aa3 = br.readLine();
		System.out.println("Enter Your New Address:");
		String aa5 = br.readLine();
		System.out.println("Enter Your New Password :");
		String aa6 = br.readLine();
       
        ws5.setName(aa3);
        ws5.setAddress(aa5);
        ws5.setPassword(aa6);
        int e = wdao.editProfile(ws5);
        if(e>0)
        {
        	System.out.println("Profile Edited Successfully...");
        }
        else
        {
        	System.out.println("Your Email or Password is Wrong. Please Try Again.");
        }
       }
       else {
    	   System.out.println("Profile not found.");
       }
		
	}

}
