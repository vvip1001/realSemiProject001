package com.between.biz;

import java.util.List;

import com.between.dto.TbBoardDto;

public interface TbBoardBiz {

	public List<TbBoardDto> selectList(int pageNum, int pageCount);
	public TbBoardDto selectOne(int boardNum);
	public int insertBoard(TbBoardDto dto);
	public int updateBoard(TbBoardDto dto);
	public int deleteBoard(int boardNum);
	
	public int checkBoardDelete(int boardNum);//게시글 삭제 함수
	public int answerProc(TbBoardDto dto);//답글 추가 함수
	
	public int countBoard();//게시글 갯수 파악 함수
	
	public int updateViewCount(int boardNum);
}
