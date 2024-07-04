package addressBookException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SmartPhone {
	Scanner in = new Scanner(System.in);
	private Addr[] members = new Addr[10];
	private int nullIndex = 0;
	
	public SmartPhone() {
	}
	
	public Addr[] getMembers() {
		return members;
	}	
	
	//키보드로부터 입력 받아 객체를 생성함
	public Addr inputAddData() throws InputException{
		Addr addr = new Addr(checkName("이름 : "), checkPhoneNum("전화번호 : "), checkGap("이메일 : "), checkGap("주소 : "), checkGap("그룹(친구/가족/회사/거래처) : "));
		if (addr.getGroup().equals("회사")) {
			return new CompanyAddr(addr.getName(), addr.getPhoneNum(), addr.getEmail(), addr.getAddr(), addr.getGroup(), checkGap("회사이름 : "), checkGap("부서이름 : "), checkGap("직급 : "));
		} else if (addr.getGroup().equals("거래처")) {
			return new CompanyAddr(addr.getName(), addr.getPhoneNum(), addr.getEmail(), addr.getAddr(), addr.getGroup(), checkGap("거래처 이름 : "), checkGap("거래품목 : "), checkGap("직급 : "));
		} else {
			return addr;
		}
	}	
	
	//전화번호 같은 데이터 있는지 확인 (같은거 있으면 true)
	public String checkPhoneNum(String str) throws InputException{
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		System.out.print(str);
		String input = in.nextLine();
		if (!Pattern.matches(regExp, input)) {
			throw new InputException("전화번호 형식이 다릅니다.");
		}		
		for (int i = 0; i < nullIndex; i++) {
			if (members[i].getPhoneNum().equals(input)) {
				throw new InputException("이미 전화번호가 존재합니다. ");
			}
		}
		return input;
	}
	
	

	//입력값에 공백 있으면 다시 받기
	public String checkName(String str) throws InputException{
		String input = checkGap(str);
		String regExp = "[ 가-힣 | A-Z | a-z]+";
		if (!Pattern.matches(regExp, input)) {
			throw new InputException("영문자와 한글만 허용합니다.");
		}	
		return input;
	}
	
	
	//입력값에 공백 있으면 다시 받기
	public String checkGap(String str) throws InputException{
		System.out.print(str);
		String input = in.nextLine();
		String[] tokenString = input.split(" ");
		if (input.charAt(0) == ' ' | input.charAt(input.length()-1) == ' ' | tokenString.length != 1) {
			throw new InputException("공백을 입력하였습니다. ");
		}
		return input;
		
	}
	
	//배열에 연락처 객채 저장
	public void addAddr(Addr addr) {
		members[nullIndex] = addr;
		System.out.println(">>> 데이터가 저장되었습니다.("+ ++nullIndex +")");
	}

	//모든 연락처 출력
	public void printAllAddr() {
		for (int i = 0; i < nullIndex;i++) {
			members[i].printAddr();
		}
	}
	
	// 모든 연락처 이름, 전화번호 출력
//	public void printContact1() {
//		for (int i = 0; i < nullIndex; i++) {
//			members[i].showData();
//		}
//	}
	
	//이름 들어있는 인덱스 찾기
	public int searchIdx(String name) throws InputException {
		for (int i = 0; i < nullIndex; i++) {
			if (members[i].getName().equals(name)) {
				return i;
			}
		}
		throw new InputException("없는 이름입니다.");
	}
	
	//이름 받아서 해당 전화번호 및 이름 출력
	public void printContact(String name) throws InputException {
		int idx = searchIdx(name);
		members[idx].showData();
	}
	
	//연락처 검색
	public void searchAddr(String name) throws InputException {
		members[searchIdx(name)].printAddr();
	}	
	
	//연락처 삭제
	public void deleteAddr(String name) throws InputException {
		for (int i = searchIdx(name); i < nullIndex-1; i++) {
			members[i] = members[i+1];
		}
		members[--nullIndex] = null;
	}
	
	//연락처 수정
	public void editAddr(String name, Addr addr) throws InputException {
		members[searchIdx(name)] = addr;
	}
	
}

		
		
		
		
		
		
		
		
		
		
		
		