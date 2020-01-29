package com.between.biz;

import java.util.List;

import com.between.common.SqlMapConfig;
import com.between.dao.TbDictionaryDao;
import com.between.dao.TbDictionaryDaoImpl;
import com.between.dto.TbDictionaryDto;

public class TbDictionaryBizImpl extends SqlMapConfig implements TbDictionaryBiz {

	TbDictionaryDao dao = new TbDictionaryDaoImpl();
	
	@Override
	public List<TbDictionaryDto> selectList() {
		return dao.selectList();
	}

	@Override
	public TbDictionaryDto searchKeword(String keyword) {
		return dao.searchKeword(keyword);
	}

}
