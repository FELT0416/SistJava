package day0304;

//interface ==>interface : extends
//class==>interface: implements
//class==>class : extends

interface InterA{
	
	public void play();
	public void write();
}

interface InterB {
	
	public void draw();
}

//2개의 인터페이스를 구현하는 클래스..다중구현이 가능
class InterImpl implements InterA,InterB{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("그림그리기");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("게임하기");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("공부하기");
	}
	
}


public class Ex12InterfaceMain {

	public static void main(String[] args) {
		//일반객체생성으로 출력
		InterImpl impl=new InterImpl();
		impl.draw();
		impl.play();
		impl.write();
		
		System.out.println("-------------------------");
		
		//다형성으로 메서드 출력
		InterA inA=new InterImpl();
		inA.play();
		inA.write();
		
		System.out.println("-------------------------");
		
		InterB inB=new InterImpl();
		inB.draw();

	}

}
