package com.capgemini.admin.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdata")
public class Userdata implements Serializable{
	@Id
	@Column(name="user_id",length=7)
	private int userid;
	
	@Column(name="user_name",length=15)
	private String username;
	
	@Column(name="user_type",length=9)
	private String usertype;
	
	@Column(name="user_password",length=15)
	private String userpassword;
	
	@Column(name="user_phone",length=12)
	private long userphone;
	
	@Column(name="user_email",length=25)
	private String useremail;
	
	public Userdata() {
		
	}

	public Userdata(int userid, String username, String usertype, String userpassword, long userphone,
			String useremail) {
		super();
		this.userid = userid;
		this.username = username;
		this.usertype = usertype;
		this.userpassword = userpassword;
		this.userphone = userphone;
		this.useremail = useremail;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public long getUserphone() {
		return userphone;
	}

	public void setUserphone(long userphone) {
		this.userphone = userphone;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
}
