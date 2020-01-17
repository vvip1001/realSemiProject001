package com.between.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.between.common.SqlMapConfig;
import com.between.dto.TbBoardDto;

public class TbBoardDaoImpl extends SqlMapConfig implements TbBoardDao {

	private String namespace = "com.between.TbBoard.mapper.";
	
	@Override
	public List<TbBoardDto> selectList() {
		//전체출력
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
		//하나출력
		SqlSession session = null;
		TbBoardDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne",boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int insertBoard(TbBoardDto dto) {
		//글작성
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"insertBoard",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public int updateBoard(TbBoardDto dto) {
		//글수정
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateBoard",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	@Override
	public int checkGroupBoard(int boardNum) {
		//글삭제 하기 전 그룹작성글이 있는지 확인
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace+"checkGroupBoard",boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int updateBoardCheck(int boardNum) {
		//글삭제 (쿼리는 UPDATE)
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateBoardCheck",boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public int deleteBoard(int boardNum) {
		//글삭제 
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace+"deleteBoard",boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public int updateAnswer(int parentBoardNum) {
		//답글 탭번호 수정
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateAnswer",parentBoardNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int insertAnswer(TbBoardDto dto) {
		//답글 삽입
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"insertAnswer",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}


}
