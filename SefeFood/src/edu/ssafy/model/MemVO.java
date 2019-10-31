package edu.ssafy.model;

public class MemVO {
	private String userid;
	private String pwd;
	private String name;
	private String addr;
	private String phone;
	private String allergy;
	public MemVO() {}
	
	public MemVO(String userid, String pwd, String name, String addr, String phone, String allergy) {
		super();
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.allergy = allergy;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	@Override
	public String toString() {
		return "MemVO [userid=" + userid + ", pwd=" + pwd + ", name=" + name + ", addr=" + addr + ", phone=" + phone
				+ ", allergy=" + allergy + "]";
	}
	
	
}
