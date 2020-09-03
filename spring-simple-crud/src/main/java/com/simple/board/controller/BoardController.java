package com.simple.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.board.service.BoardService;
import com.simple.board.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createForm(ModelAndView mav) throws Exception{
		log.debug("★★★★★ create.jsp ★★★★★");
		mav.setViewName("create");
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(Board board, RedirectAttributes redirectAttr) throws Exception{
		log.debug("★★★★★ 게시판 데이터 삽입 ★★★★★");
	
		boardService.create(board);
		redirectAttr.addFlashAttribute("msg", "성공");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public ModelAndView listAll(ModelAndView mav) throws Exception{
		log.debug("★★★★★ 게시판 목록 불러오기 ★★★★★");
		mav.addObject("boardList", boardService.listAll());
		mav.setViewName("listAll");
		return mav;
	}
	
	@RequestMapping(value="/detail/{b_no}", method=RequestMethod.GET)
	public ModelAndView detail(@PathVariable("b_no") int b_no, ModelAndView mav) throws Exception{
		log.debug("★★★★★ 게시판  "+ b_no +"번 상세보기 ★★★★★");
		mav.addObject("boardDetail", boardService.read(b_no));
		mav.setViewName("detail");
		return mav;
	}
	
	@RequestMapping(value="/update/{b_no}", method=RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("b_no") int b_no, ModelAndView mav) throws Exception{
		log.debug("★★★★★  update.jsp ★★★★★");
		mav.addObject("boardUpdate", boardService.read(b_no));
		mav.setViewName("update");
		return mav;
	}
	
	@RequestMapping(value="/update/{b_no}", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute Board boardUpdate, ModelAndView mav) throws Exception{
		log.debug("★★★★★ 게시판  "+ boardUpdate.getB_no() +"번 업데이트 ★★★★★");
		boardService.update(boardUpdate);
		mav.setViewName("redirect:/board/listAll");
		return mav;
	}
	
	@RequestMapping(value="/delete/{b_no}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("b_no") int b_no, ModelAndView mav) throws Exception{
		log.debug("★★★★★ 게시판  "+ b_no +"번 삭제 수행 ★★★★★");
		boardService.delete(b_no);
		mav.setViewName("redirect:/board/listAll");
		return mav;
	}
	
}
