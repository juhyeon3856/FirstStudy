package addressBook;
//package Java03_array;
//
//import java.util.Scanner;
//
//
//public class SmartPhoneMain111111 {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		SmartPhone11111[] members = new SmartPhone11111[10];
//		members[0] = new SmartPhone11111();
//		members = members[0].inputAddData(members);
//		
//		
//		while(true) {
//			printMenu();			
//			int num = in.nextInt();
//			Scanner in2 = new Scanner(System.in);
//			if (num == 1) {
//				members[0].addAddr(members);
//			} else if (num == 2) {
//				members[0].printAllAddr(members);
//			} else if (num == 3) {
//				System.out.println("�˻��� �̸� : ");
//				String searchName = in2.nextLine();
//				members[0].searchAddr(members, searchName);
//			} else if (num == 4) {
//				System.out.println("������ �̸� : ");
//				String delName = in2.nextLine();
//				members[0].deleteAddr(members, delName);
//			} else if (num == 5) {
//				System.out.println("������ �̸� : ");
//				String editName = in2.nextLine();
//				members[0].editAddr(members, editName);
//			} else if (num == 6) {
//				break;
//			} else {
//				System.out.println("�߸��Է��Ͽ����ϴ�.");
//			}
//			
//						
//		}
//	}
//	
//	
//	public static void printMenu() {
//		System.out.println("�ּҰ����޴�-----------------");
//		System.out.println(">>> 1. ����ó ���");
//		System.out.println(">>> 2. ��� ����ó ���");
//		System.out.println(">>> 3. ����ó �˻�");
//		System.out.println(">>> 4. ����ó ����");
//		System.out.println(">>> 5. ����ó ����");
//		System.out.println(">>> 6. ���α׷� ����");
//		System.out.println("-----------------------------");
//	}
//}
//
//
//
//
//
