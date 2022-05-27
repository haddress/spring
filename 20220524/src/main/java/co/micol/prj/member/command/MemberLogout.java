package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리
		HttpSession session = request.getSession();
		session.invalidate(); //세션값을 완전히 삭제한다.
		request.setAttribute("message", "정상적으로 로그아웃 처리 되었습니다.");
		return "member/memberLogout.tiles";
	}

}
