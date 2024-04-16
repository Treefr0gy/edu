package com.seedit.edu.sample.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seedit.edu.common.staticValue.BoardUINameEnum;
import com.seedit.edu.sample.dto.BoardDTO;
import com.seedit.edu.sample.service.BoardService;


@Controller
@RequestMapping(value = "/board")
public class BoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/openBoardList.do")
	public ModelAndView openBoardList(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_BOARD_LIST.getJSPFileName());
		
		List<BoardDTO> boardList = boardService.getBoardList(boardDto);
		mv.addObject("list", boardList);
		
		return mv;
	}
	
	@RequestMapping(value="/openBoardWrite.do")
	public ModelAndView openBoardWrite(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_BOARD_WRITE.getJSPFileName());
			
		return mv;
	}
	
	@RequestMapping(value="/insertBoard.do")
	public ModelAndView insertBoard(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/openBoardList.do");
		
		boardService.insertBoard(boardDto);
		
		return mv;
	}
	
	@RequestMapping(value="/openBoardDetail.do")
	public ModelAndView openBoardDetail(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_BOARD_DETAIL.getJSPFileName());
		
		Map<String, Object> map = boardService.selectBoardDetail(boardDto);
		mv.addObject("map", map);
		
		return mv;
	}
	
	/** �Խ��� - ���� ������ �̵� */
	@RequestMapping(value="/openBoardUpdate.do")
	public ModelAndView oepnBoardUpdate(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView(BoardUINameEnum.JSP_BOARD_UPDATE.getJSPFileName());
		
		Map<String, Object> map = boardService.selectBoardDetail(boardDto);
		mv.addObject("map", map);
		
		return mv;
	}
	
	/** �Խ��� - ���� */
	@RequestMapping(value = "/updateBoard.do")
	@ResponseBody
	public BoardDTO updateBoard(HttpServletRequest request, HttpServletResponse response, BoardDTO boardDto) throws Exception{
		
		BoardDTO boardDTO = boardService.updateBoard(boardDto);
		
		return boardDTO;
	}
	
	/** �Խ��� - ���� */
	@RequestMapping(value= "/deleteBoard.do")
	@ResponseBody
	public BoardDTO deleteBoard(HttpServletRequest request, HttpServletResponse response, BoardDTO boardDto) throws Exception{
		
		BoardDTO boardDTO = boardService.deleteBoard(boardDto);
		
		return boardDTO;
	}
}
