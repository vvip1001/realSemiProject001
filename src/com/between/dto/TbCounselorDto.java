package com.between.dto;

//상담사 페이지 
public class TbCounselorDto {

 // 회원아이디(상담사) 
 private String userId;

 // 상담진행여부 
 private String counselorProgressCheck;

 // 상담목적 
 private String counselorPurpose;

 // 인출티켓개수 
 private int counselorTicketUsed;

 // 보유티켓개수 
 private int counselorTicket;

 // 일정관리 
 private String counselorSchedule;

 // 요일 
 private String counselorDay;

 // 시간 
 private String counselorTime;

 // 평가점수 
 private int counselorScore;

 // 내담자관리번호 
 private int clientNum;

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public String getCounselorProgressCheck() {
     return counselorProgressCheck;
 }

 public void setCounselorProgressCheck(String counselorProgressCheck) {
     this.counselorProgressCheck = counselorProgressCheck;
 }

 public String getCounselorPurpose() {
     return counselorPurpose;
 }

 public void setCounselorPurpose(String counselorPurpose) {
     this.counselorPurpose = counselorPurpose;
 }

 public int getCounselorTicketUsed() {
     return counselorTicketUsed;
 }

 public void setCounselorTicketUsed(int counselorTicketUsed) {
     this.counselorTicketUsed = counselorTicketUsed;
 }

 public int getCounselorTicket() {
     return counselorTicket;
 }

 public void setCounselorTicket(int counselorTicket) {
     this.counselorTicket = counselorTicket;
 }

 public String getCounselorSchedule() {
     return counselorSchedule;
 }

 public void setCounselorSchedule(String counselorSchedule) {
     this.counselorSchedule = counselorSchedule;
 }

 public String getCounselorDay() {
     return counselorDay;
 }

 public void setCounselorDay(String counselorDay) {
     this.counselorDay = counselorDay;
 }

 public String getCounselorTime() {
     return counselorTime;
 }

 public void setCounselorTime(String counselorTime) {
     this.counselorTime = counselorTime;
 }

 public int getCounselorScore() {
     return counselorScore;
 }

 public void setCounselorScore(int counselorScore) {
     this.counselorScore = counselorScore;
 }

 public int getClientNum() {
     return clientNum;
 }

 public void setClientNum(int clientNum) {
     this.clientNum = clientNum;
 }

@Override
public String toString() {
	return "TbCounselorDto [userId=" + userId + ", counselorProgressCheck=" + counselorProgressCheck
			+ ", counselorPurpose=" + counselorPurpose + ", counselorTicketUsed=" + counselorTicketUsed
			+ ", counselorTicket=" + counselorTicket + ", counselorSchedule=" + counselorSchedule + ", counselorDay="
			+ counselorDay + ", counselorTime=" + counselorTime + ", counselorScore=" + counselorScore + ", clientNum="
			+ clientNum + "]";
}

}