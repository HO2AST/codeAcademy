package com.exam.controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;

public class LectureMainFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureMainFormAction");
		
		ActionForward forward = new ActionForward();
		forward.setPath("lecture/lectureMain");
		forward.setRedirect(false);
		return forward;
	}

}
