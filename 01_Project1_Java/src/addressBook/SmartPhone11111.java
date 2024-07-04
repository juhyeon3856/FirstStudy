package addressBook;
//package Java03_array;
//
//import java.util.Scanner;
//
//public class SmartPhone11111 {
//	private String name;
//	private String phoneNum;
//	private String email;
//	private String addr;
//	private String group;
//	
//	public SmartPhone11111() {
//		this("��������", "��������", "��������", "��������", "��������");
//	}
//	
//	public SmartPhone11111(String name, String phoneNum, String email, String addr, String group) {
//		this.name = name;
//		this.phoneNum = phoneNum;
//		this.email = email;
//		this.addr = addr;
//		this.group = group;
//	}
//	
//	//�� ��������
//	public String getName() {
//		return name;
//	}
//	public String getPhoneNum() {
//		return phoneNum;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public String getAddr() {
//		return addr;
//	}
//	public String getGroup() {
//		return group;
//	}
//	//�� �����ϱ�
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setPhoneNum(String phoneNum) {
//		this.phoneNum = phoneNum;
//	}
//	public void setEmail
//	(String email) {
//		this.email = email;	
//	}
//	public void setAddr(String addr) {
//		this.addr = addr;	
//	}
//	public void setGroup(String group) {
//		this.group = group;
//	}
//
//
//	//Ű����κ��� �Է� �޾� ��ü�� ������ inputAddData()
//	public SmartPhone11111[] inputAddData(SmartPhone11111[] members){
//		Scanner in = new Scanner(System.in);
//		System.out.print("�̸� : ");
//		String name = in.nextLine();
//		System.out.print("��ȭ��ȣ : ");
//		String phoneNum = in.nextLine();
//		System.out.print("�̸��� : ");
//		String email = in.nextLine();
//		System.out.print("�ּ� : ");
//		String addr = in.nextLine();
//		System.out.print("�׷�(ģ��/����) : ");
//		String group = in.nextLine();
//		members[0] = new SmartPhone11111(name, phoneNum, email, addr, group);
//		System.out.println(">>> �����Ͱ� ����Ǿ����ϴ�.(1)");
//		
//		System.out.print("�̸� : ");
//		String name1 = in.nextLine();
//		System.out.print("��ȭ��ȣ : ");
//		String phoneNum1 = in.nextLine();
//		System.out.print("�̸��� : ");
//		String email1 = in.nextLine();
//		System.out.print("�ּ� : ");
//		String addr1 = in.nextLine();
//		System.out.print("�׷�(ģ��/����) : ");
//		String group1 = in.nextLine();
//		members[1] = new SmartPhone11111(name1, phoneNum1, email1, addr1, group1);
//		System.out.println(">>> �����Ͱ� ����Ǿ����ϴ�.(2)");
//		System.out.println();
//		//in.close();
//		return members;
//	}
//	
//	//�迭�� ����ó ��ä ����  addAddr(Addr, Addr)
//	public SmartPhone11111[] addAddr(SmartPhone11111[] members) {
//		Scanner in = new Scanner(System.in);
//		if (members[members.length-1] == null) {
//			for(int i = 0; i < members.length; i++) {
//				if(members[i] == null) {
//					System.out.print("�̸� : ");
//					String name = in.nextLine();
//					System.out.print("��ȭ��ȣ : ");
//					String phoneNum = in.nextLine();
//					System.out.print("�̸��� : ");
//					String email = in.nextLine();
//					System.out.print("�ּ� : ");
//					String addr = in.nextLine();
//					System.out.print("�׷�(ģ��/����) : ");
//					String group = in.nextLine();
//					
//					members[i] = new SmartPhone11111(name, phoneNum, email, addr, group);
//					
//					System.out.print(">>> �����Ͱ� ����Ǿ����ϴ�.(");	
//					System.out.println((i+1) + ")");
//					break;
//				}
//			}
//		} else {
//			// �޸𸮿� �� ������ ������ ������� �ʰ� ������ �迭 ����
//			System.out.println("�޸𸮰� �����մϴ�. ");
//		}
//		//in.close();
//		return members;
//	}
//	
//
//	//��ü ���� ���  printAddr()
//	public void printAddr(SmartPhone11111[] members, int i) {
//		System.out.println("--------------------------------------");
//		System.out.println("�̸� : " + members[i].getName());
//		System.out.println("��ȭ��ȣ : " + members[i].getPhoneNum());
//		System.out.println("�̸��� : " + members[i].getEmail());
//		System.out.println("�ּ� : " + members[i].getAddr());
//		System.out.println("�׷�(ģ��/����) : " + members[i].getGroup());
//		System.out.println("--------------------------------------");
//	}
//	
//	//��� ����ó ���	printAllAddr
//	public void printAllAddr(SmartPhone11111[] members) {
//		for (SmartPhone11111 member : members) {
//			if(member != null) {
//				System.out.println("--------------------------------------");
//				System.out.println("�̸� : " + member.getName());
//				System.out.println("��ȭ��ȣ : " + member.getPhoneNum());
//				System.out.println("�̸��� : " + member.getEmail());
//				System.out.println("�ּ� : " + member.getAddr());
//				System.out.println("�׷�(ģ��/����) : " + member.getGroup());
//				System.out.println("--------------------------------------");
//				System.out.println();
//			} else {
//				break;
//			}
//		}
//	}
//	
//	//����ó �˻�	searchAddr
//	public void searchAddr(SmartPhone11111[] members, String searchName) {
//		int index = 0;
//		for (int i = 0; i < members.length; i++) {
//			if (members[i].getName().equals(searchName)) {
//				index = i;
//				break;
//			}
//		}
//		members[index].printAddr(members, index);
//	}
//	
//	//����ó ����	deleteAddr
//	public SmartPhone11111[] deleteAddr(SmartPhone11111[] members, String delName) {
//		//���� �̸��� �ִ� �ε��� �� ã��
//		int index = 0;
//		for (int i = 0; i < members.length; i++) {
//			if (members[i].getName().equals(delName)) {
//				index = i;
//				break;
//			}
//		}
//		//�����
//		for (int i = index; i < members.length-1; i++) {
//			if(members[i+1] != null) {
//				members[i].setName(members[i+1].name);
//				members[i].setPhoneNum(members[i+1].phoneNum);
//				members[i].setEmail(members[i+1].email);
//				members[i].setAddr(members[i+1].addr);
//				members[i].setGroup(members[i+1].group);
//			} else if(members[i] != null && members[i+1] == null) {
//				members[i] = null;
//			} else {
//				break;
//			}
//		}
//		//System.out.println(index + "��° �޸𸮸� �����Ͽ����ϴ�.");
//		return members;
//	}
//	
//	//����ó ����
//	public SmartPhone11111[] editAddr(SmartPhone11111[] members, String editName) {
//		//���� �̸��� �ִ� �ε��� �� ã��
//		int index = 0;
//		for (int i = 0; i < members.length; i++) {
//			if (members[i].getName().equals(editName)) {
//				index = i;
//				break;
//			}
//		}
//		members[index].printAddr(members, index);
//		System.out.println("�����Ͻ� ��ȣ�� �����ϼ���.");
//		System.out.println("1. �̸�");
//		System.out.println("2. ��ȭ��ȣ");
//		System.out.println("3. �̸���");
//		System.out.println("4. �ּ�");
//		System.out.println("5. �׷�");
//
//		Scanner in = new Scanner(System.in);
//		int editNum = in.nextInt();
//		Scanner in1 = new Scanner(System.in);
//		switch (editNum) {
//		
//		case 1:
//			System.out.println("�����Ͻ� �̸��� �Է��ϼ��� : ");
//			String name = in1.nextLine();
//			members[index].setName(name);
//			break;
//		case 2:
//			System.out.println("�����Ͻ� ��ȭ��ȣ�� �Է��ϼ��� : ");
//			String phoneNum = in1.nextLine();
//			members[index].setPhoneNum(phoneNum);;
//			break;
//		case 3:
//			System.out.println("�����Ͻ� �̸����� �Է��ϼ��� : ");
//			String email = in1.nextLine();
//			members[index].setEmail(email);
//			break;
//		case 4:
//			System.out.println("�����Ͻ� �ּҸ� �Է��ϼ��� : ");
//			String addr = in1.nextLine();
//			members[index].setAddr(addr);
//			break;
//		case 5:
//			System.out.println("�����Ͻ� �׷�(ģ��/����)�� �Է��ϼ��� : ");
//			String group = in1.nextLine();
//			members[index].setGroup(group);
//			break;
//		default:
//			System.out.println("�� �� �Է��Ͽ����ϴ�.");
//			break;
//		}
//		in1.close();
//		return members;
//	}
//}
//
//	
