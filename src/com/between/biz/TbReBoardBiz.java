package com.between.biz;

import java.util.List;

import com.between.dto.TbReBoardDto;

public interface TbReBoardBiz {

	public List<TbReBoardDto> selectList(int pageNum, int pageCount,int boardNum);
	public int insertReBoard(TbReBoardDto dto);
	public int updateReBoard(TbReBoardDto dto);
	public int deleteReBoard(int boardNum);
	
	public int checkReBoardDelete(int boardNum);
	public int answerProc(TbReBoardDto dto);
	
	public int countBoard();
}
