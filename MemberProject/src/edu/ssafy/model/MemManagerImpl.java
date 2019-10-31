package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemManagerImpl implements IMemManager{
	private ArrayList<MemVO>list = new ArrayList<>();
	static PreparedStatement pt;
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	static String str;
	public MemManagerImpl() {}
	
	public boolean addMem(String id,String name, String pw, String addr, int age,String tel) {
		
		String str = "insert into memberweb(id,pw,name,age,addr,tel)values(?,?,?,?,?,?)";
		boolean res = false;
		
		try {
			conn = ConnectionProxy.getConnection();
			
			pt = conn.prepareStatement(str);
			pt.setString(1, id);
			pt.setString(2, pw);
			pt.setString(3, name);
			pt.setInt(4, age);
			pt.setString(5, addr);
			pt.setString(6, tel);
			res = pt.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	
	
	public boolean delMem(String id) {
		boolean res = false;
		String str = "delete from memberweb where id=?";
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
		}finally {
			close();
		}

		return res;
	}
	
	public boolean isLogin(String id, String pw) {
		String sql = "select * from memberweb where id = ? and pw = ?";
		boolean res=false;
		MemVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pw);
			rs = st.executeQuery();
			
			rs.last();
			int cnt = rs.getRow();
			if(cnt==1) {
				res = true;
			}
//			list = new ArrayList<>();
//			while (rs.next()) {
//				vo = new MemVO();
//				vo.setId(rs.getString("id"));
//				vo.setPw(rs.getString("pw"));
//				vo.setName(rs.getString("name"));
//				vo.setAge(rs.getInt("age"));
//				vo.setAddr(rs.getString("addr"));
//				vo.setTel(rs.getString("tel"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}
	
	public ArrayList<MemVO> nameFind(String name) {
        String str = "select * from memberweb";
        ArrayList<MemVO> list = null;
        try {
            conn = ConnectionProxy.getConnection();
            st = conn.prepareStatement(str);
            rs = st.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                MemVO vo = new MemVO();
                vo.setId(rs.getString("id"));
                vo.setName(rs.getString("name"));
                vo.setPw(rs.getString("pw"));
                vo.setAddr(rs.getString("addr"));
                vo.setAge(rs.getInt("age"));
                vo.setTel(rs.getString("tel"));
                
                if(vo.getName().equals(name) || name=="") {
                       list.add(vo);
                   }                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean updateMem(String id,String name, String pw, String addr, int age,String tel) {
		String str = "update memberweb set name=?,pw=?,age=?,addr=?,tel=? where id=?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(str);
			st.setString(1, name);
			st.setInt(2, age);
			st.setInt(3, age);
			st.setString(4, addr);
			st.setString(5, tel);
			st.setString(6, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
		}finally {
			close();
		}

		return res;
	}
	
	public ArrayList<MemVO> getList(){
		String sql = "select * from memberweb";
		ArrayList<MemVO> list = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				MemVO vo = new MemVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddr(rs.getString("addr"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public MemVO memInfo(String id) {
		System.out.println("헤헤");
		String sql = "select * from memberweb where id = ?";
		MemVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				vo = new MemVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddr(rs.getString("addr"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
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
