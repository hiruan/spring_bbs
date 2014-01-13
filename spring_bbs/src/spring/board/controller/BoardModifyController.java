package spring.board.controller;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import spring.board.vo.BoardVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.board.BoardDAOImpl;

/**
 * 수정 컨트롤러 클래스
 * @since 2014-1-13
 * @author hiruan
 */
@Controller("boardModifyController")
public class BoardModifyController {
	
	@Resource(name="boardDAO")
	private BoardDAOImpl boardDAO;
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.GET)
	public String boardModifyForm(HttpServletRequest request, BoardVo boardVo, 
			Model model) throws Exception {
		// 파라미터
		String searchText = request.getParameter("searchText");
		String searchTextUTF8 = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
		boardVo.setSearchText(searchTextUTF8);
		// 게시물 상세 조회
		boardVo = this.boardDAO.select(boardVo);
		// View 사용될 객체 설정
		model.addAttribute("boardVo", boardVo);
		return "/board/boardModify";
	}
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.POST)
	public String boardModify(HttpServletRequest request, BoardVo boardVo, 
			Model model) throws Exception {
		// 파라미터
		String searchText = boardVo.getSearchText();
		String searchTextUTF8_E = URLEncoder.encode(searchText, "UTF-8");
		String ip = request.getRemoteAddr();
		boardVo.setIp(ip);
		// 게시물 수정
		this.boardDAO.update(boardVo);
		// 페이지 이동	
		return "redirect:boardView?num="+boardVo.getNum()+"&pageNum="+boardVo.getPageNum()+
				"&searchType="+boardVo.getSearchType()+"&searchText="+searchTextUTF8_E;
	}

}
