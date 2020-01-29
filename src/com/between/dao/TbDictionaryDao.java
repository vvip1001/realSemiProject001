package com.between.dao;

import java.util.List;

import com.between.dto.TbDictionaryDto;

public interface TbDictionaryDao {
	
	public List<TbDictionaryDto> selectList();
	public TbDictionaryDto searchKeword(String keyword);
	
}
