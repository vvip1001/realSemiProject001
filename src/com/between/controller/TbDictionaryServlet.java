package com.between.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.between.biz.TbDictionaryBiz;
import com.between.biz.TbDictionaryBizImpl;
import com.between.dto.TbDictionaryDto;

import static com.between.controller.ServletUtil.*;

@WebServlet("/TbDictionaryServlet")
public class TbDictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		TbDictionaryBiz biz = new TbDictionaryBizImpl();
		
		String command = request.getParameter("command");
		
		if(command.equals("dictionaryMain")) {
			// 최초 사전페이지에 진입시
			List<TbDictionaryDto> list = biz.selectList();
			// 사전 리스트를 불러옴/좋아연 눌러진 수로 내림차순
			
			request.setAttribute("list", list);
			dispatch("TbDictionaryMain.jsp", request, response);
		}
	
	}

}
