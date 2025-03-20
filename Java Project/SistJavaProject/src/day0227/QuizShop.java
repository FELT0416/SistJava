package day0227;

public class QuizShop {

	private String sangName;
	private int su;
	private int dan;
	
	static int cnt=0;
	static String jijum; 
	
	public QuizShop() {
		// TODO Auto-generated constructor stub
	}
	
	//명시적 생성자
	public QuizShop(String name,int su,int dan) {
		sangName=name;
		this.su=su;
		this.dan=dan;
	}
	
	//명시적setter
	public void setIpgoData(String name,int su,int dan)
	{
		sangName=name;
		this.su=su;
		this.dan=dan;
	}
	//출력문
	public void getIpgoData()
	{
		cnt++;
		System.out.println("***입고물품"+cnt+"정보***");
		System.out.println("이름: "+this.sangName);
		System.out.println("입고지점: "+QuizShop.jijum);
		System.out.println("입고상품: "+sangName);
		System.out.println("가격: "+dan);
		System.out.println("수량: "+su);
		System.out.println("=================================");
	}
}
