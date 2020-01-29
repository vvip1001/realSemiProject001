package com.between.biz;

import java.util.List;

import com.between.dto.TbDictionaryDto;

public interface TbDictionaryBiz {
	
	public List<TbDictionaryDto> selectList();
	public TbDictionaryDto searchKeword(String keyword);
	
	
}
