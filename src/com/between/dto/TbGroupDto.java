package com.between.dto;

//커플 
public class TbGroupDto {

 // 커플 그룹 번호 
 private int groupNum;

 // 파트너아이디(직접입력) 
 private String partnerId;

 // 회원아이디 
 private String userId;
 
 // 확인여부
 private String groupCheck;

 public int getGroupNum() {
     return groupNum;
 }

 public void setGroupNum(int groupNum) {
     this.groupNum = groupNum;
 }

 public String getPartnerId() {
     return partnerId;
 }

 public void setPartnerId(String partnerId) {
     this.partnerId = partnerId;
 }

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

public String getGroupCheck() {
	return groupCheck;
}

public void setGroupCheck(String groupCheck) {
	this.groupCheck = groupCheck;
}

@Override
public String toString() {
	return "TbGroupDto [groupNum=" + groupNum + ", partnerId=" + partnerId + ", userId=" + userId + ", groupCheck="
			+ groupCheck + "]";
}


}