package com.between.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public TbCalDto selectDday(String calTitle, int groupNum) {
		SqlSession session = null;
		TbCalDto dto = new TbCalDto();
		dto.setCalTitle(calTitle);
		dto.setGroupNum(groupNum);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectDday",dto);
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
	public int deleteEvent(String[] seq) {
		SqlSession session = null;
		int res = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"deleteEvent", map);
			if(res==seq.length) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	
	@Override
	public int deleteOne(TbCalDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete(namespace+"deleteOne",dto);
		
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

	@Override
	public List<TbCalDto> selectCalListView(String yyyyMM, int groupNum) {
		SqlSession session = null;
		List<TbCalDto> list = new ArrayList<TbCalDto>();
		TbCalDto calDto = new TbCalDto();
		calDto.setCalTime(yyyyMM);
		calDto.setGroupNum(groupNum);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace+"selectCalListView",calDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
		
	}


	
}
