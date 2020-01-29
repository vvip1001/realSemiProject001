package com.between.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.between.common.SqlMapConfig;
import com.between.dto.TbDictionaryDto;

public class TbDictionaryDaoImpl extends SqlMapConfig implements TbDictionaryDao{

	private String namespace = "com.between.TbDic.mapper.";
	
	@Override
	public List<TbDictionaryDto> selectList() {
		
		SqlSession session = null;
		List<TbDictionaryDto> list = null;
		
		session = getSqlSessionFactory().openSession(false);
		list = session.selectList(namespace+"selectList");
		
		return list;
	}

	@Override
	public TbDictionaryDto searchKeword(String keyword) {
		return null;
	}

}
