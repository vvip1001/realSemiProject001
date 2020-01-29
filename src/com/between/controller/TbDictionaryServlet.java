package com.between.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.between.controller.ServletUtil.*;

@WebServlet("/TbDictionaryServlet")
public class TbDictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset='UTF-8'");
		
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset='UTF-8'");
		
		String command = request.getParameter("command");
		
		if(command.equals("dictionaryMain")) {
			dispatch("TbDictionaryMain.jsp", request, response);
			
			
		}
	
	}

}
