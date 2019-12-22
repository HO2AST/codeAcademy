package com.exam.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;

public class CheckPasswdFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CheckPasswdFormAction");
		
		ActionForward forward = new ActionForward();
		forward.setPath("member/changePasswd");
		forward.setRedirect(false);
		return forward;
	}

}
