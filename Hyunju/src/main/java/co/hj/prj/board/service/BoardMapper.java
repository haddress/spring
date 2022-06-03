package co.hj.prj.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.hj.prj.board.vo.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> boardList(@Param("state") int state, @Param("key") String key);
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	int boardHitUpdate(int boardId);
}
