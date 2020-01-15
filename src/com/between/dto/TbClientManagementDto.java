package com.between.dto;

//내담자관리 
public class TbClientManagementDto {

 // 내담자관리번호 
 private int clientNum;

 // 커플 그룹 번호 
 private int groupNum;

 // 회원아이디 
 private String userId;

 public int getClientNum() {
     return clientNum;
 }

 public void setClientNum(int clientNum) {
     this.clientNum = clientNum;
 }

 public int getGroupNum() {
     return groupNum;
 }

 public void setGroupNum(int groupNum) {
     this.groupNum = groupNum;
 }

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

@Override
public String toString() {
	return "TbClientManagementDto [clientNum=" + clientNum + ", groupNum=" + groupNum + ", userId=" + userId + "]";
}

}