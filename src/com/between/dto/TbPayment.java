package com.between.dto;

//결제내역 
public class TbPayment {

 // 회원아이디 
 private String userId;

 // 보유티켓개수 
 private int pmTicket;

 // 사용한티켓개수 
 private int pmUsed;

 // 결제내역 
 private int pmHistory;

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public int getPmTicket() {
     return pmTicket;
 }

 public void setPmTicket(int pmTicket) {
     this.pmTicket = pmTicket;
 }

 public int getPmUsed() {
     return pmUsed;
 }

 public void setPmUsed(int pmUsed) {
     this.pmUsed = pmUsed;
 }

 public int getPmHistory() {
     return pmHistory;
 }

 public void setPmHistory(int pmHistory) {
     this.pmHistory = pmHistory;
 }

@Override
public String toString() {
	return "TbPayment [userId=" + userId + ", pmTicket=" + pmTicket + ", pmUsed=" + pmUsed + ", pmHistory=" + pmHistory
			+ "]";
}

}