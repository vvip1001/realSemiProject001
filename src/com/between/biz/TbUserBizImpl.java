package com.between.biz;

import java.util.List;

import com.between.dao.TbUserDao;
import com.between.dao.TbUserDaoImpl;
import com.between.dto.TbBoardDto;
import com.between.dto.TbUserDto;

public class TbUserBizImpl implements TbUserBiz{

	TbUserDao dao = new TbUserDaoImpl();
	
	@Override
	//로그인 
	public TbUserDto login(String userId,String userPw) {
			return dao.login(userId, userPw) ;
		}

	//회원정보수정
	@Override
	public int userUpdate(TbUserDto dto) {
		return dao.userUpdate(dto);
	}

	//회원탈퇴
	@Override
	public int userDelete(String userId) {
		return dao.userDelete(userId);
	}

	//내 글목록 보기 
	@Override
	public List<TbBoardDto> userBoardList(String userId) {
		return dao.userBoardList(userId);
	}
	
	
	//내 글 상세보기 
	@Override
	public TbBoardDto userBoardSelectOne(int boardNum) {
		return dao.userBoardSelectOne(boardNum);
	}

	//내글 수정하기 
	@Override
	public int userBoardUpdate(TbBoardDto dto) {
		return dao.userBoardUpdate(dto);
	}

	//내글 목록 찾기 
	@Override
	public List<TbBoardDto> userBoardSearch(String boardTitle, String userId) {
		
		return dao.userBoardSearch(boardTitle, userId);
	}

	@Override
	public int userBoardMultiDelete(String[] boardNum) {
		return dao.userBoardMultiDelete(boardNum);
	}

	@Override
	public int userBoardDelete(int boardNum) {
		return dao.userBoardDelete(boardNum);
	}


	

}
