package spring.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import spring.board.vo.BoardVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.board.BoardDAOImpl;

/**
 * 보기 컨트롤러 클래스
 * @since 2014-1-13
 * @author hiruan
 */
@Controller("boardViewController")
public class BoardViewController {
	
	@Resource(name="boardDAO")
	private BoardDAOImpl boardDAO;
	
	@RequestMapping("/board/boardView")
	public String boardView(HttpServletRequest request, BoardVo boardVo, 
			Model model) throws Exception {
		// 파라미터
		String searchText = boardVo.getSearchText();
		String searchTextUTF8 = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
		boardVo.setSearchText(searchTextUTF8);
		// 게시물 상세 조회
		boardVo = this.boardDAO.select(boardVo);
		// 게시물 조회수 증가
		this.boardDAO.updateHit(boardVo);
		// View 사용될 객체 설정
		model.addAttribute("boardVo", boardVo);
		return "/board/boardView";
	}

}
