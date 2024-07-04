package addressBook;

public class Addr {
	private String name;
	private String phoneNum;
	private String email;
	private String addr;
	private String group;
	
	public Addr(String name, String phoneNum, String email, String addr, String group) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.addr = addr;
		this.group = group;
	}
	
	//�� ��������
	public String getName() {
		return name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public String getAddr() {
		return addr;
	}
	public String getGroup() {
		return group;
	}
	
	//�� �����ϱ�
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setEmail
	(String email) {
		this.email = email;	
	}
	public void setAddr(String addr) {
		this.addr = addr;	
	}
	public void setGroup(String group) {
		this.group = group;
	}


	//객체 정보 출력
	public void printAddr() {
		System.out.println("--------------------------------------");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNum);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + addr);
		System.out.println("그룹(친구/가족) : " + group);
//		System.out.println("--------------------------------------");
	}	
	
}
