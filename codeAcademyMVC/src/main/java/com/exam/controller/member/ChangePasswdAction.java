package com.exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.MemberDao;
import com.exam.vo.MemberVO;

public class ChangePasswdAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ChangePasswdAction");
		
		MemberVO memberVO = new MemberVO();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		memberVO.setId(id);
		memberVO.setPasswd(request.getParameter("passwd"));
		
		MemberDao memberDao = MemberDao.getInstance();

		memberDao.changePasswd(memberVO);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('비밀번호 변경이 완료되었습니다.');");
		out.println("location.href='main.do';");
		out.println("</script>");
		
		return null;
	}

}
