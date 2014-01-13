package dao.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.board.vo.BoardVo;

/**
 * 게시판 DAO 인터페이스
 * @since 2014.01.13
 * @author hiruan
 */

public interface BoardDAOImpl {
	
	/**
	 * 게시판 목록 조회
	 * @param boardVo
	 * @return
	 */
	public List<BoardVo> selectList(BoardVo boardVo);
	
	/**
	 * 게시판 수 조회
	 * @param boardVo
	 * @return
	 */
	public int selectCount(BoardVo boardVo);
	
	/**
	 * 게시판 상세 조회
	 * @param boardVo
	 * @return
	 */
	public BoardVo select(BoardVo boardVo);
	
	/**
	 * 게시판 등록 처리
	 * @param boardVo
	 */
	public void insert(BoardVo boardVo);
	
	/**
	 * 게시판 수정 처리
	 * @param boardVo
	 */
	public void update(BoardVo boardVo);
	
	/**
	 * 게시판 조회수 증가 수정 처리
	 * @param boardVo
	 */
	public void updateHit(BoardVo boardVo);
	
	/**
	 * 게시판 삭제 처리
	 * @param boardVo
	 */
	public void delete(BoardVo boardVo);

}
