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
	public int checkBoardDelete(int boardNum) {
		int count = dao.checkGroupBoard(boardNum);
		int res = 0;
		System.out.println("checkBoardDelete : " +count+"BOARD_NUM : "+boardNum);
		if(count == 1) {
			res = dao.deleteBoard(boardNum);
		} else {
			res = dao.updateBoardCheck(boardNum);
		}
		
		return res;
	}

	@Override
	public int answerProc(TbBoardDto dto) {
		
		int update = dao.updateAnswer(dto.getBoardNum());
		System.out.println("UPDATE : "+update);
		int insert = dao.insertAnswer(dto);
		System.out.println("INSERT : "+insert);
		
		return insert;
	}

}
