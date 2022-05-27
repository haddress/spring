package co.micol.prj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원목록 보기
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("id")+"======================");
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = dao.memberSelectList();
		request.setAttribute("members", members);
		return "member/memberSelectList.tiles";
	}

}
