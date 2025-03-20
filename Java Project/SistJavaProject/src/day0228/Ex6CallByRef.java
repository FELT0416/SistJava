package day0228;

class MyBag{
	 String bagName;
	 int bagPrice;
	 String bagColor;
}
//////////////////////////////////////
public class Ex6CallByRef {

	//입력
	public static void bagInfoIn(MyBag bag)
	{
		//MyBag멤버 초기화
		bag.bagName="백팩";
		bag.bagPrice=65000;
		bag.bagColor="블랙";
		
	}
	
	//출력
	public static void bagInfoOut(MyBag bag)
	{
		System.out.println("가방명: "+bag.bagName);
		System.out.println("가방가격: "+bag.bagPrice);
		System.out.println("가방색상: "+bag.bagColor);
	}
	
	public static void main(String[] args) {
		//두메서드 다 주소전달되므로 메인의 bag변수에 데이타가 들어가고 출력된다
		MyBag bag=new MyBag();
		
		bagInfoIn(bag);
		bagInfoOut(bag);

	}

}
