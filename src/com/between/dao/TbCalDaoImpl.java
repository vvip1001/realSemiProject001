package com.between.dao;

import java.util.List;

import com.between.common.SqlMapConfig;
import com.between.dto.TbCalDto;

public class TbCalDaoImpl extends SqlMapConfig implements TbCalDao {
	
	private String namespace = "com.between.TbCal.mapper.";

	@Override
	public List<TbCalDto> getCalList(String yyyyMMdd) {
		
		
		
		return null;
	}

	@Override
	public TbCalDto selectOne(int calNum) {
		
		
		
		return null;
	}

	@Override
	public int insertEvent(TbCalDto dto) {
		
		
		
		return 0;
	}

	@Override
	public int updateEvent(TbCalDto dto) {
		
		
		
		return 0;
	}

	@Override
	public int deleteEvent(int calNum) {
		
		
		
		return 0;
	}

	
}
