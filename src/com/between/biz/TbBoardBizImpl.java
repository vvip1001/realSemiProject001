package com.between.biz;

import java.util.List;

import com.between.dao.TbBoardDao;
import com.between.dao.TbBoardDaoImpl;
import com.between.dto.TbBoardDto;

public class TbBoardBizImpl implements TbBoardBiz{

	TbBoardDao dao = new TbBoardDaoImpl();
	
	@Override
	public List<TbBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public TbBoardDto selectOne(int boardNum) {
		return dao.selectOne(boardNum);
	}

	@Override
	public int insertBoard(TbBoardDto dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int updateBoard(TbBoardDto dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public int deleteBoard(int boardNum) {
		return dao.deleteBoard(boardNum);
	}

	@Override
	public int answerProc(TbBoardDto dto) {
		
		int update = dao.updateAnswer(dto.getBoardNum());
		int insert = dao.insertAnswer(dto);
		
		return update+insert;
	}

}
