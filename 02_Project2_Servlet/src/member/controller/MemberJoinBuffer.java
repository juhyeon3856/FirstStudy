package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.service.MemberServiceImpl;



public class MemberJoinBuffer implements Command {
	private MemberService memberService = new MemberServiceImpl();

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("inputId", request.getParameter("id"));
		request.setAttribute("inputName", request.getParameter("name"));
		request.setAttribute("inputPW", request.getParameter("pw"));
		request.setAttribute("inputCfmPW", request.getParameter("cfm-pw"));
		request.setAttribute("inputEmail", request.getParameter("email"));
		request.setAttribute("inputPhone", request.getParameter("phone"));
		request.setAttribute("inputAddr", request.getParameter("address"));
		return "/memberJoin.jsp";
	}
}
