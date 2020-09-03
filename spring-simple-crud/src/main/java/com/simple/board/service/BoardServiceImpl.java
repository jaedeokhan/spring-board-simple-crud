package com.simple.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.board.dao.BoardDAO;
import com.simple.board.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void create(Board board) throws Exception {
		boardDAO.create(board);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return boardDAO.listAll();
	}

	@Override
	public Board read(Integer b_no) throws Exception {
		return boardDAO.read(b_no);
	}

	@Override
	public void delete(Integer b_no) throws Exception {
		boardDAO.delete(b_no);		
	}

	@Override
	public void update(Board board) throws Exception {
		boardDAO.update(board);
	}

}
