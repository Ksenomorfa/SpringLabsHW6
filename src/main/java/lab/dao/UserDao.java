package lab.dao;

import java.util.List;

import lab.model.User;


public interface UserDao {
	
	void insert(User user);
	
	User select(int id);
	
	List<User> selectAll();
	
}
