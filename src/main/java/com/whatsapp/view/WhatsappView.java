package com.whatsapp.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.whatsapp.controller.WhatsappControllerinterface;
import com.whatsapp.utility.ControllerFactory;

public class WhatsappView {

	public static void main(String[] args)throws Exception {
		System.out.println("*******************MAIN MENU****************");
		System.out.println("PRESS 1 TO CREATE PROFILE");
		System.out.println("PRESS 2 TO VIEW PROFILE");
		System.out.println("PRESS 3 TO DELETE PROFILE");
		System.out.println("PRESS 4 TO EDIT PROFILE");
		System.out.println("PRESS 5 TO SEARCH PROFILE");
		System.out.println("PRESS 6 TO VIEW ALL PROFILE");
		
		System.out.println("select your choice");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int c=Integer.parseInt(br.readLine());
		
		WhatsappControllerinterface wc=ControllerFactory.createObject();
		
		switch(c) {
		case 1 : wc.createProfileController();
			break;
		case 2 :wc.viewProfileController();
			break;
		case 3 :wc.deleteProfileController();
			break;
		case 4 :wc.editProfileController();
			break;
		case 5 :wc.searchProfileController();
			break;
		case 6 :wc.viewAllProfileController();
			break;
			default: System.out.println("wrong choice");
		}

	}

}
