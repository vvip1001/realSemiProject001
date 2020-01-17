package com.between.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.between.biz.TbBoardBiz;
import com.between.biz.TbBoardBizImpl;
import com.between.dto.TbBoardDto;
import com.between.dto.TbUserDto;

import static com.between.controller.ServletUtil.*;

@WebServlet("/test.do")
public class TbBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public TbBoardServlet() {
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		TbBoardBiz biz = new TbBoardBizImpl();
		
		String command = request.getParameter("command");
		
		if(command.equals("boardlist")) {
			List<TbBoardDto> list = biz.selectList();
			request.setAttribute("list", list);
			dispatch("TbBoardList.jsp",request,response);
		} else if(command.equals("boarddetail")) {
			int boardNum = Integer.parseInt(request.getParameter("boardnum"));
			TbBoardDto dto = biz.selectOne(boardNum);
			request.setAttribute("board", dto);
			dispatch("TbBoardDetail.jsp",request,response);
		} else if(command.equals("boardwriteform")) {
			response.sendRedirect("TbBoardWriteForm.jsp");
		} else if(command.equals("boardwriteres")) {
			String userId = request.getParameter("userId");
			String boardTitle = request.getParameter("boardTitle");
			String boardContent = request.getParameter("boardContent");
			HttpSession session = request.getSession();
			TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
			
			TbBoardDto dto = new TbBoardDto();
			dto.setUserId(userId);
			dto.setBoardTitle(boardTitle);
			dto.setBoardContent(boardContent);
			dto.setBoardGender(userInfo.getUserGender());
			dto.setBoardType(checkStatus(userInfo.getUserStatus()));
			int res = biz.insertBoard(dto);
			if(res>0) {
				response.sendRedirect("TbBoard.do?command=boardlist");
			} else {
				responseAlert("fail", "index.html", response);
			} 
		} else if(command.equals("boarddelete")) {
			
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			
			int res = biz.deleteBoard(boardNum);
			
			if(res>0) {
				response.sendRedirect("TbBoard.do?command=boardlist");
			} else {
				responseAlert("fail", "index.html", response);
			} 
		} else if(command.equals("boardupdate")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			TbBoardDto dto = biz.selectOne(boardNum);
			request.setAttribute("board", dto);
			dispatch("TbBoardUpdateForm.jsp", request, response);
		} else if(command.equals("boardupdateres")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			String boardTitle = request.getParameter("boardTitle");
			String boardContent = request.getParameter("boardContent");
			
			TbBoardDto dto = new TbBoardDto();
			dto.setBoardNum(boardNum);
			dto.setBoardTitle(boardTitle);
			dto.setBoardContent(boardContent);
			
			int res = biz.updateBoard(dto);
			
			if(res>0) {
				response.sendRedirect("TbBoard.do?command=boardlist");
			} else {
				responseAlert("fail", "index.html", response);
			} 
		} else if(command.equals("boardanswer")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			TbBoardDto board = biz.selectOne(boardNum);
			request.setAttribute("board", board);
			dispatch("TbBoardAnswerForm.jsp", request, response);
		} else if(command.equals("boardanswerres")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			String boardTitle = request.getParameter("boardTitle");
			String boardContent = request.getParameter("boardConent");
			String userId = request.getParameter("userId");
			
			TbBoardDto dto = new TbBoardDto();
			dto.setBoardNum(boardNum);
			dto.setBoardTitle(boardTitle);
			dto.setBoardContent(boardContent);
			dto.setUserId(userId);
			
			int res = biz.answerProc(dto);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}
	public String checkStatus(String userStatus) {
		
		String boardType ;
		
		if(userStatus.equals("ADMIN")) {
			boardType = "NOTICE";
		} else {
			boardType= "NORMAL";
		}
		
		return boardType;
	}
	
}
