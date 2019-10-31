package edu.ssafy.model;

import java.util.ArrayList;

public class Manager {
	private static Manager man  = new Manager();
	private ArrayList<Member>mems = new ArrayList<>();
	
	private Manager() {
		
	}
	
	public Manager getInstance() {
		return man;
	}
	
	public void addMamber(String id, String name, String passwd) {
	}
}
