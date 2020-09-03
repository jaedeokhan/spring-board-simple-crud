package com.simple.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.board.vo.Board;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "com.simple.board.mapper.BoardMapper";
	
	// 게시판 추가
	@Override
	public void create(Board board) throws Exception {
		sqlSession.selectList(namespace + ".insertBoard", board);
	}

	// 게시판 보기
	@Override
	public List<Board> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listBoard");
	}
	
	// 게시판 상세
	@Override
	public Board read(Integer b_no) throws Exception {
		return sqlSession.selectOne(namespace + ".detailBoard", b_no);
	}

	// 게시판 삭제
	@Override
	public void delete(Integer b_no) throws Exception {
		sqlSession.delete(namespace + ".deleteBoard", b_no); 
		
	}
	
	// 게시판 수정
	@Override
	public void update(Board board) throws Exception {
		sqlSession.update(namespace + ".updateBoard", board); 
		
	}

}
