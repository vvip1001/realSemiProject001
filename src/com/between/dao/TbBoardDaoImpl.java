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
		return null;
	}

	@Override
	public int insertBoard(TbBoardDto dto) {
		return 0;
	}

	@Override
	public int updateBoard(TbBoardDto dto) {
		return 0;
	}

	@Override
	public int deleteBoard(int boardNum) {
		return 0;
	}

	@Override
	public int updateAnswer(int parentBoardNum) {
		return 0;
	}

	@Override
	public int insertAnswer(TbBoardDto dto) {
		return 0;
	}

}
