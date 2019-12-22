package com.exam.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;

public class MailAuthJsonAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MailAuthJson");
		
		String email = request.getParameter("email");

		System.out.print(email);

		int n1 = (int)(Math.random() * 9 + 1);
		int n2 = (int)(Math.random() * 9 + 1);
		int n3 = (int)(Math.random() * 9 + 1);
		int n4 = (int)(Math.random() * 9 + 1);
		int n5 = (int)(Math.random() * 9 + 1);
		int n6 = (int)(Math.random() * 9 + 1);

		String authNum = n1+""+n2+""+n3+""+n4+""+n5+""+n6;
		System.out.print(authNum);
		
		HttpSession session = request.getSession();
		session.setAttribute("authNum", authNum);

		// SimpleEmail 객체 생성
		SimpleEmail emails = new SimpleEmail();
		// SMTP 서버 연결 설정
		emails.setHostName("smtp.gmail.com");
		emails.setSmtpPort(465);
		//email.setSslSmtpPort("465");
		emails.setAuthentication("donghotest7", "qyzcratbbebxzwme");

		// SMTP SSL, TLS 설정
		emails.setSSLOnConnect(true);
		emails.setStartTLSEnabled(true);

		String result = "fail";

		try {
			// 보내는 사람 설정
			emails.setFrom("donghotest7@gmail.com", "CodeAcademy", "utf-8");
			
			// 받는 사람 설정
			emails.addTo(email, "utf-8");
			
			// 제목설정
			emails.setSubject("안녕하세요. CodeAcademy입니다.");
			
			// 본문설정
			emails.setMsg("안녕하세요.\nCodeAcademy입니다.\n인증번호는 " + authNum + " 입니다.\n인증번호를 입력해주세요.");
			
			// 메일전송
			result = emails.send();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("result : " + result);
		
		return null;
	}

}
