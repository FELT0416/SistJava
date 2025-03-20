package day0227;

class Orange{
	
	public Orange() {
		// 만들지 않아도 자동존재
		System.out.println("디폴트 생성자 호출");
	}
}
///////////////////////
class Apple{
	
	public Apple(String str) {
		System.out.println("생성자 호출: "+str+"인자가 존재함");
	}
}
/////////////////////
class Banana{
	
	//인자String,인자int,디폴트
	//생성자 오버로딩
	public Banana() {
		System.out.println("바나나 디폴트 생성자 호출");
	}
	
	public Banana(String str) {
		System.out.println("바나나 문자열 생성자 호출: "+str);
	}
	public Banana(int num) {
		
		this(); //디폴트 생성자를 다른생성자에서 호출..반드시 첫줄
		System.out.println("바나나 숫자 생성자 호출: "+num);
		
	}
	
}
////////////////////////
public class Ex4ConstTest {

	public static void main(String[] args) {
		// 생성자는 객체생성시 자동호출되는 메서드
		//메소드와 차이점: 클래스명과 같고 리턴형이 존재하지않는다
		//오버로딩이 가능하다(단,인자는 달라야함)

		Orange or=new Orange();
		Apple apple=new Apple("사과");
		Banana b1=new Banana();
		Banana b2=new Banana("오늘은 생성자 배우는날");
		Banana b3=new Banana(1000);
	}

}
