package dao.board;

import java.util.List;

import spring.board.vo.BoardVo;
import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;


/**
 * 게시판 MYBATIS DAO 클래스
 * @since 2014.01.13
 * @author hiruan
 */

@Repository("boardDAO")
public class BoardDAO implements BoardDAOImpl {
	
	/** Mybatis SQL 팩토리 */
	private SqlSessionFactory sessionFactory = null;
	
	public BoardDAO() {
		this.sessionFactory = MyBatis.getSqlSessionFactory();
	}

	/**
	 * 게시판 목록 조회
	 * @param boardVo
	 * @return
	 */
	public List<BoardVo> selectList(BoardVo boardVo) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectList("board.selectList", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return null;
	}
	
	/**
	 * 게시판 수 조회
	 * @param boardVo
	 * @return
	 */
	public int selectCount(BoardVo boardVo) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectOne("board.selectCount", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return 0;
	}
	
	/**
	 * 게시판 상세 조회
	 * @param boardVo
	 * @return
	 */
	public BoardVo select(BoardVo boardVo) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectOne("board.select", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return null;
	}
	
	/**
	 * 게시판 등록 처리
	 * @param boardVo
	 */
	public void insert(BoardVo boardVo) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.insert("board.insert", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
	/**
	 * 게시판 수정 처리
	 * @param boardVo
	 */
	public void update(BoardVo boardVo) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.update("board.update", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
	/**
	 * 게시판 조회수 증가 수정 처리
	 * @param boardVo
	 */
	public void updateHit(BoardVo boardVo) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.insert("board.updateHit", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
	/**
	 * 게시판 삭제 처리
	 * @param boardVo
	 */
	public void delete(BoardVo boardVo) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.delete("board.delete", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
}
