package edu.ssafy.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemManager {

	public boolean addMem(String userid, String pwd, String name, String addr, String phone, String allergy);
	
	
	public boolean delMem(String userid);
	
	public boolean isLogin(String userid, String pwd) ;
	
	public ArrayList<MemVO> nameFind(String userid);
	
	public boolean updateMem(String userid, String pwd, String name, String addr, String phone, String allergy);
	
	public ArrayList<MemVO> getList();
	
	public MemVO memInfo(String userid) ;
	
	public void close();
}
