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
	
	public boolean addMem(String userid, String pwd, String name, String addr, String phone, String allergy) {
		System.out.println(userid+""+pwd+""+name+""+addr+""+phone+""+allergy);
		String str = "insert into members(userid,pwd,name,addr,phone,allergy)values(?,?,?,?,?,?)";
		boolean res = false;
		
		try {
			conn = ConnectionProxy.getConnection();
			
			pt = conn.prepareStatement(str);
			pt.setString(1, userid);
			pt.setString(2, pwd);
			pt.setString(3, name);
			pt.setString(4, addr);
			pt.setString(5, phone);
			pt.setString(6, allergy);
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
	
	
	
	public boolean delMem(String userid) {
		boolean res = false;
		String str = "delete from members where userid=?";
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(str);
			st.setString(1, userid);
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
	
	public boolean isLogin(String userid, String pwd) {
		String sql = "select * from members where userid = ? and pwd = ?";
		boolean res=false;
		MemVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, pwd);
			rs = st.executeQuery();
			
			rs.last();
			int cnt = rs.getRow();
			if(cnt==1) {
				res = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}
	
	public ArrayList<MemVO> nameFind(String name) {
        String str = "select * from members";
        ArrayList<MemVO> list = null;
        try {
            conn = ConnectionProxy.getConnection();
            st = conn.prepareStatement(str);
            rs = st.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                MemVO vo = new MemVO();
                vo.setUserid(rs.getString("userid"));
                vo.setPwd(rs.getString("pwd"));
                vo.setName(rs.getString("name"));
                vo.setAddr(rs.getString("addr"));
                vo.setPhone(rs.getString("phone"));
                vo.setAllergy(rs.getString("allergy"));
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
	
	public boolean updateMem(String userid, String pwd, String name, String addr, String phone, String allergy) {
		String str = "update members set pwd=?,name=?,addr=?,phone=?,allergy=? where userid=?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(str);
			st.setString(1, userid);
			st.setString(2, pwd);
			st.setString(3, name);
			st.setString(4, addr);
			st.setString(5, phone);
			st.setString(6, allergy);
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
		String sql = "select * from members";
		ArrayList<MemVO> list = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				MemVO vo = new MemVO();
				vo.setUserid(rs.getString("userid"));
                vo.setPwd(rs.getString("pwd"));
                vo.setName(rs.getString("name"));
                vo.setAddr(rs.getString("addr"));
                vo.setPhone(rs.getString("phone"));
                vo.setAllergy(rs.getString("allergy"));
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
	
	public MemVO memInfo(String userid) {
		System.out.println("헤헤");
		String sql = "select * from members where userid = ?";
		MemVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				vo = new MemVO();
				vo.setUserid(rs.getString("userid"));
                vo.setPwd(rs.getString("pwd"));
                vo.setName(rs.getString("name"));
                vo.setAddr(rs.getString("addr"));
                vo.setPhone(rs.getString("phone"));
                vo.setAllergy(rs.getString("allergy"));
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
