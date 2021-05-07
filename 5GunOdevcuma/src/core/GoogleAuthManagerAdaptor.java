package core;

import business.abstracts.UserService;
import entities.concretes.LoginDto;
import entities.concretes.User;

public class GoogleAuthManagerAdaptor implements ExternalAuthService{

	private UserService userService;
	
	
	
	public GoogleAuthManagerAdaptor(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(String email) {
		if(userExists(email)==false) {
			userService.add(null);
			
		}else {
			User user = userService.get(email);
			
			LoginDto dto = new LoginDto();
			dto.setPassword(user.getPassword());
			dto.setEmail(user.getEmail());
		}
		
	}

	@Override
	public boolean userExists(String email) {
		if (userService.get(email)!=null) {
			return true;
			
		} return false;
		
	}

	@Override
	public void login(LoginDto dto) {
		if(dto!=null && dto.getPassword().equals(dto.getPassword())) {
		System.out.println("Ba�ar�yla giri� yapt�n�z.");
	}
		else {
			System.out.println("Kullan�c� ad� veya �ifre yanl��.");
		}
	}
}
