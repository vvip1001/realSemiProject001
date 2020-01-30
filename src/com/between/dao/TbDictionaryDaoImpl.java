package com.between.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.between.common.SqlMapConfig;
import com.between.dto.TbDictionaryDto;

public class TbDictionaryDaoImpl extends SqlMapConfig implements TbDictionaryDao{

	private String namespace = "com.between.TbDic.mapper.";
	
	@Override
	public List<TbDictionaryDto> selectList() {
		//전체 출력
		SqlSession session = null;
		List<TbDictionaryDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"selectList");
		} catch (Exception e) {
			System.out.println("딕셔너리 selectList");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public TbDictionaryDto searchKeyword(String keyword) {
		//키워드 출력
		SqlSession session = null;
		TbDictionaryDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"searchKeyword", keyword);
		} catch (Exception e) {
			System.out.println("searchKeyword에서 에러났대요");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int insert(TbDictionaryDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int insertLike(TbDictionaryDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"insertLike", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int updateLike(TbDictionaryDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateLike", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int delete(TbDictionaryDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete(namespace+"delete",dto);
		
		return res;
	}

	
}
