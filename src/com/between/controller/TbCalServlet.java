package com.between.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		
		String paramYear = request.getParameter("year");
		String paramMonth = request.getParameter("month");
		
		if(paramYear != null){
			year = Integer.parseInt(paramYear);
		}
		
		if(paramMonth != null){
			month = Integer.parseInt(paramMonth);
		}
		
		if(month > 12){
			month = 1;
			year++;
		}
		
		if(month < 1){
			month = 12;
			year--;
		}
		
		cal.set(year, month-1, 1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		
		
		String command = request.getParameter("command");
		
		HttpSession session = request.getSession();
		TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
		
		System.out.println(userInfo.getGroupNum());
		
		TbGroupDto groupDto = biz.findPartner(userInfo.getGroupNum());
		
		System.out.println(groupDto.getPartnerId());
		
		if(command.equals("calendar")) {			
			
			request.setAttribute("groupDto", groupDto);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dayOfWeek", dayOfWeek);
			request.setAttribute("lastDay", lastDay);
			
			dispatch("TbCalendar.jsp", request, response);
			
		} else if(command.equals("minusYear")) {
			//year = year-1;
			
			request.setAttribute("groupDto", groupDto);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dayOfWeek", dayOfWeek);
			request.setAttribute("lastDay", lastDay);
			
			dispatch("TbCalendar.jsp", request, response);
		} else if(command.equals("minusMonth")) {
			request.setAttribute("groupDto", groupDto);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dayOfWeek", dayOfWeek);
			request.setAttribute("lastDay", lastDay);
			
			dispatch("TbCalendar.jsp", request, response);
		} else if(command.equals("addMonth")) {
			request.setAttribute("groupDto", groupDto);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dayOfWeek", dayOfWeek);
			request.setAttribute("lastDay", lastDay);
			
			dispatch("TbCalendar.jsp", request, response);
		} else if(command.equals("addYear")) {
			request.setAttribute("groupDto", groupDto);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dayOfWeek", dayOfWeek);
			request.setAttribute("lastDay", lastDay);
			
			dispatch("TbCalendar.jsp", request, response);
		} else if(command.equals("insertCal")) {
			int groupNum = Integer.parseInt(request.getParameter("groupNum"));
			
			year = Integer.parseInt(request.getParameter("year"));
			month = Integer.parseInt(request.getParameter("month"));
			
			String date = request.getParameter("date");
			
			String hour = request.getParameter("hour");
			String min = request.getParameter("min");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			String calTime = year+
					biz.isTwo((Integer.toString(month)))+
					biz.isTwo(date)+
					biz.isTwo(hour)+
					biz.isTwo(min);
			TbCalDto dto = new TbCalDto();
			dto.setGroupNum(groupNum);
			dto.setCalTitle(title);
			dto.setCalContent(content);
			dto.setCalTime(calTime);
			int res = biz.insertEvent(dto);
			
			request.setAttribute("groupDto", groupDto);
			
			System.out.println(year);
			System.out.println(month);
			System.out.println(date);
			System.out.println(hour);
			System.out.println(min);
			System.out.println(title);
			System.out.println(content);
			System.out.println(calTime);
			
			
			if(res>0) {
				//responseAlert("일정 추가 성공", "TbCalendar.jsp", response);
				response.sendRedirect("TbCal.do?command=calendar");
			} else {
				request.setAttribute("msg", "일정 추가 실패");
				dispatch("Calendar.jsp",request,response);
			}
			
			dispatch("TbCalendarInsert", request, response);
		} else if(command.equals("callist")) {
			year = Integer.parseInt(request.getParameter("year"));
			month = Integer.parseInt(request.getParameter("month"));
			int date = Integer.parseInt(request.getParameter("date"));
			
			
			
			String yyyyMMdd = year+biz.isTwo(Integer.toString(month))+biz.isTwo(Integer.toString(date));
			
			List<TbCalDto> list = biz.getCalList(yyyyMMdd, userInfo.getGroupNum());
			
			request.setAttribute("list", list);
			
			
			dispatch("TbCalendarList.jsp", request, response);
			
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doGet(request, response);
	}
	
	

}
