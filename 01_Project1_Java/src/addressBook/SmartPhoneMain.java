package addressBook;

import java.util.Scanner;

public class SmartPhoneMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SmartPhone phone = new SmartPhone();
		
		phone.addAddr(phone.inputAddData());
		phone.addAddr(phone.inputAddData());
		
		while(true) {
			printMenu();			
			int num = in.nextInt();
			if (num == 1) {
				phone.addAddr(phone.inputAddData());
			} else if (num == 2) {
				phone.printAllAddr();
			} else if (num == 3) {
				System.out.println("검색할 이름 : ");
				in.nextLine();
				phone.searchAddr(in.nextLine());
			} else if (num == 4) {
				System.out.println("삭제할 이름 : ");
				in.nextLine();
				phone.deleteAddr(in.nextLine());
			} else if (num == 5) {
				System.out.println("수정할 이름 : ");
				in.nextLine();
				phone.editAddr(in.nextLine(), phone.inputAddData());
			} else if (num == 6) {
				break;
			} else {
				System.out.println("잘못입력하였습니다.");
			}
		}
		in.close();
	}
	
	
	
	

	public static void printMenu() {
		System.out.println("--------------------------------------");
		System.out.println("    [주소 관리 메뉴]");
		System.out.println(">>> 1. 연락처 등록");
		System.out.println(">>> 2. 모든 연락처 출력");
		System.out.println(">>> 3. 연락처 검색");
		System.out.println(">>> 4. 연락처 삭제");
		System.out.println(">>> 5. 연락처 수정");
		System.out.println(">>> 6. 프로그램 종료");
//		System.out.println("--------------------------------------");
	}
	
	
	
}