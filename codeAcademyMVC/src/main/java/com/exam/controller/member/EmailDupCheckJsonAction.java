package com.exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.MemberDao;

public class EmailDupCheckJsonAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("EmailDupCheckJsonAction");
		
		String email = request.getParameter("email");

		MemberDao memberDao = MemberDao.getInstance();

		boolean isEmailDup = memberDao.isEmailDuplicated(email);
		
		System.out.println(isEmailDup);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(isEmailDup);
		
		return null;
	}

}
