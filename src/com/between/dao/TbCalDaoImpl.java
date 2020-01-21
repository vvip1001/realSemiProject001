package com.between.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.between.common.SqlMapConfig;
import com.between.dto.TbCalDto;
import com.between.dto.TbGroupDto;

public class TbCalDaoImpl extends SqlMapConfig implements TbCalDao {
	
	private String namespace = "com.between.TbCal.mapper.";

	@Override
	public List<TbCalDto> selectCalList(String yyyyMMdd, int groupNum) {
		SqlSession session = null;
		List<TbCalDto> list = null;
		TbCalDto calDto = new TbCalDto();
		calDto.setCalTime(yyyyMMdd);
		calDto.setGroupNum(groupNum);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace+"selectCalList",calDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public TbCalDto selectOne(int calNum, int groupNum) {
		SqlSession session = null;
		TbCalDto dto = new TbCalDto();
		dto.setCalNum(calNum);
		dto.setGroupNum(groupNum);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int insertEvent(TbCalDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"insertEvent", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int updateEvent(TbCalDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateEvent", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int deleteEvent(int calNum) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace+"deleteEvent", calNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public TbGroupDto findPartner(int groupNum) {
		SqlSession session = null;
		TbGroupDto dto = null;
		
		session = getSqlSessionFactory().openSession(true);
		dto = session.selectOne(namespace+"findPartner", groupNum);
		
		return dto;
	}

	
}
