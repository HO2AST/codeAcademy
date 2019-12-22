package com.exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.MemberDao;
import com.exam.vo.MemberVO;

public class MemberUpdateAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdateAction");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(request.getParameter("id"));
		memberVO.setGender(request.getParameter("gender"));
		memberVO.setTel(request.getParameter("tel"));
		memberVO.setEmail(request.getParameter("email"));
		memberVO.setPasswd(request.getParameter("passwd"));

		MemberDao memberDao = MemberDao.getInstance();

		int result = memberDao.updateMember(memberVO);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (result == 1) {
			out.append("<script>");
			out.append("alert('수정이 완료되었습니다.');");
			out.append("location.href='main.do';");
			out.append("</script>");
			out.close();
			
			return null;
		} else {
			out.append("<script>");
			out.append("alert('비밀번호가 다릅니다.');");
			out.append("history.back();");
			out.append("</script>");
			out.close();
			
			return null;
		}
	}

}
