package addressBookinheritance;

public class CustomerAddr extends Addr{
	

	private String accountName;
	private String item;
	private String level;
	
	public CustomerAddr(String name, String phoneNum, String email, String addr, String group, String accountName, String item, String level) {
		super(name, phoneNum, email, addr, group);
		this.accountName = accountName;
		this.item = item;
		this.level = level;
	}
		
	
	
	//객체 정보 출력
	@Override
	public void printAddr() {
		System.out.println("--------------------------------------");
		System.out.println("이름 : " + super.getName());
		System.out.println("전화번호 : " + super.getPhoneNum());
		System.out.println("이메일 : " + super.getEmail());
		System.out.println("주소 : " + super.getAddr());
		System.out.println("그룹(친구/가족) : " + super.getGroup());
		System.out.println("거래처 이름 : " + accountName);
		System.out.println("거래품목 : " + item);
		System.out.println("직급 : " + level);		
		System.out.println("--------------------------------------");
	}	

}
