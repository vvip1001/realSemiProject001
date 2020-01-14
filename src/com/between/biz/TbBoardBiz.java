package com.between.biz;

import java.util.List;

import com.between.dto.TbBoardDto;

public interface TbBoardBiz {

	public List<TbBoardDto> selectList();
	public TbBoardDto selectOne(int boardNum);
	public int insertBoard(TbBoardDto dto);
	public int updateBoard(TbBoardDto dto);
	public int deleteBoard(int boardNum);
	
	public int answerProc(TbBoardDto dto);
}
