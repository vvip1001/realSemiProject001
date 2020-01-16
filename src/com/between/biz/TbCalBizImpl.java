package com.between.biz;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.between.dao.TbCalDao;
import com.between.dao.TbCalDaoImpl;
import com.between.dto.TbCalDto;
import com.between.dto.TbGroupDto;
import com.between.dto.TbUserDto;

public class TbCalBizImpl implements TbCalBiz {
	
	TbCalDao dao = new TbCalDaoImpl();
	
	private String todates;
	
	public String getTodates() {
		return todates;
	}
	
	@Override
	public List<TbCalDto> getCalList(String calTime, int groupNum) {
		return dao.getCalList(calTime, groupNum);
	}

	@Override
	public TbCalDto selectOne(int calNum, int groupNum) {
		return dao.selectOne(calNum, groupNum);
	}

	@Override
	public int insertEvent(TbCalDto dto) {
		return dao.insertEvent(dto);
	}

	@Override
	public int updateEvent(TbCalDto dto) {
		return dao.updateEvent(dto);
	}

	@Override
	public int deleteEvent(int calNum) {
		return dao.deleteEvent(calNum);
	}
	
	
	@Override
	public void setTodates(String calTime) {
		// yyyy-MM-dd hh:mm:ss
		String m = calTime.substring(0,4) + "-" +
				calTime.substring(4,6) + "-" +
				calTime.substring(6,8) + "-" +
				calTime.substring(8,10) + "-" +
				calTime.substring(10) + ":00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		Timestamp tm = Timestamp.valueOf(m);
		todates = sdf.format(tm);
	}

	@Override
	public String isTwo(String msg) {
		//한자리수를 두자리수로 변환
		return (msg.length()<2)?"0"+msg:msg;
	}

	@Override
	public String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if((dayOfWeek-1+date)%7==0) {
			color = "blue";
		} else if((dayOfWeek-1+date)%7==1) {
			color = "red";
		} else {
			color = "black";
		}
		return color;
	}

	@Override
	public String getCalView(int i, List<TbCalDto> clist) {
		
		return null;
	}

	@Override
	public TbGroupDto findPartner(int groupNum) {
		return dao.findPartner(groupNum);
	}

	
}
