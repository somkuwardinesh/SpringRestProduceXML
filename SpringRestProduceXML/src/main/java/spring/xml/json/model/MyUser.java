package spring.xml.json.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "user")
public class MyUser  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	@Column
	private long mobileNo;

	@Column
	private String city;

	@Transient
	List<MyUser> myUserList = new ArrayList<MyUser>();
	
	public MyUser() {
	}

	public MyUser(long id, String name, long mobileNo, String city) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<MyUser> getMyUserList() {
		return myUserList;
	}

	public void setMyUserList(List<MyUser> myUserList) {
		this.myUserList = myUserList;
	}

}


