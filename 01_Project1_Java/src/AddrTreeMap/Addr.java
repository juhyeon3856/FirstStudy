package AddrTreeMap;


public class Addr {
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String group;

	public Addr(String name, String phoneNumber, String eMail, String address, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = eMail;
		this.address = address;
		this.group = group;
	}

	public void printInfo() {
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phoneNumber);
		System.out.println("이메일:" + email);
		System.out.println("주소:" + address);
		System.out.println("그룹:" + group);
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPhoneNumber() { return phoneNumber; }

	public void setPhoneNumber(String phoneNum) { this.phoneNumber = phoneNum; }

	public String getEMail() { return email; }

	public void setEMail(String email) { this.email = email; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }

	public String getGroup() { return group; }

	public void setGroup(String group) { this.group = group; }
}