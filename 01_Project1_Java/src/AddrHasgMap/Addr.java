package AddrHasgMap;


public class Addr {
	private String phoneNumber;
	private String email;
	private String address;
	private String group;

	public Addr(String phoneNumber, String eMail, String address, String group) {
		this.phoneNumber = phoneNumber;
		this.email = eMail;
		this.address = address;
		this.group = group;
	}


	public String getPhoneNumber() { return phoneNumber; }

	public void setPhoneNumber(String phoneNum) { this.phoneNumber = phoneNum; }

	public String getEMail() { return email; }

	public void setEMail(String email) { this.email = email; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }

	public String getGroup() { return group; }

	public void setGroup(String group) { this.group = group; }
}