package addressBook;

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
		System.out.println("--------------------------------------");
		super.printAddr();
//		System.out.println("이름 : " + super.getName());
//		System.out.println("전화번호 : " + super.getPhoneNum());
//		System.out.println("이메일 : " + super.getEmail());
//		System.out.println("주소 : " + super.getAddr());
//		System.out.println("그룹(친구/가족) : " + super.getGroup());
		System.out.println("회사이름 : " + companyName);
		System.out.println("부서이름 : " + departmentName);
		System.out.println("직급 : " + level);		
//		System.out.println("--------------------------------------");
	}	
}
