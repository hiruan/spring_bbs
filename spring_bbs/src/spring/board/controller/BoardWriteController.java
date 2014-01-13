package spring.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import spring.board.vo.BoardVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.board.BoardDAOImpl;

/**
 * 등록 컨트롤러 클래스
 * @since 2014-1-13
 * @author hiruan
 */
@Controller("boardWriteController")
public class BoardWriteController {
	
	@Resource(name="boardDAO")
	private BoardDAOImpl boardDAO;
	
	@RequestMapping(value="/board/boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(HttpServletRequest request, BoardVo boardVo, 
			Model model) throws Exception {
		return "/board/boardWrite";
	}
	
	@RequestMapping(value="/board/boardWrite", method=RequestMethod.POST)
	public String boardWrite(HttpServletRequest request, BoardVo boardVo, 
			Model model) throws Exception {
		String ip = request.getRemoteAddr();
		boardVo.setIp(ip);
		// 게시물 등록
		this.boardDAO.insert(boardVo);
		// 페이지 이동
		return "redirect:boardList";
	}

}
