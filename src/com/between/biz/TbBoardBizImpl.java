package com.between.biz;

import java.util.List;

import com.between.dao.TbBoardDao;
import com.between.dao.TbBoardDaoImpl;
import com.between.dto.TbBoardDto;

public class TbBoardBizImpl implements TbBoardBiz{

	TbBoardDao dao = new TbBoardDaoImpl();
	
	@Override
	public List<TbBoardDto> selectList(int pageNum, int pageCount) {
		
		int page = 0;
		int pageCountAfter = 0;

		pageCountAfter = pageNum*pageCount; 
		page = ((pageNum-1)*10)+1;
		

		return dao.selectList(page,pageCountAfter);
//		select *
//		from (SELECT *
//		        FROM (
//		            SELECT rownum rnum, id, title, content
//		            FROM page_table
//		            ) pagetable
//		        where rnum <= 10
//		    )
//		where rnum >= 1;
				// ((page-1)*10)+1
//		-- 2페이지
//		select *
//		from (SELECT *
//		        FROM (
//		            SELECT rownum rnum, id, title, content
//		            FROM page_table
//		            ) pagetable
//		        where rnum <= 20 30 40 50
//		    )
//		where rnum >= 11; 21 31 41
		
		
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

	@Override
	public int countBoard() {
		return dao.countBoard();
	}

}
