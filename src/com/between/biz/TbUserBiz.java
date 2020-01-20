package com.between.biz;

import java.util.List;

import com.between.dto.TbBoardDto;
import com.between.dto.TbUserDto;

public interface TbUserBiz {

		
		//회원가입 , 아이디 중복 체크 , 유효성 검사 - 여정현
		
		
		//로그인 
		public TbUserDto login(String userId,String userPw);
		
		//회원정보 수정
		public int userUpdate(TbUserDto dto) ;
		
		//회원 탈퇴 -> 활동 y으로 변경
		public int userDelete(String userId);
		

		//회원 글목록 보기 
		public List<TbBoardDto> userBoardList(String userId);
		
		//글 하나 선택시 
		public TbBoardDto userBoardSelectOne(int boardNum);
		
		//회원 글 수정하기 
		public int userBoardUpdate(TbBoardDto dto);
		
		//회원 글 찾기 
		public List<TbBoardDto> userBoardSearch(String boardTitle, String userId);

		//회원 글 삭제하기 multi
		public int userBoardMultiDelete(String[] boardNum);
		//단일삭제 
		public int userBoardDelete(int boardNum);


}
