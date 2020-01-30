package com.between.dto;

public class TbLikeDto {

	private String userId;
	private int dicNum;
	
	public TbLikeDto() {
		
	}
	
	public TbLikeDto(String userId, int dicNum) {
		super();
		this.userId = userId;
		this.dicNum = dicNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDicNum() {
		return dicNum;
	}

	public void setDicNum(int dicNum) {
		this.dicNum = dicNum;
	}

	@Override
	public String toString() {
		return "TbLikeDto [userId=" + userId + ", dicNum=" + dicNum + "]";
	}
	
	
	
}
