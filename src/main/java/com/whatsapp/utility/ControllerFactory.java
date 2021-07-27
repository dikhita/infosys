package com.whatsapp.utility;

import com.whatsapp.controller.WhatsappController;
import com.whatsapp.controller.WhatsappControllerinterface;

public class ControllerFactory {

	public static WhatsappControllerinterface createObject() {
		// TODO Auto-generated method stub
		return new WhatsappController();
	}

}
