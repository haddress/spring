package co.hj.prj.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hj.prj.board.service.BoardService;
import co.hj.prj.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardDAO;
	
	// 게시글 전체조회
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		model.addAttribute("boards", boardDAO.boardList(1, "전체글"));
		return "board/boardList";
	}
	
	// 게시글 한 건 상세조회
	@PostMapping("/boardDetail.do")
	public String boardDetail(BoardVO vo, Model model) {
		boardDAO.boardHitUpdate(vo.getBoardId());
		model.addAttribute("content", boardDAO.boardSelect(vo));
		return "board/boardDetail";
	}
	
	// 게시글 검색
	@PostMapping("ajaxSearchList.do")
	@ResponseBody
	public List<BoardVO> ajaxSearchList(@RequestParam("state") int state, @RequestParam("key") String key) {
		return boardDAO.boardList(state, key);
	}
	
	// 게시글 등록
	@PostMapping("/boardInsert.do")
	public String boardInsert(BoardVO vo) {
		boardDAO.boardInsert(vo);
		return "redirect:boardList.do";
	}
	
	// 게시글 등록폼
	@RequestMapping("/boardInsertForm.do")
	public String boardInsertForm() {
		return "board/boardInsertForm";
	}
	
	// 게시글 수정
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(BoardVO vo) {
		boardDAO.boardUpdate(vo);
		return "redirect:boardList.do";
	}

	
	// 게시글 수정폼
	@RequestMapping("/boardUpdateForm.do")
	public String boardUpdateForm(BoardVO vo, Model model) {
		model.addAttribute("board", boardDAO.boardSelect(vo));
		return "board/boardUpdateForm";
	}
	
	// 게시글 삭제
	@RequestMapping("/boardDelete.do")
	public String boardDelete(BoardVO vo) {
		boardDAO.boardDelete(vo);
		return "redirect:boardList.do";
	}

}
