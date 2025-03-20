package day0304;

//super
class Color{
	
	public void hello() {
		System.out.println("Hello~~~");
	}
}
//sub1
class Red extends Color{
	
	public void process()
	{
		System.out.println("나는 빨강색을 좋아해");
	}
}
//sub2
class Yellow extends Color{
	
	public void process()
	{
		System.out.println("나는 노랑색을 좋아해");
	}
}
//sub3
class Green extends Color{
	
	public void process()
	{
		System.out.println("나는 초록색을 좋아해");
	}
}

public class Ex7InheritDa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1.Red로 선언하고 Red로 생성한경우");
		Red red=new Red();
		red.hello();
		red.process();
		
		System.out.println("2.Yellow로 선언하고 Yellow로 생성한경우");
		Yellow yellow=new Yellow();
		yellow.hello();
		yellow.process();
		
		System.out.println("3.Green로 선언하고 Green로 생성한경우");
		Green green; //선언
		green=new Green();//생성
		
		//Green green=new Green();
		green.hello();
		green.process();
		
		
		//다형성_부모로 선언하고 자식으로 생성하는 경우
		Color col1; //선언
		col1=new Red(); //생성
		
		col1.hello(); //부모가 가진 메소드 호출도 ok!!!
		//메서드가 오버라이드 된 경우 호출 ok
		//부모한텐 없고 자식만 갖고있는 메서드는 호출안됨!!!!
		//col1.process(); 호출안됨
		
	}

}
