package com.exam.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.MemberDao;
import com.exam.vo.MemberVO;

public class MemberUpdateFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdateFormAction");
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		MemberDao memberDao = MemberDao.getInstance();
		
		MemberVO memberVO = memberDao.getMember(id);
		
		request.setAttribute("member", memberVO);
		request.setAttribute("id", id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("member/infoUpdate");
		forward.setRedirect(false);
		return forward;
	}

}
