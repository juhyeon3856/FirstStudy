package com.study.myapp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myapp.member.dao.IMemberRepository;
import com.study.myapp.member.model.MemberVO;


@Service
public class MemberService implements IMemberService{

	@Autowired
	IMemberRepository memberRepository;
	
	public void deleteMember(String memberId) {
		memberRepository.deleteMember(memberId);
	}
	
//	public String getName(String id) {
//		memberDTO = getMember(id);
//		return memberDTO.getName();
//	}
//	
//	public String getPw(String id) {
//		memberDTO = getMember(id);
//		return memberDTO.getPw();
//	}
	
	public void insertMember(MemberVO member) {
		memberRepository.insertMember(member);
	}
	
	public void updateMember(MemberVO member) {
		memberRepository.updateMember(member);
	}
	
//	public MemberVO confirmId(String memberId) {
//		return memberRepository.confirmId(memberId);
//	}
	
	public String userCheck(String memberId) {
		return memberRepository.userCheck(memberId);
	}
	
	public String searchID(String memberName, String memberPhoneNum) {
		return memberRepository.searchID(memberName, memberPhoneNum);
	}
	
	public String searchPW(String memberId, String memberName, String memberPhoneNum) {
		return memberRepository.searchPW(memberId, memberName, memberPhoneNum);
	}
	
	public MemberVO getMember(String memberId) {
		return memberRepository.getMember(memberId);
	}
	
}
