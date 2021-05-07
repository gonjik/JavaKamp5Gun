
import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.amazonEmail.AmazonMailManagerAdaptor;
import core.googleEmail.GoogleMailManagerAdaptor;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		AuthManager authManager = new AuthManager(new UserManager(inMemoryUserDao,
				new GoogleMailManagerAdaptor()));
		
		
		
		User etem = new User(4,"Etem", "Derman", 
				"etem@gmail.com", "123456",true);
		
		authManager.register(etem);
		
		UserManager userManager = new UserManager(new InMemoryUserDao(),
				new GoogleMailManagerAdaptor());
	
		userManager.update(etem);

	}

}
