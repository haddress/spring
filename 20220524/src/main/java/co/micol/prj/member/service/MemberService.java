package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdater(MemberVO vo);
	int memberDelete(MemberVO vo);
	MemberVO memberLogin(MemberVO vo);
	boolean memberIdcheck(String id);
}
