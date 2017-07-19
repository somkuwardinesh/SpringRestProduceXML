package spring.xml.json.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import spring.xml.json.model.MyUser;
import spring.xml.json.service.MyUserService;

@RestController
public class XMLController {

	@Autowired
	MyUserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = {
			"Accept=application/xml", "Content-Type=application/xml" })
	public MyUser getAllUser() {
		List<MyUser> list = userService.getMyUserList();
		MyUser user = new MyUser();
		user.setMyUserList(list);
		return user;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = {
			"Accept=application/xml", "Content-Type=application/xml" })
	public ResponseEntity<MyUser> getUser(@PathVariable("id") long id) {

		MyUser myUser = userService.findByID(id);
		if (myUser == null) {
			return new ResponseEntity<MyUser>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<MyUser>(myUser, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = {
			"Accept=application/xml", "Content-Type=application/xml" })
	public ResponseEntity<Void> addUser(@RequestBody MyUser myUser,
			UriComponentsBuilder builder)// @ResponseBody
	{
		if (myUser.getName() == null && myUser.getCity() == null
				&& myUser.getMobileNo() == 0) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			userService.saveMyUser(myUser);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/")
					.buildAndExpand(myUser.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/user/{ID}", method = RequestMethod.PUT, headers = {
			"Accept=application/xml", "Content-Type=application/xml" })
	public ResponseEntity<MyUser> updateUser(@PathVariable("ID") long id,
			@RequestBody MyUser myUser)// @ResponseBody
	{
		MyUser user = userService.findByID(id);
		if (user == null) {
			return new ResponseEntity<MyUser>(HttpStatus.NOT_FOUND);
		}

		user.setName(myUser.getName());
		user.setMobileNo(myUser.getMobileNo());
		user.setCity(myUser.getCity());
		userService.updateMyUser(user);
		return new ResponseEntity<MyUser>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{ID}", method = RequestMethod.DELETE, headers = {
			"Accept=application/xml", "Content-Type=application/xml" })
	public ResponseEntity<MyUser> deleteUser(@PathVariable("ID") long id) {
		MyUser myUser = userService.findByID(id);
		if (myUser == null) {
			return new ResponseEntity<MyUser>(HttpStatus.NOT_FOUND);
		}
		userService.deleteMyUserById(id);
		return new ResponseEntity<MyUser>(myUser, HttpStatus.OK);
	}

}
