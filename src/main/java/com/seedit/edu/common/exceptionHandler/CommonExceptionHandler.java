package com.seedit.edu.common.exceptionHandler;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.seedit.edu.common.staticValue.BoardUINameEnum;
import com.seedit.edu.common.staticValue.MsgAlertEnum;
import com.seedit.edu.common.util.BoardUtilities;

@ControllerAdvice
public class CommonExceptionHandler {

	private static final Logger logger = Logger.getLogger(CommonExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {InvalidParameterException.class})
	protected ModelAndView handleBadRequest(HttpServletRequest req, Exception e) {
		logger.error("Exception: {}"+ e.toString());
		printExceptionInfo(req, e);
		
		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_EXCEPTION.getJSPFileName());
		mv.addObject("code", "400");
		mv.addObject("message", e.getMessage());
		return mv;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {NoHandlerFoundException.class})
	protected ModelAndView handleNotFound(HttpServletRequest req, Exception e) {
		logger.error("Exception: {}"+ e.toString());
		printExceptionInfo(req, e);
		
		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_404_ERROR.getJSPFileName());
		mv.addObject("code", "404");
		mv.addObject("message", e.getMessage());
		return mv;
	}
	
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = {SQLException.class, DataAccessException.class})
//	protected ModelAndView handleInternalServerError(HttpServletRequest req, Exception e) {
//		logger.error("Exception: {}"+ e.toString());
//		printExceptionInfo(req, e);
//		
//		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_EXCEPTION.getJSPFileName());
//		mv.addObject("code", "500");
//		mv.addObject("message", e.getMessage());
//		return mv;
//	}
//	
//	@ExceptionHandler(RuntimeException.class)
//	protected ModelAndView runtimeException(HttpServletRequest req, HttpServletResponse resp, Exception e) {
//		logger.error("Exception: {}" + e.getMessage());
//		printExceptionInfo(req, e);
//		
//		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_EXCEPTION.getJSPFileName());
//		mv.addObject("message", e.getMessage());
//		return mv;
//		
//	}
	
	@ExceptionHandler(Exception.class)
	public void exception(HttpServletRequest req, HttpServletResponse resp, Exception e) {
		logger.error("Exception: {}" + e.getMessage());
		printExceptionInfo(req, e);
	}
	
	
	private void printExceptionInfo(HttpServletRequest req, Exception e){
		for(StackTraceElement s : e.getStackTrace()){
			logger.error("Stack: {}" + s);
		}
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Object handleRuntimeException(RuntimeException e, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Exception table에 익셉션  추가
		logger.info("========================== [ Exception Handler Log ] ===========================");
		logger.info("["+ e.getStackTrace()[0].getClassName() + "]." + e.getStackTrace()[0].getMethodName() + "()");
		logger.info(" * Exception : " + e.toString());
		logger.info("================================================================================");
		
		BoardUtilities util = new BoardUtilities();
		// AJAX Request 인 경우 Message로 Return
		if(util.isAjaxRequest(request)){ //Head가 ajax인지 분기
			HashMap<String, Object> responseValue = new HashMap<String, Object>(); // ~ 에 쓸 데이터 객체
			responseValue.put("isException", true); // 트루 담음
			responseValue.put("returnExceptionMsg", MsgAlertEnum.AJAX_ALERT_EXCEPTION.getMessage());
			//String json = new Gson().toJson(responseValue);
			response.setStatus(500);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return responseValue;
		}else{ //Ajax 외의 Request인 경우 ModelAndView로 Return
			ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_EXCEPTION.getJSPFileName());
			mv.addObject("code", "500");
			mv.addObject("message", e.getMessage());
			return mv;
		}
	}
}
