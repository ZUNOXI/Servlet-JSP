package edu.ssafy.model;

public class MemVO {
	private String id;
	private String name;
	private String pw;
	private String addr;
	private int age;
	private String tel;
	
	public MemVO(String id, String name, String pw, String addr, int age, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.addr = addr;
		this.age = age;
		this.tel = tel;
	}
	
	public MemVO() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public String toString() {
		return "MemManager [id=" + id + ", name=" + name + ", pw=" + pw + ", addr=" + addr + ", age=" + age + ", tel="
				+ tel + "]";
	}
	
}
