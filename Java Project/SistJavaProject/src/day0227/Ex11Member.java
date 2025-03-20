package day0227;

public class Ex11Member {

	private String stuName;
	private String gender;
	private String addr;
	
	static int cnt=0;
	static String ban; //우리반
	
		
	//멤버를 한번에 수정가능하게 만들자
	public void setMemberData(String name,String gender,String addr)
	{
		stuName=name;
		this.gender=gender;
		this.addr=addr;
	}
	
	public void getMemberData()
	{
		cnt++;
		System.out.println("***학생"+cnt+"정보***");
		System.out.println("이름: "+this.stuName);
		System.out.println("소속학급: "+Ex11Member.ban);
		System.out.println("성별: "+gender);
		System.out.println("주소: "+addr);
	}
	
}
