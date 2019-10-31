package edu.ssafy.controller;

import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.business.IMemService;
import edu.ssafy.business.MemServiceImpl;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IMemService service = new MemServiceImpl();
	
    public void init() throws ServletException {
    	super.init();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("registmem")) {
			System.out.println("들어왔다1");
			service.registMem(request,response);
		}
		else if(action.equals("login")) {
//			loginMem(request,response);
			service.login(request,response);
		}
		else if(action.equals("logindo")) {
			System.out.println("들어왔다2");
			service.loginMem(request,response);
		}
//		else if(action.equals("productsearchAll")) {
//			service.productSearch(request,response);
//		}
//		else if(action.equals("namesearch")){
//			service.nameSearch(request,response);
//			
//		}
//		else if(action.equals("pricesearch")){
//			service.priceSearch(request,response);
//			
//		}
//		else if(action.equals("delete")){
//			service.deletemem(request,response);
//		}
	}
	
	
}
