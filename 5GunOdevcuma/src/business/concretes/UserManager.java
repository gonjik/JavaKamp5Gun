package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import core.EMailService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private EMailService eMailService;
	public UserManager(UserDao userDao, EMailService eMailService) {
		this.userDao = userDao;
		this.eMailService = eMailService;
	}

		
	@Override
	public void add(User user) {
		if(userValidate(user)) {
			userDao.add(user);
			
			eMailService.send(user.getEmail(), "kayýt baþarýlý");
		}
		
	}

	@Override
	public void update(User user) {
		if (userValidate(user)) {
			userDao.update(user);
		}
		
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Override
	public User get(String email) {

		return userDao.get(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getId() + " " + user.getEmail());
		}
		return userDao.getAll();
	}
	
	
	public boolean userValidate(User user) {
		if(user.getFirstName().length() >=2 && user.getLastName().length() >=2) {
			return true;
		}else {
		System.out.println("Ad ve Soyadýnýz en az 2 harf olmalýdýr. ");
		return false;
		}

	}

}
