package com.between.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.between.common.SqlMapConfig;
import com.between.dto.TbUserDto;

public class TbUserDaoImpl extends SqlMapConfig implements TbUserDao{
	private String namespace = "com.between.common.mapper.";
	
	@Override
	public TbUserDto login(String userId, String userPw) {
		SqlSession session = null; 
		TbUserDto dto = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"login",map);
		} catch (Exception e) {
			System.out.println("에러 login");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int update(TbUserDto dto) {
		SqlSession session = null; 
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + "updateJoin",dto);
			
		} catch (Exception e) {
			System.out.println("에러 insert");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res ;
	}

	@Override
	public int delete(String userId) {
		SqlSession session = null; 
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace+"delete",userId);
		} catch (Exception e) {
			System.out.println("에러 delete");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res; 
	}
	
	


}
