package addressBookInterface;

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
		super.printAddr();
		System.out.println("거래처 이름 : " + accountName);
		System.out.println("거래품목 : " + item);
		System.out.println("직급 : " + level);		
	}	
	
	

}
