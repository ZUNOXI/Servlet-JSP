package edu.ssafy.model;

public class Member {
	private String name;
	private String id;
	private String passwd;
	public Member(String name, String id, String passwd) {
		super();
		this.name = name;
		this.id = id;
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", passwd=" + passwd + "]";
	}
	
	
}
