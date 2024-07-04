package AddrHasgMap;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;



public class SmartPhone {

	Map<String, Addr> addrs;
	Scanner in;
	
	public SmartPhone() {
		addrs = new HashMap<String, Addr>();
		in = new Scanner(System.in);
	}

	public String inputName() {
		System.out.print("이름 :");
		String name = in.nextLine();
		return name;
	}
	
	public Addr inputContactData() {
		System.out.print("전화번호:");
		String phoneNumber = in.nextLine();
		System.out.print("이메일 :");
		String email = in.nextLine();
		System.out.print("주소 :");
		String address = in.nextLine();
		System.out.print("그룹(친구/가족) :");
		String group = in.nextLine();
		return new Addr(phoneNumber, email, address, group);
	}

	public void addAddr() {
		addrs.put(inputName(), inputContactData());
		System.out.println(">>> 데이터가 저장되었습니다.(" + addrs.size() + ")");
	}

	public void printAddr(String name, Addr addr) {
		System.out.println("이름 :" + name);
		System.out.println("전화번호:" + addr.getPhoneNumber());
		System.out.println("이메일 :" + addr.getEMail());
		System.out.println("주소 :" + addr.getAddress());
		System.out.println("그룹(친구/가족) :" + addr.getGroup());
		System.out.println("==================================");
	}

	public void printAllAddr() {
		Set<Entry<String, Addr>> entrySet = addrs.entrySet();
		Iterator<Entry<String, Addr>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Entry<String, Addr> entry = entryIterator.next();
			printAddr(entry.getKey(), entry.getValue());
		}
	}

	public boolean searchAddr(String name) {
		if (addrs.containsKey(name)) {
			printAddr(name, addrs.get(name));
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

	public void editAddr() {
		addrs.put(inputName(), inputContactData());
	}
}




