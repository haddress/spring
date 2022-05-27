package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setAdr(request.getParameter("adr"));
		vo.setEmail(request.getParameter("email"));
		
		int n = dao.memberInsert(vo);
		
		if(n != 0) {
			request.setAttribute("message", "회원가입이 성공적으로 처리되었습니다.");
		}else {
			request.setAttribute("message", "회원가입이 실패했습니다.");
		}
		
		return "member/memberJoin.tiles";
	}

}
