package com.between.biz;

import com.between.dao.TbUserDao;
import com.between.dao.TbUserDaoImpl;
import com.between.dto.TbUserDto;

public class TbUserBizImpl implements TbUserBiz{

	TbUserDao dao = new TbUserDaoImpl();
	
	@Override
	//로그인 
	public TbUserDto login(String userId,String userPw) {
			return dao.login(userId, userPw) ;
		}

	@Override
	public int update(TbUserDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(String userId) {
		return dao.delete(userId);
	}

}
