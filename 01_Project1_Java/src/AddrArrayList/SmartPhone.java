package AddrArrayList;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class SmartPhone {

	List<Addr> addrs;
	Scanner in;
	
	public SmartPhone() {
		addrs = new LinkedList<Addr>();
		in = new Scanner(System.in);
	}

	public Addr inputContactData() {
		System.out.print("이름 :");
		String name = in.nextLine();
		System.out.print("전화번호:");
		String phoneNumber = in.nextLine();
		System.out.print("이메일 :");
		String email = in.nextLine();
		System.out.print("주소 :");
		String address = in.nextLine();
		System.out.print("그룹(친구/가족) :");
		String group = in.nextLine();

		return new Addr(name, phoneNumber, email, address, group);
	}

	public void addAddr(Addr addr) {
		addrs.add(addr);
		System.out.println(">>> 데이터가 저장되었습니다.(" + addrs.size() + ")");
	}

	public void printAddr(Addr addr) {
		System.out.println("이름 :" + addr.getName());
		System.out.println("전화번호:" + addr.getPhoneNumber());
		System.out.println("이메일 :" + addr.getEMail());
		System.out.println("주소 :" + addr.getAddress());
		System.out.println("그룹(친구/가족) :" + addr.getGroup());
		System.out.println("==================================");
	}

	public void printAllAddr() {
		Iterator<Addr> addrIterator = addrs.iterator();
		while(addrIterator.hasNext()) {
			printAddr(addrIterator.next());
		}
	}

	public boolean searchAddr(String name) {
		Iterator<Addr> addrIterator = addrs.iterator();
		while(addrIterator.hasNext()) {
			Addr addr = addrIterator.next();
			if (addr.getName().equals(name)) {
				printAddr(addr);
				return true;
			}
		}
		System.out.println("검색 결과가 없습니다.");
		return false;
	}
	
	public boolean deleteAddr(String name) {
		Iterator<Addr> addrIterator = addrs.iterator();
		while(addrIterator.hasNext()) {
			Addr addr = addrIterator.next();
			if (addr.getName().equals(name)) {
				addrIterator.remove();
				return true;
			}
		}
		System.out.println("해당 이름이 없습니다.");
		return false;
	}

	public void editAddr(String name, Addr newContact) {
		if(deleteAddr(name)) {
			addrs.add(newContact);
		}
	}
}




