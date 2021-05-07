package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao{

	private List<User> users = new ArrayList<User>();

	public InMemoryUserDao() {
		User user1 = new User(1, "Gonca", "Derman",
				"gonca@gmail.com", "123456", true);
		User user2 = new User(1, "Engin", "Demiroð",
				"engin@gmail.com", "567089", true);
		User user3 = new User(1, "Ateþ", "Derman",
				"ates@gmail.com", "123045", true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	
	@Override
	public void add(User user) {
		System.out.println("Kaydedildi : " + user.getEmail());
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		User userUpdate = users.stream()
				.filter(u->u.getId()==user.getId())
				.findFirst()
				.orElse(user);
		
		userUpdate.setEmail(user.getEmail());
		userUpdate.setFirstName(user.getFirstName());
		userUpdate.setLastName(user.getLastName());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setVerify(user.isVerify());
		
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u->u.getId()==userId)
				.findFirst()
				.orElse(null);
		users.remove(userToDelete);
		
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u -> u.getEmail()==email)
				.findFirst()
				.orElse(null);
		return user;
	}
}
