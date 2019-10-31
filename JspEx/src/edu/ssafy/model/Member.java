package edu.ssafy.model;

public class Member {
	private String name;
	private String id;
	private String p;
	
	public Member(String name, String id, String p) {
		super();
		this.name = name;
		this.id = id;
		this.p = p;
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

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", p=" + p + "]";
	}
	
	
}
