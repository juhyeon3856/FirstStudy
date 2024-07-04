package addressBookException;

import java.util.Scanner;

public class SmartPhoneMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SmartPhone phone = new SmartPhone();
		
		
		while(true) {
			try {
				printMenu();			
				String num = in.nextLine();
				if (num.contentEquals("1")) {
					phone.addAddr(phone.inputAddData());
				} else if (num.contentEquals("2")) {
					phone.printAllAddr();
				} else if (num.contentEquals("3")) {
					System.out.print("검색할 이름 : ");
					phone.printContact(in.nextLine());
				} else if (num.contentEquals("4")) {
					System.out.print("검색할 이름 : ");
					phone.searchAddr(in.nextLine());
				} else if (num.contentEquals("5")) {
					System.out.print("삭제할 이름 : ");
					phone.deleteAddr(in.nextLine());
				} else if (num.contentEquals("6")) {
					System.out.print("수정할 이름 : ");
					phone.editAddr(in.nextLine(), phone.inputAddData());
				} else if (num.contentEquals("7")) {
					break;
				} else {
					throw new InputException("다시 입력 바랍니다.");
				}
			} catch (InputException e) {
				System.out.println(e.getMessage());
			}
			
		}
		in.close();
	}
	
	
	
	

	public static void printMenu() {
		System.out.println("--------------------------------------");
		System.out.println("    [주소 관리 메뉴]");
		System.out.println(">>> 1. 연락처 등록");
		System.out.println(">>> 2. 모든 연락처 출력");
		System.out.println(">>> 3. 전화번호 검색");		
		System.out.println(">>> 4. 연락처 모든 정보 검색");
		System.out.println(">>> 5. 연락처 삭제");
		System.out.println(">>> 6. 연락처 수정");
		System.out.println(">>> 7. 프로그램 종료");
	}
	
	
	
}