package com.study.myapp.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.myapp.member.model.MemberVO;
import com.study.myapp.member.service.IMemberService;

@Controller
public class MemberController {
	
	@Autowired
	IMemberService memberService;
	
	@GetMapping("/member/delete")
	public String deleteMember(Model model) {
		//model.addAttribute("member", memberService.getMember(memberId));
		return "member/memberDeleteCheck";
	}
	
	@PostMapping("/member/delete")
	public String deleteMember(String memberId, String memberPw, Model model,  HttpSession session) {
		if(memberPw.equals(memberService.getMember(memberId).getPw())) {
			try {
				memberService.deleteMember(memberId);
			} catch(EmptyResultDataAccessException e) {
				
			}			
			session.invalidate();
			return "redirect:/member/login";
		} else {
			model.addAttribute("check", false);
			return "member/memberDeleteCheck";
		}
	}
	
	@GetMapping("/member/out")
	public String OutMember(String memberId, Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@PostMapping("/member/doubleCheck")
	public String doubleCheckMember(MemberVO member, String cfmPw, Model model) {
		model.addAttribute("member", member);
		model.addAttribute("cfmPw", cfmPw);
		String memberPw = null;
		try {
			memberPw = memberService.userCheck(member.getId());
		} catch(EmptyResultDataAccessException e){
			memberPw = "can";
		}
		model.addAttribute("memberPw", memberPw);
		return "member/memberJoin";
	}
	
	@GetMapping("/member/pwCheck")
	public String pwCheckMember(String memberId, Model model) {
		model.addAttribute("memberId", memberId);
		return "member/memberPWCheck";
	}
	
	@PostMapping("/member/pwCheck")
	public String pwCheckMember(String memberId, String memberPw, Model model) {
		MemberVO member = memberService.getMember(memberId);
		if(memberPw.equals(member.getPw())) {
			model.addAttribute("member", member);
			return "member/memberEdit";
		} else {
			model.addAttribute("check", false);
			return "member/memberPWCheck";
		}
	}
	
	@PostMapping("/member/edit")
	public String editMember(MemberVO member, Model model) {
		model.addAttribute("member", member);
		return "member/memberEdit";
	}
	
	@PostMapping("/member/editOk")
	public String editOkMember(MemberVO member, Model model) {
		memberService.updateMember(member);		
		model.addAttribute("member", member);
		return "member/memberMain";
	}
	
	@GetMapping("/member/join")
	public String joinMember(Model model) {
		return "member/memberJoin";
	}

	@PostMapping("/member/join")
	public String joinMember(MemberVO member, String idDoubleCheck, String cfmPw, Model model) {
		model.addAttribute("member", member);
		model.addAttribute("memberPw", idDoubleCheck);
		model.addAttribute("cfmPw", cfmPw);
		return "member/memberJoin";
	}
	
	@PostMapping("/member/joinOk")
	public String joinOkMember(MemberVO member, Model model) {
		memberService.insertMember(member);
		return "redirect:/member";
	}
	
//	@GetMapping("/" )
//	public String index(Model model) {
//		return "redirect:/html/index.html";
//	}
	
	@GetMapping({"/member/login", "/member"})
	public String loginMember(Model model) {
		return "member/memberLogin";
	}
	
	@PostMapping("/member/loginOK")
	public String loginMember(String memberId, String memberPw, Model model, HttpSession session) {
		MemberVO member = null;
		try {
			member = memberService.getMember(memberId);
		} catch(EmptyResultDataAccessException e){
			member = null;
		}	
		if(member!=null) {
			if(memberPw.equals(member.getPw())) {
				model.addAttribute("check", "ok");
				session.setAttribute("userId", memberId);
				session.setAttribute("isLoggedIn", true);
				model.addAttribute("userName", member.getName());			
				return "member/memberLoginOk";
			} else {
				model.addAttribute("check", "pw");
				return "member/memberLogin";
			}
		} else {
			model.addAttribute("check", "id");
			return "member/memberLogin";
		}
	}
	
	@GetMapping("/member/main")
	public String mainMember(String memberId, Model model) {
		MemberVO member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		return "member/memberMain";
	}
	
//	@PostMapping("/member/searchIDPW")
//	public String searchIDPWMember(String memberName, String memberPhoneNum, Model model) {
//		String memberId = memberService.searchID(memberName, memberPhoneNum);
//		model.addAttribute("아이디는" + memberId + "입니다.");
//		return "member/memberIDPWResult";
//	}
//
//	@PostMapping("/member/searchIDPW")
//	public String searchIDPWMember(String memberId, String memberName, String memberPhoneNum, Model model) {
//		String memberPW = memberService.searchPW(memberId, memberName, memberPhoneNum);
//		model.addAttribute("비밀번호는" + memberPW + "입니다.");
//		return "member/memberIDPWResult";
//	}	
	
	@GetMapping("/member/searchIDPW")
	public String searchIDPWMember(Model model) {
	    return "member/memberSearch";
	}
	
	
	@PostMapping("/member/searchIDPW")
	public String searchIDPWMember(@RequestParam(required = false) String memberId,
	                               @RequestParam(required = false) String memberName,
	                               @RequestParam(required = false) String memberPhoneNum,
	                               Model model) {
	    try {
	    	if (memberId == null) {
	    		// 처리 로직: 아이디 찾기
	    		String memberIdResult = memberService.searchID(memberName, memberPhoneNum);
	    		model.addAttribute("result", "아이디는 " + memberIdResult + "입니다.");
	    	} else {
	    		// 처리 로직: 비밀번호 찾기
	    		String memberPWResult = memberService.searchPW(memberId, memberName, memberPhoneNum);
	    		model.addAttribute("result", "비밀번호는 " + memberPWResult + "입니다.");
	    	}
	    } catch(EmptyResultDataAccessException e){
	    	model.addAttribute("result", "결과가 없습니다.");
	    }	
	    return "member/memberIDPWResult";
	}
	
//	@PostMapping("/member/searchIDPW")
//	public String searchIDPWMember(String formName, String memberId, String memberName, String memberPhoneNum, Model model) {
//		if(formName="id") {
//			String memberId = memberService.searchID(memberName, memberPhoneNum);
//			model.addAttribute("아이디는" + memberId + "입니다.");
//			return "member/memberIDPWResult";
//		} else if(formName="pw") {
//			String memberPW = memberService.searchPW(memberId, memberName, memberPhoneNum);
//			model.addAttribute("비밀번호는" + memberPW + "입니다.");
//			return "member/memberIDPWResult";
//		}
//		
//	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
}
