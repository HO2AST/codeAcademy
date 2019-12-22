package com.exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.MemberDao;

public class CheckPasswdAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CheckPasswdAction");

		// 비밀번호 파라미터값 가져오기
		String passwd = request.getParameter("passwd");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		System.out.println(id);
		System.out.println(passwd);

		//Dao 객체 준비
		MemberDao memberDao = MemberDao.getInstance();

		int check = memberDao.userCheck(id, passwd);

		if (check == 1) {
			response.sendRedirect("changePasswd.do");
		} else if (check == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('패스워드가 다릅니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return null;
	}
}
