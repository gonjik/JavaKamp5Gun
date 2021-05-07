package core.googleEmail;

import core.EMailService;
import webSiteEmail.GoogleMailManager;


public class GoogleMailManagerAdaptor implements EMailService {
	
	private GoogleMailManager googleMailManager;
	
	public GoogleMailManagerAdaptor() {
		googleMailManager = new GoogleMailManager();
	}
	
	@Override
	public void send(String email, String message) {
		googleMailManager.send(email, message);
	}
}
