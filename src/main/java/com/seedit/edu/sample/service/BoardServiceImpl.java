package com.seedit.edu.sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedit.edu.sample.dao.BoardDAO;
import com.seedit.edu.sample.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> getBoardList(BoardDTO boardDto) throws Exception {
		
		return boardDAO.getBoardList(boardDto);
	}
	
	@Transactional
	@Override
	public void insertBoard(BoardDTO boardDto) throws Exception {
		
		boardDAO.insertBoard(boardDto);
		//트랜잭션 테스트1
		throw new RuntimeException("강제로 오류를 발생시켜봄");
		
	}
	
	@Override
	public Map<String, Object> selectBoardDetail(BoardDTO boardDto) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String searchType = boardDto.getSearchType();
		System.out.println(searchType);
		if("S".equals(searchType)) {
			int updateHitCnt = boardDAO.updateHitCnt(boardDto);
			
			if (updateHitCnt > 0) {
				resultMap = boardDAO.selectBoardDetail(boardDto);
			}
		} else {
			resultMap = boardDAO.selectBoardDetail(boardDto);
		}
		
		return resultMap;
	}
	/** 게시판 - 수정 */
	@Transactional
	@Override
	public BoardDTO updateBoard(BoardDTO boardDto) throws Exception {

		BoardDTO boardDTO = new BoardDTO();
		
		//트랜잭션 테스트2
		boardDAO.updateHitCnt(boardDTO);
		int updateCnt = boardDAO.updateBoard(boardDto);
		
		if (updateCnt > 0) {
			boardDTO.setResult("SUCCESS");
			boardDTO.setCallBackId("updateBoard");
		} else {
			boardDTO.setResult("FAIL");
		}
		
		return boardDTO;
	}
	/** 게시판 - 삭제 */
	@Override
	public BoardDTO deleteBoard(BoardDTO boardDto) throws Exception {
		
		BoardDTO boardDTO = new BoardDTO();
		
		int deleteCnt = boardDAO.deleteBoard(boardDto);
		
		if (deleteCnt > 0) {
			boardDTO.setResult("SUCCESS");
			boardDTO.setCallBackId("deleteBoard");
		} else {
			boardDTO.setResult("FAIL");
		}
		
		return boardDTO;
	}
}
