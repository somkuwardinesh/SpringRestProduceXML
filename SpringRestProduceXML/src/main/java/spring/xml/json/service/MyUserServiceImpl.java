package spring.xml.json.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.xml.json.dao.MyUserDao;
import spring.xml.json.model.MyUser;


public class MyUserServiceImpl implements MyUserService{

	@Autowired
	private MyUserDao myUserDAo;

	public void saveMyUser(MyUser myUser) {
		myUserDAo.saveMyUser(myUser);
	}

	public void updateMyUser(MyUser myUser) {
		myUserDAo.updateMyUser(myUser);
	}

	public List<MyUser> getMyUserList() {
		return myUserDAo.getMyUserList();
	}

	public MyUser findByID(long id) {
		return myUserDAo.findByID(id);
	}

	public MyUser findByName(String name) {
		return myUserDAo.findByName(name);
	}

	public void deleteMyUserById(long id) {
			myUserDAo.deleteMyUserById(id);		
	}


	
}
