package spring.board.controller;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import spring.board.vo.BoardVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.board.BoardDAOImpl;

/**
 * 삭제 컨트롤러 클래스
 * @since 2014-1-13
 * @author hiruan
 */
@Controller("boardDeleteController")
public class BoardDeleteController {
	
	@Resource(name="boardDAO")
	private BoardDAOImpl boardDAO;
	
	@RequestMapping("/board/boardDelete")
	public String boardDelete(HttpServletRequest request, BoardVo boardVo, 
			Model model) throws Exception {
		// 파라미터
		String searchText = boardVo.getSearchText();
		String searchTextUTF8 = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
		String searchTextUTF8_E = URLEncoder.encode(searchTextUTF8, "UTF-8");		
		boardVo.setSearchText(searchTextUTF8);	
		// 게시물 삭제
		this.boardDAO.delete(boardVo);
		return "redirect:boardList?pageNum="+boardVo.getPageNum()+
				"&searchType="+boardVo.getSearchType()+"&searchText="+searchTextUTF8_E;
	}

}
