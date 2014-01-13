package spring.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import spring.board.vo.BoardVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.PageNavigator;
import dao.board.BoardDAOImpl;

/**
 * 목록 컨트롤러 클래스
 * @since 2014-1-13
 * @author hiruan
 */
@Controller("boardListController")
public class BoardListController {
	
	@Resource(name="boardDAO")
	private BoardDAOImpl boardDAO;
	
	@RequestMapping("/board/boardList")
	public String boardList(HttpServletRequest request, BoardVo boardVo, 
			Model model) throws Exception {
		// 파라미터
		String pageNum = boardVo.getPageNum();
		String searchType = boardVo.getSearchType();
		String searchText = boardVo.getSearchText();
		String searchTextUTF8 = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
		boardVo.setSearchText(searchTextUTF8);
		// 게시물 총 수
		int totalCount = this.boardDAO.selectCount(boardVo);
		// 게시물 목록을 얻는 쿼리 실행
		List<BoardVo> boardList = this.boardDAO.selectList(boardVo);
		// View 사용될 객체 설정
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNavigator", new PageNavigator().getPageNavigator(
			totalCount, boardVo.getListCount(), boardVo.getPagePerBlock(), 
				Integer.parseInt(pageNum), searchType, searchTextUTF8));
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardVo", boardVo);
		
		return "/board/boardList";
	}

}
