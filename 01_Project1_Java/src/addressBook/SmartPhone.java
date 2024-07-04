package addressBook;

import java.util.Scanner;

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
	public Addr inputAddData(){
		System.out.print("이름 : ");
		String name = in.nextLine();
		System.out.print("전화번호 : ");
		String phoneNum = in.nextLine();
		System.out.print("이메일 : ");
		String email = in.nextLine();
		System.out.print("주소 : ");
		String addr = in.nextLine();
		System.out.print("그룹(친구/가족/회사/거래처) : ");
		String group = in.nextLine();
		switch (group) {
		case "회사":
			System.out.print("회사이름 : ");
			String companyName = in.nextLine();
			System.out.print("부서이름 : ");
			String departmentName = in.nextLine();
			System.out.print("직급 : ");
			String level = in.nextLine();
			return new CompanyAddr(name, phoneNum, email, addr, group, companyName, departmentName, level);
		case "거래처":
			System.out.print("거래처 이름 : ");
			String accountName = in.nextLine();
			System.out.print("거래품목 : ");
			String item = in.nextLine();
			System.out.print("직급 : ");
			String accountLevel = in.nextLine();
			return new CustomerAddr(name, phoneNum, email, addr, group, accountName, item, accountLevel);
		default:
			break;
		}
		return new Addr(name, phoneNum, email, addr, group);
		
	}	
	
	//배열에 연락처 객채 저장
	public void addAddr(Addr addr) {
		members[nullIndex] = addr;
		System.out.println(">>> 데이터가 저장되었습니다.("+ ++nullIndex +")");
	}
//	
//	//객체 정보 출력
//	public void printAddr(Addr addr) {
//		System.out.println("--------------------------------------");
//		System.out.println("이름 : " + addr.getName());
//		System.out.println("전화번호 : " + addr.getPhoneNum());
//		System.out.println("이메일 : " + addr.getEmail());
//		System.out.println("주소 : " + addr.getAddr());
//		System.out.println("그룹(친구/가족) : " + addr.getGroup());
//		System.out.println("--------------------------------------");
//	}	
//	
	//모든 연락처 출력
	public void printAllAddr() {
		for (int i = 0; i < nullIndex;i++) {
			members[i].printAddr();
		}
	}
	
	//이름 들어있는 인덱스 찾기
	public int searchIdx(String name) {
		for (int i = 0; i < members.length; i++) {
			if (members[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	//연락처 검색
	public void searchAddr(String name) {
		if (searchIdx(name) == -1) {
			System.out.println("검색결과 없음");
		} else {
			members[searchIdx(name)].printAddr();
		}		
	}	
	
	//연락처 삭제
	public void deleteAddr(String name) {
		if (searchIdx(name) == -1) {
			System.out.println("검색결과 없음");
		} else {
			for (int i = searchIdx(name); i < nullIndex-1; i++) {
				members[i] = members[i+1];
			}
			members[--nullIndex] = null;
		}	
		
	}
	
	//연락처 수정
	public void editAddr(String name, Addr addr) {
		if (searchIdx(name) == -1) {
			System.out.println("검색결과 없음");
		} else {
			members[searchIdx(name)] = addr;
		}	
	}
}

		
		
		
		
		
		
		
		
		
		
		
		