package com.exam.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;

public class MemberLoginFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginFormAction");
		
		ActionForward forward = new ActionForward();
		forward.setPath("member/login");
		forward.setRedirect(false);
		return forward;
	}

}
