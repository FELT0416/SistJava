package day0307;
//자바에서의 함수형 프로그램인 람다 표현식
//익명내부클래스의 또다른 표현식


@FunctionalInterface
interface Orange{
	
	public void write();
	//public void show();단하나의 추상메서드만 가지고있어야 한다
}
//////////////////////

public class Ex8Ramda {

	//익명내부 클래스
	public void abstMethod1()
	{
		Orange or=new Orange() {
			
			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("나는 익명내부 클래스 오렌지");
			}
		};
		
		or.write();
	}
	
	//람다식으로 오버라이드 하기
	public void abstMethod2()
	{
		Orange or=()->System.out.println("나는 람다 오렌지");
		or.write();
		
		System.out.println("여러줄 코드일경우");
		Orange or2=()->{
			
			System.out.println("나는 여러줄");
			System.out.println("람다오렌지");
		};
		or2.write();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex8Ramda ex=new Ex8Ramda();
		ex.abstMethod1();
		System.out.println("------------------------");
		ex.abstMethod2();
	}

}
