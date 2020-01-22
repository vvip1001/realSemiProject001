package com.between.dao;

import java.util.List;

import com.between.dto.TbCalDto;
import com.between.dto.TbGroupDto;

public interface TbCalDao {

	public List<TbCalDto> selectCalList(String yyyyMMdd, int groupNum);
	public TbCalDto selectOne(int calNum, int groupNum);
	public int insertEvent(TbCalDto dto);
	public int updateEvent(TbCalDto dto);
	public int deleteEvent(String[] seq);
	public TbGroupDto findPartner(int groupNum);
}
