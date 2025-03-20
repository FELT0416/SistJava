package day0228;

public class Ex9MethodTest {

	//접근제한자+지정예약어+결과형리턴값+메소드명()
	//오버로딩가능,단 인자값 달라야 한다
	//반복적인 코드를 줄여서 코드의 관리가 용이
	//하나의 메소드에는 하나의 기능만 담는다
	public static boolean aaa()
	{
		return false;
	}
	
	public static int bbb()
	{
		return 33;
	}
	
	public static int ccc(int x,int y)
	{
		//return x+y;
		int z=x+y;
		return z;
	}
	
	public static double sum(int a,double b)
	{
		System.out.println("sum함수호출_1");
		return a+b;
	}
	public static double sum(double a,int b)
	{
		System.out.println("sum함수호출_2");
		return a+b;
	}
	public static double sum(double a,double b)
	{
		System.out.println("sum함수호출_3");
		return a+b;
	}
	
	public static int add(int num1,int num2)
	{
		int result=num1+num2;
		return result;
	}
	
	public static double square(double num)
	{
		return num*num;
	}
	
	public static void main(String[] args) {
	
		boolean a=aaa();
		System.out.println("a="+a);
		
		int b=bbb();
		System.out.println("b="+b);
		
		int c=ccc(40, 30);
		System.out.println("c="+c);
		
		double d=sum(20, 30.5);
		System.out.println("sum d="+d);
		
		double e=sum(55.5, 10);
		System.out.println("sum e="+e);
		
		double f=sum(10.5, 30.9);
		System.out.println("sum f="+f);
		
		System.out.println("10 add 20= "+add(10, 20));
		System.out.println(" 4.5의 곱="+square(4.5));
	}
}
