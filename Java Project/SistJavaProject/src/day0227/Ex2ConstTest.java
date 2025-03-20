package day0227;

class Const{
	
	
	int num; //0
	
	//디폴트 생성자는 보이지않지만 이미존재한다
	public Const() {
		num=100;
		System.out.println("나는 디폴트 생성자");
	}
	
	//인자있는 생성자가 필요하다면 반드시 생성자를 만든다
	public Const(int num) {
		this.num=num;
		System.out.println("인자있는 생성자호출");
	}
	
	//메서드
	public int getNumber()
	{
		num=50;
		return num;
	}
	
}
/////////////////////////////
public class Ex2ConstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//인자있는생성자 생성
		Const con1=new Const(300);
		System.out.println(con1.num);
		
		//디폴트생성자
		Const con2=new Const();
		//con2.num=200;
		System.out.println(con2.num);
		
		//메서드출력
		Const con3=new Const();
		 System.out.println(con3.getNumber()); 
		
		
	}

}
