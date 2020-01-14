package com.between.dto;

import java.sql.Date;

//댓글 게시판 
public class TbReBoard {
 
 // 글번호 
 private int boardNum;
 // 작성자 
 private String writer;
 // 댓글내용 
 private String reContent;
 // 그룹번호 
 private int reNum;
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

 public int getBoardNum() {
     return boardNum;
 }

 public void setBoardNum(int boardNum) {
     this.boardNum = boardNum;
 }

 public String getWriter() {
     return writer;
 }

 public void setWriter(String writer) {
     this.writer = writer;
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
	return "TbReBoard [boardNum=" + boardNum + ", writer=" + writer + ", reContent=" + reContent + ", reNum=" + reNum
			+ ", reTab=" + reTab + ", reDate=" + reDate + ", reDeleteCheck=" + reDeleteCheck + ", reFlag=" + reFlag
			+ ", reFlagType=" + reFlagType + "]";
}

}