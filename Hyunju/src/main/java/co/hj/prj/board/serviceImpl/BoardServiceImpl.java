package co.hj.prj.board.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hj.prj.board.service.BoardMapper;
import co.hj.prj.board.service.BoardService;
import co.hj.prj.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper map;
	
	@Override
	public List<BoardVO> boardList(int state, String key) {
		return map.boardList(state, key);
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		return map.boardSelect(vo);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		return map.boardInsert(vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return map.boardUpdate(vo);
	}

	@Override
	public int boardDelete(BoardVO vo) {
		return map.boardUpdate(vo);
	}

	@Override
	public int boardHitUpdate(int boardId) {
		return map.boardHitUpdate(boardId);
	}

}
