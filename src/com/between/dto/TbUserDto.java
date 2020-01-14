package com.between.dto;

import java.sql.Date;

public class TbUserDto {
	
	// 회원아이디 
    private String userId;
    // 비밀번호 
    private String userPw;
    // 이름 
    private String userName;
    // 성별 
    private String userGender;
    // 나의애칭 
    private String userNick;
    // 생년월일 
    private String userDob;
    // 이메일 
    private String userEmail;
    // 탈퇴여부 
    private String userDeact;
    // 등급 
    private String userStatus;
    // 탈퇴날짜 
    private Date userDeactDate;
    // 가입날짜 
    private Date userRegdate;
    
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserDob() {
		return userDob;
	}
	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserDeact() {
		return userDeact;
	}
	public void setUserDeact(String userDeact) {
		this.userDeact = userDeact;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Date getUserDeactDate() {
		return userDeactDate;
	}
	public void setUserDeactDate(Date userDeactDate) {
		this.userDeactDate = userDeactDate;
	}
	public Date getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
	}
	public int getUserFlagno() {
		return userFlagno;
	}
	public void setUserFlagno(int userFlagno) {
		this.userFlagno = userFlagno;
	}
	public int getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}
	public String getUserAlbumPath() {
		return userAlbumPath;
	}
	public void setUserAlbumPath(String userAlbumPath) {
		this.userAlbumPath = userAlbumPath;
	}
	public String getUserAlbumTitile() {
		return userAlbumTitile;
	}
	public void setUserAlbumTitile(String userAlbumTitile) {
		this.userAlbumTitile = userAlbumTitile;
	}
	// 신고횟수 
    private int userFlagno;
    // 커플 그룹 번호 
    private int groupNum;
    // 앨범경로 
    private String userAlbumPath;
    // 앨범제목 
    private String userAlbumTitile;

	@Override
	public String toString() {
		return "TbUserDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userGender="
				+ userGender + ", userNick=" + userNick + ", userDob=" + userDob + ", userEmail=" + userEmail
				+ ", userDeact=" + userDeact + ", userStatus=" + userStatus + ", userDeactDate=" + userDeactDate
				+ ", userRegdate=" + userRegdate + ", userFlagno=" + userFlagno + ", groupNum=" + groupNum
				+ ", userAlbumPath=" + userAlbumPath + ", userAlbumTitile=" + userAlbumTitile + "]";
	}
}
