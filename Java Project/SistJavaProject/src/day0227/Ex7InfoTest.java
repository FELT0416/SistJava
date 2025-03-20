package day0227;

class YourInfo{
	
	String myName;
	static String Message;
}
//////////////////////////
public class Ex7InfoTest {

	private String city; //사는지역
	int age; 
	
	public static void main(String[] args) {
		
		System.out.println("[주민정보]");
		
		YourInfo you1=new YourInfo();
		you1.myName="김민기";
		System.out.println("주민명: "+you1.myName);
		
		YourInfo.Message="행복하게 살자";
		System.out.println("메세지: "+YourInfo.Message);
		
		Ex7InfoTest in1=new Ex7InfoTest();
		in1.city="대전";
		System.out.println("지역: "+in1.city);
		
		in1.age=33;
		System.out.println("나이: "+in1.age);
				
	}

}
