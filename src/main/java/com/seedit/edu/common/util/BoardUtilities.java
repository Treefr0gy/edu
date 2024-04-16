package com.seedit.edu.common.util;

import javax.servlet.http.HttpServletRequest;

public class BoardUtilities {

	public boolean isAjaxRequest(HttpServletRequest req){
		String header = req.getHeader("AJAX");
		return "true".equals(header);
	}
	
}
