package day0305;

class Outer{
	
	String name="홍길동";
	int age=55;
	
	//외부클래스 메서드
	public void disp()
	{
		//외부클래스 메서드에서 내부클래스 선언하기
		Inner1 in1=new Inner1();
		in1.disp1();
		
		Inner2 in2=new Inner2();
		in2.disp2();
	}
	
	class Inner1{
		
		//내부클래스에서 외부클래스 멤버 변수 사용이 가능
		public void disp1() {
			System.out.println("**Inner1 내부클래스**");
			System.out.println("이름: "+name+", 나이: "+age);
		}
	}
	class Inner2{
		
		public void disp2()
		{
			System.out.println("**Inner2 내부클래스**");
			System.out.println("이름: "+name+", 나이:"+age);
		}
	}
}
////////////////////
public class Ex5InnerClass {

	public static void main(String[] args) {
		// 아웃클래스의 disp메서드 호출
		Outer out=new Outer();
		out.disp();
		System.out.println("다른클래스에서 외부를 통하지 않고\n직접 내부클래스 메서드 호출하려면??");
		System.out.println("==========================");
		
		System.out.println("내부클래스의 disp1호출");
		Outer.Inner1 in1=new Outer().new Inner1();
		in1.disp1();
		
		System.out.println("내부클래스의 disp2호출");
		Outer.Inner2 in2=out.new Inner2();
		in2.disp2();

	}

}
