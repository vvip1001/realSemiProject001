package com.between.dao;

import java.util.List;

import com.between.dto.TbReBoardDto;

public interface TbReBoardDao {
	public List<TbReBoardDto> selectList(int pageNum, int pageCount,int boardNum);
	public int insertReBoard(TbReBoardDto dto);
	public int updateReBoard(TbReBoardDto dto);
	
	public int checkGroupBoard(int boardNum);
	public int deleteBoard(int boardNum);
	public int updateBoardCheck(int boardNum);
	
	public int updateAnswer(int boardNum, int parentReNum);
	public int insertAnswer(TbReBoardDto dto);
	
	public int countBoard(int boardNum);
}
