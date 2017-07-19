package spring.xml.json.service;

import java.util.List;

import spring.xml.json.model.MyUser;


public interface MyUserService {


	public void saveMyUser(MyUser myUser);
	
	public void updateMyUser(MyUser myUser);
	
	
	public List<MyUser> getMyUserList();

	public MyUser findByID(long id);
	
	public MyUser findByName(String name);
	
	
	public void deleteMyUserById(long id);	
	
	
}
