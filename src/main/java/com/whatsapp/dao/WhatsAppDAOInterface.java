package com.whatsapp.dao;

import java.util.List;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsAppDAOInterface {

	int createProfileDAO(WhatsappUser ws);

	WhatsappUser viewProfile(WhatsappUser ws);

	List<WhatsappUser> viewAllProfile();

	WhatsappUser searchProfile(WhatsappUser ws2);

	int deleteProfileDao(WhatsappUser ws3);

	int editProfile(WhatsappUser ws5);

}
