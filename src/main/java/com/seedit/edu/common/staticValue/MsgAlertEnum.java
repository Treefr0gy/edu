package com.seedit.edu.common.staticValue;

public enum MsgAlertEnum {

	AJAX_ALERT_EXCEPTION("오류가 발생하였습니다. \n관리자에게 문의바랍니다.");
	
	private String message;
	
	MsgAlertEnum(String code){
		this.message = code;
	}
	public String getMessage(){
		return this.message;
	}
	public String getMessageWithSuccessOrFail(MsgAlertEnum verb,MsgAlertEnum object){
		return this.message + " "+ verb.getMessage() + " " + object.getMessage() + ".";
	}
}
