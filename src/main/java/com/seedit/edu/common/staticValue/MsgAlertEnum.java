package com.seedit.edu.common.staticValue;

public enum MsgAlertEnum {

	AJAX_ALERT_EXCEPTION("������ �߻��Ͽ����ϴ�. \n�����ڿ��� ���ǹٶ��ϴ�.");
	
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
