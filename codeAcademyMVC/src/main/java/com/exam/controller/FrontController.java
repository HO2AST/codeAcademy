package com.exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		// *프론트 컨트롤러 역할 및 수행단계
		// 1) 요청정보(명령어 추출)
		// http://localhost:88/codemvc/MemberJoin.do
		String requestURI = request.getRequestURI();
		System.out.println("요청 URI주소: " + requestURI);
		// 요청 URI 주소: /codemvc/MemberJoin.do
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		// contextPath: /codemvc
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command: " + command);
		// command: MemberJoin.do
		
		Action action = null;
		ActionForward forward = null;
		ActionFactory factory = ActionFactory.getInstance();
		
		action = factory.getAction(command);
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3) 화면정보를 가진 뷰 (JSP)를 선택해서 실행
		// URL주소 (sendRedirect 방식 이동 "*.do" 명령어로 재요청) -> FrontController로 다시 왔다가 실행됨
		// 또는 jsp 파일명 (바로 실행 시켜야 할때 jsp 파일명으로 실행 -> dispatch 방식이동)
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				String path = "WEB-INF/views/" + forward.getPath() + ".jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}
		}
	} // doGet method
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	} // doPost method

}
