package com.seedit.edu.sample.service;

import java.util.List;
import java.util.Map;

import com.seedit.edu.sample.dto.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList(BoardDTO boardDto) throws Exception;
	
	void insertBoard(BoardDTO boardDto) throws Exception;
	
	Map<String, Object> selectBoardDetail(BoardDTO boardDto) throws Exception;
	
	BoardDTO updateBoard(BoardDTO boardDto) throws Exception;
	
	BoardDTO deleteBoard(BoardDTO boardDto) throws Exception;
}
