package com.simple.board.dao;

import java.util.List;

import com.simple.board.vo.Board;

public interface BoardDAO {
	public void create(Board board) throws Exception;

	public List<Board> listAll() throws Exception;

	public Board read(Integer b_no) throws Exception;

	public void delete(Integer b_no) throws Exception;

	public void update(Board board) throws Exception;
}
