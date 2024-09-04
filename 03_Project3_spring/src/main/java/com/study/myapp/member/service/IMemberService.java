package com.study.myapp.member.service;

import com.study.myapp.member.model.MemberVO;

public interface IMemberService {

	public void deleteMember(String memberId);	
//	public String getName(String id);	
//	public String getPw(String id);	
	public void insertMember(MemberVO member);
	public void updateMember(MemberVO member);
//	public MemberVO confirmId(String memberId);	
	public String userCheck(String memberId);	
	public String searchID(String memberName, String memberPhoneNum);	
	public String searchPW(String memberId, String memberName, String memberPhoneNum);	
	public MemberVO getMember(String memberId);	
}
