package AddrTreeMap;

import java.util.Scanner;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;



public class SmartPhone {

	TreeMap<String, Addr> addrs;
	Scanner in;
	
	public SmartPhone() {
		addrs = new TreeMap<String, Addr>();
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
		addrs.put(addr.getName(), addr);
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
		Set<String> keyAddrs = addrs.keySet();
		Iterator<String> addrIterator = keyAddrs.iterator();
		while(addrIterator.hasNext()) {
			printAddr(addrs.get(addrIterator.next()));
		}
	}

	public boolean searchAddr(String name) {
		if (addrs.containsKey(name)) {
			printAddr(addrs.get(name));
			return true;
		} else {
			System.out.println("해당 이름이 없습니다.");
			return false;
		}
	}
	
	public boolean deleteAddr(String name) {
		if (addrs.containsKey(name)) {
			addrs.remove(name);
			return true;
		} else {
			System.out.println("해당 이름이 없습니다.");
			return false;
		}
	}

	public void editAddr(String name, Addr newContact) {
		if(deleteAddr(name)) {
			addrs.put(newContact.getName(), newContact);
		}
	}
}




