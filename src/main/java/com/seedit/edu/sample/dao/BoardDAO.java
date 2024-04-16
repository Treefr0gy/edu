package com.seedit.edu.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.seedit.edu.common.dao.AbstractDAO;
import com.seedit.edu.sample.dto.BoardDTO;

@Repository
public class BoardDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<BoardDTO> getBoardList(BoardDTO boardDto) throws Exception {
		return selectList("sampleBoard.getBoardList", boardDto);
	}
	
	public void insertBoard(BoardDTO boardDto) throws Exception {
		insert("sampleBoard.insertBoard", boardDto);
	}
	
	public int updateHitCnt(BoardDTO boardDto) throws Exception{
		return (int) update("sampleBoard.updateHitCnt", boardDto);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(BoardDTO boardDto) throws Exception{
		return (Map<String, Object>) selectOne("sampleBoard.selectBoardDetail", boardDto);
	}
	
	public int updateBoard(BoardDTO boardDto) throws Exception {
		return (int) update("sampleBoard.updateBoard", boardDto);
	}
	
	public int deleteBoard(BoardDTO boardDto) throws Exception {
		return (int) update("sampleBoard.deleteBoard", boardDto);
	}
}
