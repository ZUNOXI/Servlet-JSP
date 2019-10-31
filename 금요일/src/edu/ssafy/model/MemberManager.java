package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
	static PreparedStatement pt;
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	
	public boolean addMember(MemberVO memberVO) {
		
		String str = "insert into members(name,userid,pwd,email,phone,admin)values(?,?,?,?,?,?)";
		boolean res = false;
		int result = 0;
		try {
			conn = ConnectionProxy.getConnection();
			
			pt = conn.prepareStatement(str);
			pt.setString(1, memberVO.getName());
			pt.setString(2, memberVO.getUserid());
			pt.setString(3, memberVO.getPwd());
			pt.setString(4, memberVO.getEmail());
			pt.setString(5, memberVO.getPhone());
			pt.setInt(6, memberVO.getAdmin());
			result = pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result>0? true:false;
	}
	
	public MemberVO getMember(String userid) {
		String sql = "Select*From members WHERE userid = ?";
		MemberVO memberVO = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			pt = conn.prepareStatement(sql);
			pt.setString(1, userid);
			rs = pt.executeQuery();
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setName(rs.getString("name"));
				memberVO.setUserid(rs.getString("userid"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setAdmin(rs.getInt("admin"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return memberVO;
	}
	
	public List<MemberVO>getMemberList(){
		String sql = "Select*From members";
		MemberVO memberVO = null;
		List<MemberVO>memberList = new ArrayList<>();
		try {
			conn = ConnectionProxy.getConnection();
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			while(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setName(rs.getString("name"));
				memberVO.setUserid(rs.getString("userid"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setAdmin(rs.getInt("admin"));
				memberList.add(memberVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return memberList;
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
