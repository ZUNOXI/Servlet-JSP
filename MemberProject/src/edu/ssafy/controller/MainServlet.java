package edu.ssafy.controller;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.business.IMemService;
import edu.ssafy.business.MemServiceImpl;
import edu.ssafy.model.MemManager;
import edu.ssafy.model.MemManager2;
import edu.ssafy.model.MemVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMemService service = new MemServiceImpl();
//	private MemManager2 man = MemManager2.getInstance();;
	public void init() throws ServletException {
    	super.init();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("registmem")) {
			service.registMem(request,response);
		}
		else if(action.equals("listmem")) {
			service.listMen(request,response);
		}
		else if(action.equals("meminfo")) {
			service.mainInfo(request,response);
		}
		else if(action.equals("deletemem")) {
			service.deleteMem(request,response);
		}
		else if(action.equals("updatemem")) {
			service.updateMem(request,response);
		}
		else if(action.equals("login")) {
//			loginMem(request,response);
			service.login(request,response);
		}
		else if(action.equals("logout")) {
//			loginMem(request,response);
			service.logout(request,response);
		}
	}
	
	
}
