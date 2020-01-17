package com.between.controller;
import static com.between.controller.ServletUtil.*; 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.between.biz.TbUserBiz;
import com.between.biz.TbUserBizImpl;
import com.between.dto.TbBoardDto;
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
			//취소했을때 로그인 하지 않은 메인으로 돌아가야 함 
			response.sendRedirect("index.html");
			
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
				
				}
			response.sendRedirect("loginafter.jsp");
			
			
			
		}else if(command.equals("logout")) {
			
			//세션 만료 
			HttpSession session = request.getSession();
			session.invalidate();
			responseAlert("로그아웃 되었습니다.", "index.html", response);
			//response.sendRedirect("index.html");
			
		}else if(command.equals("mypage")) {
			
			HttpSession session = request.getSession();
			TbUserDto loginDto = (TbUserDto)session.getAttribute("dto");
			
			//System.out.println(loginDto.getUserEmail());
			//각 등급별로 마이페이지 열리기 
			if(loginDto.getUserStatus().equals("ADMIN")) {
				responseAlert("어드민님의 마이페이지 입니다. 환영합니다.", "TbUserAdminMyPage.jsp", response);
			}else if(loginDto.getUserStatus().equals("USER")) {
				responseAlert("일반회원님의 마이페이지 입니다. 환영합니다.", "TbUserUserMyPage.jsp", response);
			}else if(loginDto.getUserStatus().equals("COUNSELOR")) {
				responseAlert("상담사님의 마이페이지 입니다.","TbUserCounselorMyPage.jsp", response);
			}
			
		}else if(command.equals("userupdateform")){
			response.sendRedirect("TbUserUserUpdateForm.jsp");
			
		}else if(command.equals("userupdateformres")) {
			response.sendRedirect("TbUser.do?command=mypage");
		
		}else if(command.equals("userboardlist")) {
			
			//문제해결 : jsp파일에서 입력된 값 넘길때 form밖에 없나 ? 
			String equserPw = request.getParameter("equserPw");
			HttpSession session = request.getSession();
			TbUserDto loginDto = (TbUserDto)session.getAttribute("dto");
			System.out.println(equserPw);
			
			if(equserPw.equals(loginDto.getUserPw())) {
				
				String userId = request.getParameter("userId");
				
				List<TbBoardDto> list = biz.userBoardList(userId);
				request.setAttribute("list", list);
				dispatch("TbUserboardList.jsp", request, response);
					
			}else {
				responseAlert("비밀번호를 제대로 입력하세요 ", "TbUser.do?command=mypage", response);
			}
			
			
		}
		
		
		
		
		//dopost 마지막 부분 
	}

}
