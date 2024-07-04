
package AddrTreeMap;
//addr에도 이름이 있고 addrs의 key도 이름이니까 중복되지 않게 addr에 이름 없에는 방법 찾아보기
//방법1 : inputContactData에서 리턴을 array[2]로 {이름, addr로 한다} -> 굳이? 메모리 잡아먹는건 비슷할듯

import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SmartPhone smartPhone = new SmartPhone();
		
		while (true) {
			printMenu();
			String selectMenu = scanner.nextLine();

			switch (selectMenu) {
			case "1":
				smartPhone.addAddr((smartPhone.inputContactData()));
				break;

			case "2":
				smartPhone.printAllAddr();
				break;

			case "3":
				System.out.println("연락처에 검색할 이름을 입력해주세요.");
				smartPhone.searchAddr(scanner.nextLine());
				break;

			case "4":
				System.out.println("연락처에서 삭제할 이름을 입력해주세요.");
				if(smartPhone.deleteAddr(scanner.nextLine())) {
					System.out.println("삭제되었습니다.");
				}
				break;

			case "5":
				System.out.println("연락처에서 수정할 이름을 입력해주세요.");
				String name = scanner.nextLine();
				if (smartPhone.searchAddr(name)) {
					System.out.println("데이터를 새로 입력해주세요.");
					smartPhone.editAddr(name, smartPhone.inputContactData());
				}				
				break;

			case "6":
				System.out.println("프로그램을 종료합니다.");
				return; // System.exit(0);

			default:
				System.out.println("잘못된 메뉴 입니다. 다시 선택해주세요.");
				break;
			}
		}
	}

	public static void printMenu() {
		System.out.println("주소관리 메뉴-------------");
		System.out.println(">> 1. 연락처 등록");
		System.out.println(">> 2. 모든 연락처 출력");
		System.out.println(">> 3. 연락처 검색");
		System.out.println(">> 4. 연락처 삭제");
		System.out.println(">> 5. 연락처 수정");
		System.out.println(">> 6. 프로그램 종료");
		System.out.println("-----------------------");
	}
}