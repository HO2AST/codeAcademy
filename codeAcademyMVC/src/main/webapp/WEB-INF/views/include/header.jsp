<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 쿠키 찾기 --%>
<%
String id = null;

Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies){
		if (cookie.getName().equals("id")) {
			id = cookie.getValue();
			// 세션에 쿠키값을 저장
			session.setAttribute("id", id);
		}
	}
}

%>

<%
// 세션값 가져오기 "id"
id = (String) session.getAttribute("id");

%>
	<header class="fixed_top">

	<div class="member">
				<%
		if (id == null) { // 세션값 없음
			%>
		<div class="login">
			<a href="memberLoginForm.do">로그인</a>
		</div>
		<div class="join">
			<a href="memberJoinForm.do">회원가입</a>
		</div>
			<%
		} else { // id != null 세션값 있음
			if (id.equals("admin")) {
				%>
				<div class="welcome"><%=id %>님 반갑습니다</div>
				<div class="login">
					<a href="memberLogout.do">로그아웃</a>
				</div>
				<div class="join">
					<a href="memberInfoUpdateForm.do">정보수정</a>
				</div>
				<div class="memberControl">
					<a href="adminWholeMemberForm.do">회원관리</a>
				</div>
				<div class="boardControl">
					<a href="adminWholeBoardForm.do">게시글관리</a>
				</div>
				<%
			} else {
				%>
				<div class="welcome"><%=id %>님 반갑습니다</div>
				<div class="login">
					<a href="memberLogout.do">로그아웃</a>
				</div>
				<div class="join">
					<a href="memberInfoUpdateForm.do">정보수정</a>
				</div>
				<%		
			}
		}
		%>
	</div>
	<div id="main_logo">
		<a href="main.do" class="logo">
			<img src="imgs/logo.png" alt="">
		</a>
	</div>
	<div class="nav-wrap">
		<button class="mobile">
		    =
		</button>
		<ul>
		    <li>
		        <a href="lectureMainForm.do">강의</a>
		    </li>
		    <li>
		        <a href="boardForm.do">커뮤니티</a>
		    </li>
<!-- 		    <li> -->
<!-- 		        <a href="../studyclub/findClub.jsp">스터디클럽</a> -->
<!-- 		    </li> -->
		</ul>
	</div>
	</header>