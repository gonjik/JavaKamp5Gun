package core.amazonEmail;

import core.EMailService;
import webSiteEmail.AmazonMailManager;


public class AmazonMailManagerAdaptor implements EMailService{

		
		private AmazonMailManager amazonMailManager;
		
		public AmazonMailManagerAdaptor() {
			amazonMailManager = new AmazonMailManager();
		}
		
		@Override
		public void send(String email, String message) {
			amazonMailManager.send(email, message);
		}
	}