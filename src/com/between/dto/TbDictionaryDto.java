package com.between.dto;

//연애말사전_니캉내캉 
public class TbDictionaryDto {

 // 글번호 
 private int dicNum;

 // 회원아이디 
 private String userId;

 // 키워드(제목) 
 private String dicKeyword;

 // 남자어(내용2) 
 private String dicMale;

 // 여자어(내용1) 
 private String dicFemale;

 // 신고여부 
 private String dicFlag;

 // 공감횟수(좋아요) 
 private int dicLike;

 public int getDicNum() {
     return dicNum;
 }

 public void setDicNum(int dicNum) {
     this.dicNum = dicNum;
 }

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public String getDicKeyword() {
     return dicKeyword;
 }

 public void setDicKeyword(String dicKeyword) {
     this.dicKeyword = dicKeyword;
 }

 public String getDicMale() {
     return dicMale;
 }

 public void setDicMale(String dicMale) {
     this.dicMale = dicMale;
 }

 public String getDicFemale() {
     return dicFemale;
 }

 public void setDicFemale(String dicFemale) {
     this.dicFemale = dicFemale;
 }

 public String getDicFlag() {
     return dicFlag;
 }

 public void setDicFlag(String dicFlag) {
     this.dicFlag = dicFlag;
 }

 public int getDicLike() {
     return dicLike;
 }

 public void setDicLike(int dicLike) {
     this.dicLike = dicLike;
 }

@Override
public String toString() {
	return "TbDictionaryDto [dicNum=" + dicNum + ", userId=" + userId + ", dicKeyword=" + dicKeyword + ", dicMale="
			+ dicMale + ", dicFemale=" + dicFemale + ", dicFlag=" + dicFlag + ", dicLike=" + dicLike + "]";
}

}