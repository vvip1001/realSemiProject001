package com.between.dto;

import java.sql.Date;

//게시판,답글 
public class TbBoardDto {

 // 회원아이디 
 private String userId;
 // 회원성별
 private String boardGender;
 // 글번호 
 private int boardNum;
 // 그룹번호 
 private int boardGroupNum;
 // 그룹순서 
 private int boardGroupOrder;
 // 글탭번호 
 private int boardTab;
 // 삭제여부 
 private String boardDeleteCheck;
 // 글제목 
 private String boardTitle;
 // 글내용 
 private String boardContent;
 // 조회수 
 private String boardViewCount;
 // 작성일 
 private Date boardDate;
 // 글타입(NORMAL, NOTICE)
 private String boardType;
 // 신고 
 private String boardFlag;
 // 신고유형 
 private String boardFlagType;
 
 
 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public String getBoardGender() {
	return boardGender;
}

public void setBoardGender(String boardGender) {
	this.boardGender = boardGender;
}

public int getBoardNum() {
     return boardNum;
 }

 public void setBoardNum(int boardNum) {
     this.boardNum = boardNum;
 }

 public int getBoardGroupNum() {
     return boardGroupNum;
 }

 public void setBoardGroupNum(int boardGroupNum) {
     this.boardGroupNum = boardGroupNum;
 }

 public int getBoardGroupOrder() {
     return boardGroupOrder;
 }

 public void setBoardGroupOrder(int boardGroupOrder) {
     this.boardGroupOrder = boardGroupOrder;
 }

 public int getBoardTab() {
     return boardTab;
 }

 public void setBoardTab(int boardTab) {
     this.boardTab = boardTab;
 }

 public String getBoardDeleteCheck() {
     return boardDeleteCheck;
 }

 public void setBoardDeleteCheck(String boardDeleteCheck) {
     this.boardDeleteCheck = boardDeleteCheck;
 }

 public String getBoardTitle() {
     return boardTitle;
 }

 public void setBoardTitle(String boardTitle) {
     this.boardTitle = boardTitle;
 }

 public String getBoardContent() {
     return boardContent;
 }

 public void setBoardContent(String boardContent) {
     this.boardContent = boardContent;
 }

 public String getBoardViewCount() {
     return boardViewCount;
 }

 public void setBoardViewCount(String boardViewCount) {
     this.boardViewCount = boardViewCount;
 }

 public Date getBoardDate() {
     return boardDate;
 }

 public void setBoardDate(Date boardDate) {
     this.boardDate = boardDate;
 }

 public String getBoardType() {
     return boardType;
 }

 public void setBoardType(String boardType) {
     this.boardType = boardType;
 }

 public String getBoardFlag() {
     return boardFlag;
 }

 public void setBoardFlag(String boardFlag) {
     this.boardFlag = boardFlag;
 }

 public String getBoardFlagType() {
     return boardFlagType;
 }

 public void setBoardFlagType(String boardFlagType) {
     this.boardFlagType = boardFlagType;
 }

@Override
public String toString() {
	return "TbBoardDto [userId=" + userId + ", boardNum=" + boardNum + ", boardGroupNum=" + boardGroupNum
			+ ", boardGroupOrder=" + boardGroupOrder + ", boardTab=" + boardTab + ", boardDeleteCheck="
			+ boardDeleteCheck + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardViewCount="
			+ boardViewCount + ", boardDate=" + boardDate + ", boardType=" + boardType + ", boardFlag=" + boardFlag
			+ ", boardFlagType=" + boardFlagType + "]";
}

}