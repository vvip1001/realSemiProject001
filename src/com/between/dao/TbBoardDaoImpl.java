package com.between.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.between.common.SqlMapConfig;
import com.between.dto.TbBoardDto;

public class TbBoardDaoImpl extends SqlMapConfig implements TbBoardDao {

	private String namespace = "com.between.TbBoard.mapper.";
	
	@Override
	public List<TbBoardDto> selectList() {
		
		SqlSession session = null;
		List<TbBoardDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public TbBoardDto selectOne(int boardNum) {
		
		SqlSession session = null;
		TbBoardDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int insertBoard(TbBoardDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"insertBoard");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public int updateBoard(TbBoardDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateBoard");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int deleteBoard(int boardNum) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"deleteBoard");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int updateAnswer(int parentBoardNum) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateAnswer");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int insertAnswer(TbBoardDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"insertAnswer");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

}
