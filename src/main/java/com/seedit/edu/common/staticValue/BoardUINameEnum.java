package com.seedit.edu.common.staticValue;

public enum BoardUINameEnum {

	/**
	 * BOARD_LIST JSP FILE
	 */
	JSP_BOARD_LIST("sample/boardList"),
	
	/**
	 * BOARD_WRITE JSP FILE
	 */
	JSP_BOARD_WRITE("sample/boardWrite"),
	
	/**
	 * BOARD_DETAIL JSP FILE
	 */
	JSP_BOARD_DETAIL("sample/boardDetail"),
	
	/**
	 * BOARD_UPDATE JSP FILE
	 */
	JSP_BOARD_UPDATE("sample/boardUpdate"),
	
	/**
	 * JSP_404_ERROR JSP FILE
	 */
	JSP_404_ERROR("sample/error/404error"),
	
	/**
	 * EXCEPTION JSP FILE
	 */
	JSP_EXCEPTION("sample/error/exception");
	
	private String jspFileName;
	BoardUINameEnum (String code){
		this.jspFileName = code;
	}
	
	public String getJSPFileName(){
		return this.jspFileName;
	}
}
