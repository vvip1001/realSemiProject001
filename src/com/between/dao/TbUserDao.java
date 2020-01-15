package com.between.dao;

import com.between.dto.TbUserDto;

public interface TbUserDao {


	//회원가입 , 아이디 중복 체크 , 유효성 검사 - 여정현
	
	
	//로그인 
	public  TbUserDto login(String userId,String userPw) ;
	
	//회원정보 수정
	public int update(TbUserDto dto);
	
	//회원 탈퇴 -> 활동 y으로 변경
	public int delete(String userId);
}
