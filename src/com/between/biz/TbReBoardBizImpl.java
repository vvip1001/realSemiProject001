package com.between.biz;

import java.util.List;

import com.between.dao.TbReBoardDao;
import com.between.dao.TbReBoardDaoImpl;
import com.between.dto.TbReBoardDto;

public class TbReBoardBizImpl implements TbReBoardBiz{

	TbReBoardDao dao = new TbReBoardDaoImpl();
	
	@Override
	public List<TbReBoardDto> selectList(int pageNum, int pageCount,int boardNum) {
		
		int page = 0;
		int pageCountAfter = 0;

		pageCountAfter = pageNum*pageCount; 
		page = ((pageNum-1)*10)+1;
		

 		return dao.selectList(page,pageCountAfter,boardNum);
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
	public int insertReBoard(TbReBoardDto dto) {
		return dao.insertReBoard(dto);
	}

	@Override
	public int updateReBoard(TbReBoardDto dto) {
		return dao.updateReBoard(dto);
	}

	@Override
	public int deleteReBoard(int boardNum) {
		return dao.deleteBoard(boardNum);
	}
	public int checkReBoardDelete(int boardNum) {
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
	public int answerProc(TbReBoardDto dto) {
		
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
