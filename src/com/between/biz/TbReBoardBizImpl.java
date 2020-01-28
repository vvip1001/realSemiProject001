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
		//삭제 하기 전 게시글 번호를 파라미터로 받아서 해당 게시글 번호가 가진 자식(그룹넘버가 같은 게시글)을 확인
		int count = dao.checkGroupBoard(boardNum);
		int res = 0;
		
		if(count == 1) {// 게시글이 자신 밖에 없을 경우 DB에서 DELETE
			res = dao.deleteBoard(boardNum);
		} else { // 게시글이 자신 이외에도 존재할 경우 DB에서 해당 게시글의 DELETE_CHECK를 Y로 바꿔줌
			res = dao.updateBoardCheck(boardNum);
		}
		
		return res;
	}

	@Override
	public int answerProc(TbReBoardDto dto) {

		//답글 달기전 다른 게시글의 스탯을 업뎃 (탭번호,오더)
		int update = dao.updateAnswer(dto.getBoardNum(),dto.getReNum());
		System.out.println("UPDATE : "+update);
		
		//업뎃 후 답글 삽입
		int insert = dao.insertAnswer(dto);
		System.out.println("INSERT : "+insert);
		
		return insert;
	}

	@Override
	public int countBoard(int boardNum) {
		//전체 게시글 갯수 파악 함수
		return dao.countBoard(boardNum);
	}

}
