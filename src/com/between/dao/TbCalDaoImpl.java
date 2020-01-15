package com.between.dao;

import java.util.List;

import com.between.common.SqlMapConfig;
import com.between.dto.TbCalDto;

public class TbCalDaoImpl extends SqlMapConfig implements TbCalDao {
	
	private String namespace = "com.between.TbCal.mapper.";

	@Override
	public List<TbCalDto> getCalList(String calTime, int groupNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbCalDto selectOne(int calNum, int groupNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertEvent(TbCalDto dto, int groupNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEvent(TbCalDto dto, int groupNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEvent(int calNum, int groupNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
