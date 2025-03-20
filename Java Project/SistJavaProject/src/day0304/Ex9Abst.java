package day0304;

//super
//추상클래스
//추상클래스는 new로 생성못함
//abstract메서드를 하나라도 가지고있으면  abstract클래스
//abstract클래스는 일반메서드와 추상메서드 둘다 포함가능
abstract class Fruit{
	
	public static final String MESSAGE="오늘 날씨 너무 안좋다";  //상수
	
	//일반메서드
	public void showTitle() {
		System.out.println("우리는 추상클래스를 공부중~~~");
	}
	
	//추상메서드...미완의 메서드(선언문만 있고 몸통이 없음)
	//오버라이딩이 목적이므로 선언만!!!!!
	abstract public void showMessage(); 
}
//////sub
class Apple extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println(MESSAGE);
		System.out.println("Apple_showMessage");
	}
	
}

class Orange extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println(Fruit.MESSAGE);
		System.out.println("Orange_showMessage");
	}
	
}
class Kiwi extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("Kiwi_showMessage");
	}
	
}
public class Ex9Abst {

	public static void main(String[] args) {
		//다형성 출력
		//다형성은 하나의 변수로 여러가지 일을 처리할때 이용
		//다형성은 하위클래스로 생성
		//부모클래스명 변수명=new 자식클래스명();
		
		Fruit friut;
		
		friut=new Apple();
		friut.showMessage();
		friut.showTitle();
		
		friut=new Orange();
		friut.showMessage();
		friut.showTitle();
		
		friut=new Kiwi();
		friut.showMessage();
		friut.showTitle();
		

	}

}
