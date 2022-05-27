package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		String message = "";
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		
		vo = dao.memberLogin(vo);
		if(vo.getName() != null) {
			session.setAttribute("id", vo.getId());  //세션에 아이디 담고
			session.setAttribute("name", vo.getName());  //이름 담고
			session.setAttribute("author", vo.getAuthor()); //권한 담고
			message = vo.getName() + "님 환영합니다.";
		}else {
			message = "아이디 또는 패스워드가 존재하지 않습니다.";
		}
		
		request.setAttribute("message", message);
		return "member/memberLogin.tiles";
	}

}
