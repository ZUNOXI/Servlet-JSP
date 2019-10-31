package edu.ssafy.model;

import java.util.ArrayList;

public class Manager {
	private static Manager man = new Manager();
	private ArrayList<Member> list = new ArrayList<>();
	
	private Manager() {
		
	}
	public static Manager getInstance() {
		return man;
	}
	public boolean addManber(String id, String name, String passwd) {
		list.add(new Member(name,id,passwd));
		return true;
	}
	
	public boolean findId(String id, String passwd) {
		for (Member member : list) {
			if(member.getId().equals(id)&& member.getPasswd().equals(passwd) ) {
				return true;
			}
		}
		return false;
	}
}
