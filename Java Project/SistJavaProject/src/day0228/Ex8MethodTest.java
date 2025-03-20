package day0228;

public class Ex8MethodTest {

	public static void hi(int age)
	{
		System.out.println("안녕");
		System.out.println("저의 나이는 "+age+"입니다");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("프로그램의 시작!!");
		hi(22);
		hello("홍길동");
		hi(55);
		hello("김민희");
		System.out.println("프로그램의 끝");
	}
	
	public static void hello(String str)
	{
		System.out.println("반갑습니다");
		System.out.println("저의 이름은"+str+"입니다");
	}
	

}
