package edu.ssafy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemberManager;
import edu.ssafy.model.MemberVO;
@WebServlet("/member.do")
public class MemberServelet extends HttpServlet {
	
	private MemberManager memberManager = new MemberManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
//		super.doPost(req, resp);
		String action = req.getParameter("action");
		if( action == null ||action.equals("main")) {
			//메인페이지 메인페이지에는 모든 회원 리스트를 보여줍시다 :)
			
			//데이터베이스에서.. 모든 회원의 정보를 가져와서.. attribute에 싣고. main.jsp로 포워드하자.
			List<MemberVO> memberList = memberManager.getMemberList();
			Cookie[] cookies = req.getCookies();
			List<String> visited = new ArrayList<String>();
			if( cookies != null) {
				for(Cookie c : cookies) {
					if(!c.getName().equals("JSESSIONID"))
						visited.add(c.getValue());
				}
				req.setAttribute("visited", visited);
			}
			req.setAttribute("memberList", memberList);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
		else if(action.equals("addMember")) {
			//회원추가작업 해주고 메인으로
			//파라메터들을 모두 꺼내서 MemberVO객체로 묶어서.. 매니저의 addMember함수에 던져주자..
			String name = req.getParameter("name");
			String userid = req.getParameter("userid");
			String pwd = req.getParameter("pwd");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			int admin = Integer.parseInt(req.getParameter("admin"));
			MemberVO memberVO = new MemberVO(name, userid, pwd, email, phone, admin);
			memberManager.addMember(memberVO);
			//main으로 리다이렉트해주자.
			resp.sendRedirect("member.do?action=main");
		}
		else if(action.equals("addMemberForm")) {
			//회원가입할 수 있는 페이지로 보내주기
			req.getRequestDispatcher("addMember.jsp").forward(req, resp);
		}
		else if(action.equals("viewMember")) {
			//해당 회원 상세보기 페이지로 ( 로그인 된놈만 볼 수 있음ㅇㅇ )
			if(req.getSession().getAttribute("id") == null) {
				resp.sendRedirect("member.do?action=main");
				return;
			}
			String userid = req.getParameter("userid");
			Cookie cookie = new Cookie(userid, userid);
			resp.addCookie(cookie);
			MemberVO memberVO = memberManager.getMember(userid);
			req.setAttribute("member", memberVO);
			req.getRequestDispatcher("viewMember.jsp").forward(req, resp);
		}
		else if(action.equals("login")) {
			//로그인처리
			String userid = req.getParameter("userid");
			String pwd = req.getParameter("pwd");
			if( pwd.equals( memberManager.getMember(userid).getPwd() ) ) {
				//로그인성공
				req.getSession().setAttribute("id", userid);
			}
			resp.sendRedirect("member.do?action=main");
		}
		else if(action.equals("logout")) {
			//로그아웃처리
			req.getSession().setAttribute("id", null);
			resp.sendRedirect("member.do?action=main");
		}
		
		
	}
	
}
