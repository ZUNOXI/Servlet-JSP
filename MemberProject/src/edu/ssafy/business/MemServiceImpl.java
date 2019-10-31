package edu.ssafy.business;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.IMemManager;
import edu.ssafy.model.MemManager;
import edu.ssafy.model.MemManager2;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVO;

public class MemServiceImpl implements IMemService {
	private IMemManager man = new MemManagerImpl();
	public MemServiceImpl() {
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		boolean isLogin = man.isLogin(id, pw);
		
		if(isLogin) {
			request.getSession().setAttribute("isLogin", "islogin");
			request.getSession().setAttribute("id", id);
//			Cookie cooklogin = new Cookie("islogin","islogin");
//			Cookie cookid = new Cookie("islogin",id);
//			response.addCookie(cooklogin);
//			response.addCookie(cookid);
			response.sendRedirect("main.do?action=listmem");			
		}
		else {
			response.sendRedirect("login.html");
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.getSession().invalidate();
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i<cookies.length; i++) {
			cookies[i].getName();
			cookies[i].getValue();
			cookies[i].setMaxAge(0);
		}
		response.sendRedirect("login.html");
//		request.getSession().setAttribute("islogin", null); 널값으로 대체 하는것
		
	}

	public void loginMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		System.out.println(id);
		MemVO mem = man.memInfo(id);
		if(mem != null) {
			request.setAttribute("mem", mem);
			listMen(request,response);
			
//			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		}
		else {
			request.setAttribute("result", "회원조회 실패");
			request.getRequestDispatcher("join.jsp").forward(request, response);
		}
	}
	
	public void nameFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = request.getParameter("namefind");
        ArrayList<MemVO> list = man.nameFind(name);
        if(list != null) {
            request.setAttribute("list", list);
            request.getRequestDispatcher("listmem.jsp").forward(request, response);
        }else {
            request.setAttribute("result", "조회 실패!");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }

	public void updateMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("pw");
		String addr = request.getParameter("paddr");
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");
		
		boolean del = man.delMem(id);
		
		if(del) {
			boolean res = man.addMem(id, name, pw, addr, age, tel);
			
			ArrayList<MemVO>list = man.getList();
			if(list != null) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("listmem.jsp").forward(request, response);
			}
			else {
				request.setAttribute("result", "회원조회 실패");
				request.getRequestDispatcher("result.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("result", id+"의 삭제를 실패하였습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);;
		}
		
		
	}

	public void deleteMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		boolean del = man.delMem(id);
		if(del) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		}
		else {
			request.setAttribute("result", id+"의 삭제를 실패하였습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);;
		}
		
		
	}

	public void mainInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		System.out.println(id);
		MemVO mem = man.memInfo(id);
		if(mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		}
		else {
			request.setAttribute("result", "회원조회 실패");
			request.getRequestDispatcher("join.jsp").forward(request, response);
		}
	}

	public void listMen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemVO>list = man.getList();
		if(list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listmem.jsp").forward(request, response);
		}
		else {
			request.setAttribute("result", "회원조회 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void registMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("ppw");
		String addr = request.getParameter("paddr");
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");
		
		//3
		boolean res = man.addMem(id, name, pw, addr, age, tel);
		
		//4
		if(res) {
//			request.setAttribute("result", id + "등록성공 ");
			String msg = URLEncoder.encode("등록성공","UTF-8");
			response.sendRedirect("result.jsp?result="+ id + msg);
		}
		else {
//			request.setAttribute("result", id + "등록실패 ");
			String msg = URLEncoder.encode("등록실패","UTF-8");
			response.sendRedirect("result.jsp?result="+ id + msg);
		}
//		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
