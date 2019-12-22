package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import com.exam.controller.admin.AdminCategoryStatisticsAction;
import com.exam.controller.admin.AdminCategoryStatisticsFormAction;
import com.exam.controller.admin.AdminContentDeleteAction;
import com.exam.controller.admin.AdminContentFormAction;
import com.exam.controller.admin.AdminGenderStatisticsAction;
import com.exam.controller.admin.AdminGenderStatisticsFormAction;
import com.exam.controller.admin.AdminMemberDeleteAction;
import com.exam.controller.admin.AdminWholeBoardFormAction;
import com.exam.controller.admin.AdminWholeMemberFormAction;
import com.exam.controller.community.BoardAction;
import com.exam.controller.community.CommunityContentAction;
import com.exam.controller.community.CommunityDeleteAction;
import com.exam.controller.community.CommunityRewriteAction;
import com.exam.controller.community.CommunityRewriteFormAction;
import com.exam.controller.community.CommunityUpdateAction;
import com.exam.controller.community.CommunityUpdateFormAction;
import com.exam.controller.community.CommunityWriteAction;
import com.exam.controller.community.CommunityWriteFormAction;
import com.exam.controller.community.DownloadAction;
import com.exam.controller.community.QnaAction;
import com.exam.controller.lecture.LectureMainFormAction;
import com.exam.controller.member.ChangePasswdAction;
import com.exam.controller.member.ChangePasswdFormAction;
import com.exam.controller.member.CheckPasswdAction;
import com.exam.controller.member.CheckPasswdFormAction;
import com.exam.controller.member.EmailAuthFormAciton;
import com.exam.controller.member.EmailDupCheckJsonAction;
import com.exam.controller.member.JoinIdDupCheckJsonAction;
import com.exam.controller.member.MailAuthJsonAction;
import com.exam.controller.member.MainAction;
import com.exam.controller.member.MemberJoinAction;
import com.exam.controller.member.MemberJoinFormAction;
import com.exam.controller.member.MemberLoginAction;
import com.exam.controller.member.MemberLoginFormAction;
import com.exam.controller.member.MemberLogoutAction;
import com.exam.controller.member.MemberUpdateAction;
import com.exam.controller.member.MemberUpdateFormAction;

public class ActionFactory {
	private Map<String, Action> map = new HashMap<String, Action>();
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	} // 싱글톤
	
	private ActionFactory() {
		// main
		map.put("/main.do", new MainAction());
		// Member
		map.put("/memberJoinForm.do", new MemberJoinFormAction());
		map.put("/memberJoin.do", new MemberJoinAction());
		map.put("/memberLoginForm.do", new MemberLoginFormAction());
		map.put("/memberLogin.do", new MemberLoginAction());
		map.put("/memberLogout.do", new MemberLogoutAction());
		map.put("/joinIdDupCheckJson.do", new JoinIdDupCheckJsonAction());
		map.put("/emailDupCheckJson.do", new EmailDupCheckJsonAction());
		map.put("/mailAuthJson.do", new MailAuthJsonAction());
		map.put("/mailAuth.do", new EmailAuthFormAciton());
		map.put("/memberInfoUpdateForm.do", new MemberUpdateFormAction());
		map.put("/memberInfoUpdate.do", new MemberUpdateAction());
		map.put("/checkPasswdForm.do", new CheckPasswdFormAction());
		map.put("/checkPasswd.do", new CheckPasswdAction());
		map.put("/changePasswdForm.do", new ChangePasswdFormAction());
		map.put("/changePasswd.do", new ChangePasswdAction());
		
		// Lecture
		map.put("/lectureMainForm.do", new LectureMainFormAction());
		
		//community
		map.put("/boardForm.do", new BoardAction());
		map.put("/qnaForm.do", new QnaAction());
		map.put("/downloadForm.do", new DownloadAction());
		map.put("/communityWriteForm.do", new CommunityWriteFormAction());
		map.put("/communityWrite.do", new CommunityWriteAction());
		map.put("/communityContent.do", new CommunityContentAction());
		map.put("/communityDelete.do", new CommunityDeleteAction());
		map.put("/communityRewriteForm.do", new CommunityRewriteFormAction());
		map.put("/communityRewrite.do", new CommunityRewriteAction());
		map.put("/communityUpdateForm.do", new CommunityUpdateFormAction());
		map.put("/communityUpdate.do", new CommunityUpdateAction());
		
		// admin
		map.put("/adminWholeBoardForm.do", new AdminWholeBoardFormAction());
		map.put("/adminContentForm.do", new AdminContentFormAction());
		map.put("/adminContentDelete.do", new AdminContentDeleteAction());
		map.put("/adminBoardStatisticsForm.do", new AdminCategoryStatisticsFormAction());
		map.put("/adminBoardStatistics.do", new AdminCategoryStatisticsAction());
		map.put("/adminWholeMemberForm.do", new AdminWholeMemberFormAction());
		map.put("/adminMemberDelete.do", new AdminMemberDeleteAction());
		map.put("/adminMemberStatisticsForm.do", new AdminGenderStatisticsFormAction());
		map.put("/adminMemberStatistics.do", new AdminGenderStatisticsAction());
		
		
	} // 생성자
	
	public Action getAction(String command) {
		Action action = map.get(command);
		return action;
	}
}
