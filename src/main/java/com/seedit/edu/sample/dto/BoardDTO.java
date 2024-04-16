package com.seedit.edu.sample.dto;

import java.util.Date;

public class BoardDTO {

	int boardSeq;
	int boardReRef;
	int boardReLev;
	int boardReSeq;
	String boardWriter;
	String boardSubject;
	String boardContent;
	int boardHits;
	String delYn;
	String insUserId;
	Date insDate;
	String updUserId;
	Date updDate;
	
	String result;
	String callBackId;
	String searchType;
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public int getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(int boardReRef) {
		this.boardReRef = boardReRef;
	}
	public int getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(int boardReLev) {
		this.boardReLev = boardReLev;
	}
	public int getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(int boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardHits() {
		return boardHits;
	}
	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getInsUserId() {
		return insUserId;
	}
	public void setInsUserId(String insUserId) {
		this.insUserId = insUserId;
	}
	public Date getInsDate() {
		return insDate;
	}
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	public String getUpdUserId() {
		return updUserId;
	}
	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCallBackId() {
		return callBackId;
	}
	public void setCallBackId(String callBackId) {
		this.callBackId = callBackId;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	
}
