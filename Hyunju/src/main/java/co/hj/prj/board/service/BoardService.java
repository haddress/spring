package co.hj.prj.board.service;

import java.util.List;

import co.hj.prj.board.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> boardList(int state, String key);
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	int boardHitUpdate(int boardId);

}
