package com.study.myapp.member.dao;


import com.study.myapp.member.model.MemberVO;

public interface IMemberRepository {
	public void deleteMember(String memberId);	
	public void insertMember(MemberVO member);	
	public void updateMember(MemberVO member);		
	public MemberVO confirmId(String memberId);	
	public String userCheck(String memberId);
	public String searchID(String memberName, String memberPhoneNum);	
	public String searchPW(String memberId, String memberName, String memberPhoneNum);	
	public MemberVO getMember(String memberId);
}
