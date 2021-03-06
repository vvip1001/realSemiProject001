package com.between.dto;

import java.sql.Date;

//댓글 게시판 
public class TbReBoardDto {
 
 // 글번호 
 private int boardNum;
 // 댓글번호
 private int reNum;
 // 작성자 
 private String userId;
 // 댓글내용 
 private String reContent;
 // 그룹번호 
 private int reGroupNum;
 // 댓글탭번호 
 private int reTab;
 // 작성일 
 private Date reDate;
 // 삭제여부 
 private String reDeleteCheck;
 // 신고 
 private String reFlag;
 // 신고유형 
 private String reFlagType;
 
 private int reOrder;
 private String reGender;

 
 
 
 public int getReOrder() {
	return reOrder;
}


public void setReOrder(int reOrder) {
	this.reOrder = reOrder;
}


public String getReGender() {
	return reGender;
}


public void setReGender(String reGender) {
	this.reGender = reGender;
}


public int getBoardNum() {
     return boardNum;
 }
 

 public int getReGroupNum() {
	return reGroupNum;
}


public void setReGroupNum(int reGroupNum) {
	this.reGroupNum = reGroupNum;
}


public void setBoardNum(int boardNum) {
     this.boardNum = boardNum;
 }

 public String getUserId() {
	return userId;
}


public void setUserId(String userId) {
	this.userId = userId;
}


public String getReContent() {
     return reContent;
 }

 public void setReContent(String reContent) {
     this.reContent = reContent;
 }

 public int getReNum() {
     return reNum;
 }

 public void setReNum(int reNum) {
     this.reNum = reNum;
 }

 public int getReTab() {
     return reTab;
 }

 public void setReTab(int reTab) {
     this.reTab = reTab;
 }

 public Date getReDate() {
     return reDate;
 }

 public void setReDate(Date reDate) {
     this.reDate = reDate;
 }

 public String getReDeleteCheck() {
     return reDeleteCheck;
 }

 public void setReDeleteCheck(String reDeleteCheck) {
     this.reDeleteCheck = reDeleteCheck;
 }

 public String getReFlag() {
     return reFlag;
 }

 public void setReFlag(String reFlag) {
     this.reFlag = reFlag;
 }

 public String getReFlagType() {
     return reFlagType;
 }

 public void setReFlagType(String reFlagType) {
     this.reFlagType = reFlagType;
 }


@Override
public String toString() {
	return "TbReBoard [boardNum=" + boardNum + ", reNum=" + reNum + ", userId=" + userId + ", reContent=" + reContent
			+ ", reGroupNum=" + reGroupNum + ", reTab=" + reTab + ", reDate=" + reDate + ", reDeleteCheck="
			+ reDeleteCheck + ", reFlag=" + reFlag + ", reFlagType=" + reFlagType + "]";
}


}