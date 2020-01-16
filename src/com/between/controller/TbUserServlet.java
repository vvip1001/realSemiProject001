package com.between.controller;
import static com.between.controller.ServletUtil.*; 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.between.biz.TbUserBiz;
import com.between.biz.TbUserBizImpl;
import com.between.dto.TbUserDto;


@WebServlet("/TbUserServlet.do")
public class TbUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TbUserServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String command = request.getParameter("command");
		TbUserBiz biz = new TbUserBizImpl();
		
		if(command.equals("login")) {
			response.sendRedirect("TbUserLogin.jsp");
			

		}else if(command.equals("registerform")) {
			//회원가입 가야할 부분 링크 걸기 
			response.sendRedirect("index.html");
			
		}else if(command.equals("main")) {
			//로그인뒤 보이는 첫 메인 화면으로 링크를 걸어주자
			response.sendRedirect("loginafter.jsp");
			
			
		}else if(command.equals("loginres")) {
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			TbUserDto dto = biz.login(userId, userPw);
			//dispatch("loginafter.jsp", request, response);
			
			//로그인 받은 정보에 따른 판별
			if(dto != null) {
				HttpSession session =  request.getSession(true);
				session.setAttribute("dto", dto);
				//session.setMaxInactiveInterval(60*10);
				if(dto.getUserStatus().equals("ADMIN")) {
					responseAlert("어드민로그인", "TbUser.do?command=mypage", response);
				}else if(dto.getUserStatus().equals("COUNSELOR")) {
					responseAlert("상담사로그인", "loginafter.jsp", response);
				}else if(dto.getUserStatus().equals("USER")) {
					responseAlert("유저로그인", "loginafter.jsp", response);
				}else {
					response.sendRedirect("TbUser.do?command=login");
				}
				
				
			}
			
			
		}
		
		
		
	}

}
