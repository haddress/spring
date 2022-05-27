package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;
import co.micol.prj.comm.Command;
import co.micol.prj.member.command.AjaxIdCheck;
import co.micol.prj.member.command.MemberInsertForm;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;
import co.micol.prj.member.command.MemberSelectList;
import co.micol.prj.product.command.ProductInsert;
import co.micol.prj.product.command.ProductInsertForm;
import co.micol.prj.product.command.ProductList;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>(); 

    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); //처음 페이지 호출
		
		map.put("/memberSelectList.do", new MemberSelectList());  //멤버목록
		map.put("/memberLoginForm.do", new MemberLoginForm());  //멤버로그인 폼
		map.put("/memberLogin.do", new MemberLogin()); //멤버로그인 처리
		map.put("/memberLogout.do", new MemberLogout()); //로그아웃
		map.put("/memberInsertForm.do", new MemberInsertForm()); //회원가입 폼
		map.put("/ajaxIdCheck.do", new AjaxIdCheck());  //아이디 중복체크 ajax 처리
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 처리
		
		map.put("/productList.do", new ProductList()); //제품 목록
		map.put("/productInsertForm.do", new ProductInsertForm()); //제품등록 폼
		map.put("/productInsert.do", new ProductInsert()); //제품등록 처리
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 분석
		request.setCharacterEncoding("utf-8"); //한글처리
		String uri = request.getRequestURI();  //요청 uri 
		String contextPath = request.getContextPath(); //루트(컨텍스트패스) 확인
		String page = uri.substring(contextPath.length()); //실제요청을 확인
		
		Command command = map.get(page);  //요청을 호출
		String viewPage = command.exec(request, response);  //처리 후 돌려줄 결과 페이지
		
		if(viewPage.startsWith("ajax:")) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(viewPage.substring(5));
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);  //dispatcher 처리
		dispatcher.forward(request, response);
	}

}
