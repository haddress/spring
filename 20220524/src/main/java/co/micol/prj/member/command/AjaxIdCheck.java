package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복체크
		MemberService dao = new MemberServiceImpl();
		boolean b = false;
		String result = "N";
		b = dao.memberIdcheck(request.getParameter("id"));
		if(!b) {
			result = "Yes";
		}
		return "ajax:" + result;
	}

}
