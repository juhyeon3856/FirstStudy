package addressBookInterface;

public class CompanyAddr extends Addr{
	private String companyName;
	private String departmentName;
	private String level;
	
	public CompanyAddr(String name, String phoneNum, String email, String addr, String group, String companyName, String departmentName, String level) {
		super(name, phoneNum, email, addr, group);
		this.companyName = companyName;
		this.departmentName = departmentName;
		this.level = level;
	}
	
		
	//객체 정보 출력
	@Override
	public void printAddr() {
		super.printAddr();
		System.out.println("회사이름 : " + companyName);
		System.out.println("부서이름 : " + departmentName);
		System.out.println("직급 : " + level);		
	}	
	
	
}
