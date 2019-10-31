package edu.ssafy.model;

import java.util.ArrayList;

public class MemManager {
	private ArrayList<MemVO>list = new ArrayList<>();
	private static MemManager man = new MemManager();
	public MemManager() {}
//	public static MemManager getInstance() {
//		return man;
//	}
	
	public boolean addMem(String id,String name, String pw, String addr, int age,String tel) {
		list.add(new MemVO(id,name,pw,addr,age,tel));
		return true;
	}
	
	public boolean delMem(String id) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
			}
		}
		return true;
	}
	
	public boolean updateMem(String id,String name, String pw, String addr, int age,String tel) {
		
		return true;
	}
	
	public ArrayList<MemVO> getList(){
		return list;
	}
	
	public MemVO memInfo(String id) {
		for(MemVO memVO : list) {
			if(memVO.getId().equals(id)) {
				return memVO;
			}
		}
		return null;
	}
}
