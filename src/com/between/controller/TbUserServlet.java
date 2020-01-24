package com.between.controller;
import static com.between.controller.ServletUtil.*; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.between.dto.TbGroupDto;
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
			 
			response.sendRedirect("RegistForm.jsp");
			
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
			

			int groupNum = loginDto.getGroupNum();
			System.out.println("groupNum : "+groupNum);
			String userId = loginDto.getUserId();
			

			//System.out.println(loginDto.getUserEmail());
			//각 등급별로 마이페이지 열리기 
			if(loginDto.getUserStatus().equals("ADMIN")) {
				responseAlert("어드민님의 마이페이지 입니다. 환영합니다.", "TbUserAdminMyPage.jsp", response);
				
			}else if(loginDto.getUserStatus().equals("USER")) {
				
				if(groupNum == 0 ) {
					String partnerId = "N";

				request.setAttribute("partnerId", partnerId);
			    dispatch("TbUserUserMyPage.jsp", request, response);
				}else {
					String partnerId = biz.partnerIdShow(groupNum,userId);
					request.setAttribute("partnerId", partnerId);
					dispatch("TbUserUserMyPage.jsp", request, response);
				}
				
				
				//responseAlert("일반회원님의 마이페이지 입니다. 환영합니다.", "TbUserUserMyPage.jsp", response);
			}else if(loginDto.getUserStatus().equals("COUNSELOR")) {
				responseAlert("상담사님의 마이페이지 입니다.","TbUserCounselorMyPage.jsp", response);
			}
			
			
			
		}else if(command.equals("partnerinsert")) {
			String partnerId = request.getParameter("partnerId");
			String userId = request.getParameter("userId");
			
			int res = biz.partnerIdInsert(partnerId, userId);
				if(res > 0) {
					
				   int afterres = biz.partnerNumUpdateUT(userId);
				
				  if(afterres>0) {
					request.setAttribute("partnerId", partnerId);
				    dispatch("TbUserUserMyPage.jsp", request, response);
				  }else {
					responseAlert("파트너 유저테이블에 입력 불가 ", "index.html", response);
				}
			}else {
				responseAlert("파트너 입력하는 유저테이블에서 오류", "loginafter.jsp", response);
			}
			
			
			
		}else if(command.equals("userupdateform")){
			
			String partnerId = request.getParameter("partnerId");
			
			request.setAttribute("partnerId", partnerId);
			dispatch("TbUserUserUpdateForm.jsp", request, response);
			
			
		}else if(command.equals("userupdateformres")) {
			//수정될 파트너 아이디 비밀번호 등을 받아서 처리하자 
			//커플 테이블에 정보를 넣고 생성된 번호를 유저테이블에 저장 
			
			
			int res = biz.partnerIdUpdate(partnerId, groupNum);
			if(res > 0) {
				
				//dispatch("TbUser.do?command=mypage", request, response);
				response.sendRedirect("TbUser.do?command=mypage");
			}else {
				responseAlert("파트너아이디를 입력해 주세요", "TbUser.do?command=userupdateform", response);
			}
			
			
		
		}else if(command.equals("userboardlist")) {
			
			//문제해결 : jsp파일에서 입력된 값 넘길때 form밖에 없나 ? 
			String equserPw = request.getParameter("equserPw");
			HttpSession session = request.getSession();
			TbUserDto loginDto = (TbUserDto)session.getAttribute("dto");
			//System.out.println(equserPw);
			
			if(equserPw.equals(loginDto.getUserPw())) {
				
				String userId = request.getParameter("userId");
				
				List<TbBoardDto> list = biz.userBoardList(userId);
				request.setAttribute("list", list);
				dispatch("TbUserboardList.jsp", request, response);
					
			}else {
				responseAlert("비밀번호를 제대로 입력하세요 ", "TbUser.do?command=mypage", response);
			}
			
			
		}else if(command.equals("search")) {
			
			String userId = request.getParameter("userId");
			String boardTitle = request.getParameter("boardTitle");
			
			/*
			List<TbBoardDto> list = biz.userBoardSearch(boardTitle, userId);
			request.setAttribute("list", list);
			dispatch("TbUserboardList.jsp", request, response);
			*/
			
			List<TbBoardDto> list = new ArrayList<TbBoardDto>();
			list = biz.userBoardSearch(boardTitle, userId);
			
			
				if(list.size()>0) {
					request.setAttribute("list", list);
					dispatch("TbUserboardList.jsp", request, response);
				}else if(list.size()==0){
					List<TbBoardDto> list2 = biz.userBoardList(userId);
					request.setAttribute("list", list2);
					dispatch("TbUserboardList.jsp", request, response);
			}
			
			/*
			for(TbBoardDto bTitle : list) {
				//System.out.println("가지고 있는 자료"+bTitle+"검색하려는 글"+boardTitle);
				if(bTitle.getBoardTitle().contains(boardTitle)) {
					//System.out.println("가지고 있는 자료"+bTitle+"검색하려는 글"+boardTitle);
					dispatch("TbUserboardList.jsp", request, response);	
					
				}else {
					//이부분 실행이 안됨 ㅠㅠ 
					dispatch(url, request, response);
					
				}
			}
			*/
			
			
		}else if(command.equals("userboarddetail")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			TbBoardDto board = biz.userBoardSelectOne(boardNum);
			request.setAttribute("board", board);
			dispatch("TbUserUserBoardDetail.jsp", request, response);
			
		}else if(command.equals("userboardupdate")) {	
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			TbBoardDto board = biz.userBoardSelectOne(boardNum);
			request.setAttribute("board", board);
			dispatch("TbUserBoardUpdateForm.jsp", request, response);
			//response.sendRedirect("TbUserBoardUpdateForm.jsp");
		
		}else if(command.equals("userboardupdateres")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			String boardTitle = request.getParameter("boardTitle");
			String boardContent = request.getParameter("boardContent");
			
			TbBoardDto dto = new TbBoardDto();
			dto.setBoardNum(boardNum);
			dto.setBoardTitle(boardTitle);
			dto.setBoardContent(boardContent);
			//System.out.println(dto);
			int res = biz.userBoardUpdate(dto);
			
			if(res >0 ) {
				String userId = request.getParameter("userId");
				request.setAttribute("userId", userId);
				dispatch("TbUser.do?command=mylist", request, response);
			}else {
				//아래문구 실행 안됨 
				responseAlert("글수정 실패 다시작성해주세요", "TbUser.do?command=userboardupdate", response);
			}
			
		}else if(command.equals("mylist")) {
			//에러문제 자꾸만 null이 뜸 
			//String userId = request.getParameter("userId");
			
			HttpSession session = request.getSession();
			String userId = ((TbUserDto)session.getAttribute("dto")).getUserId();
			//System.out.println("나의 글 목록 보기 "+userId);
			
			List<TbBoardDto> list = biz.userBoardList(userId);
			
			request.setAttribute("list", list);
			dispatch("TbUserboardList.jsp", request, response);
			
		}else if(command.equals("muldel")) {
						
			String userId = request.getParameter("userId");
			//System.out.println("멀티딜리트"+userId);
			
			String[] boardNum = request.getParameterValues("chk");
			if(boardNum == null || boardNum.length == 0) {
				responseAlert("적어도 하나 이상 체크해 주세요", "TbUser.do?command=mylist", response);
		   }else {
			   int res = biz.userBoardMultiDelete(boardNum);
			   if(res>0) {
				   responseAlert("삭제 성공", "TbUser.do?command=mylist", response);
				   		   
			   }else {
				   responseAlert("삭제실패하였습니다", "TbUser.do?command=mylist", response);

			   }
		   }
		
		
		 
		}else if(command.equals("userboarddeleteone")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			int res = biz.userBoardDelete(boardNum);
			
			//System.out.println("단일삭제 부분ㅇ 글번호 "+boardNum);
			
			if(res>0) {
				responseAlert("글을 삭제하였습니다", "TbUser.do?command=mylist", response);

			}else {
				responseAlert("삭제 실패하였습니다", "TbUser.do?command=userboarddetail&boardNum=<%=boardNum%>", response);
			
			}
	
		}
		
		
		
		
		//dopost 마지막 부분 
	}

}
