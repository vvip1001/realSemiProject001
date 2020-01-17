package com.between.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.between.biz.TbCalBiz;
import com.between.biz.TbCalBizImpl;
import com.between.dto.TbCalDto;
import com.between.dto.TbGroupDto;
import com.between.dto.TbUserDto;

import static com.between.controller.ServletUtil.*;

@WebServlet("/TbCalServlet.do")
public class TbCalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		TbCalBiz biz = new TbCalBizImpl();
		
		
		String command = request.getParameter("command");
		
		if(command.equals("calendar")) {
			HttpSession session = request.getSession();
			TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
			
			System.out.println(userInfo.getGroupNum());
			
			TbGroupDto groupDto = biz.findPartner(userInfo.getGroupNum());
			
			System.out.println(groupDto.getPartnerId());
			
			
			request.setAttribute("groupDto", groupDto);
			
			dispatch("TbCalendar.jsp", request, response);
			
		} else if(command.equals("insertCalEvent")) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String hour = request.getParameter("hour");
			String min = request.getParameter("min");
			String calDate = year + 
							biz.isTwo("month")+
							biz.isTwo("date")+
							biz.isTwo("hour")+
							biz.isTwo("min");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			int groupNum = Integer.parseInt(request.getParameter("groupNum"));
			
			int res = biz.insertEvent(new TbCalDto(0,groupNum,title, content, calDate, null));
			
			if(res > 0) {
				response.sendRedirect("TbCal.do?command=Calendar");
			} else {
				responseAlert("추가 실패", "insertCal.jsp", response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doGet(request, response);
	}
	
	

}
