package addressBookInterface;

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
		Addr addr = new Addr(checkGap("이름 : "), searchPhoneNum("전화번호 : "), checkGap("이메일 : "), checkGap("주소 : "), checkGap("그룹(친구/가족/회사/거래처) : "));
		if (addr.getGroup().equals("회사")) {
			return new CompanyAddr(addr.getName(), addr.getPhoneNum(), addr.getEmail(), addr.getAddr(), addr.getGroup(), checkGap("회사이름 : "), checkGap("부서이름 : "), checkGap("직급 : "));
		} else if (addr.getGroup().equals("거래처")) {
			return new CompanyAddr(addr.getName(), addr.getPhoneNum(), addr.getEmail(), addr.getAddr(), addr.getGroup(), checkGap("거래처 이름 : "), checkGap("거래품목 : "), checkGap("직급 : "));
		} else {
			return addr;
		}
			
		
	}	
	
	//전화번호 같은 데이터 있는지 확인 (같은거 있으면 true)
	public String searchPhoneNum(String str) {
		System.out.print(str);
		String input = in.nextLine();
		String[] tokenString = input.split(" ");
		while(tokenString.length != 1) {
			System.out.println("다시 입력바랍니다. ");
			input = in.nextLine();
			tokenString = input.split(" ");
		}
		boolean stop = false;
		while(!stop) {
			
			stop = true;
			for (int i = 0; i < nullIndex; i++) {
				if (members[i].getPhoneNum().equals(input)) {
					System.out.println("다시 입력바랍니다. ");
					input = in.nextLine();
					stop = false;
					break;
				}
			}
		}
		return input;
		
		
	}
	
	//입력값에 공백 있으면 다시 받기
	public String checkGap(String str) {
		System.out.print(str);
		String input = in.nextLine();
		String[] tokenString = input.split(" ");
		while(tokenString.length != 1) {
			System.out.println("다시 입력바랍니다. ");
			input = in.nextLine();
			tokenString = input.split(" ");
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
	public void printContact1() {
		for (int i = 0; i < nullIndex; i++) {
			members[i].showData();
		}
	}
	
	//이름 받아서 해당 전화번호 및 이름 출력
	public void printContact(String name) {
		int idx = searchIdx(name);
		members[idx].showData();
	}
	
	//이름 들어있는 인덱스 찾기
	public int searchIdx(String name) {
		for (int i = 0; i < nullIndex; i++) {
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

		
		
		
		
		
		
		
		
		
		
		
		