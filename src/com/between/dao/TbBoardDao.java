package com.between.dao;

import java.util.List;

import com.between.dto.TbBoardDto;

public interface TbBoardDao {
	
	public List<TbBoardDto> selectList();
	public TbBoardDto selectOne(int boardNum);
	public int insertBoard(TbBoardDto dto);
	public int updateBoard(TbBoardDto dto);
	public int deleteBoard(int boardNum);
	
	public int updateAnswer(int parentBoardNum);
	public int insertAnswer(TbBoardDto dto);

}
