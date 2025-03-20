package day0228;

//데이터 타입
//기본형: int,long,double,char....값이전달
//레퍼런스형: 클래스형태로 된것,배열..주소가전달

class Test1{
	
	String name="이효리";
	String addr="제주";
}
//////////////////////
public class Ex5CallByValRef {

	//1. callByValue 
	public static void changeInt(int n) {
		System.out.println("전달받은 정수값: "+n);
		n=100;
	}
	
	//2.  callByReference
	public static void changeArray(int [] arr) {
		System.out.println("전달받은 배열출력");
		for(int a:arr)
			System.out.println(a);
		arr[1]=80;
	}
	//3
	public static void changeTest(Test1 t1)
	{
		System.out.println("전달받은 Test1객체 출력");
		System.out.println(t1.name+","+t1.addr);
		
		//값변경해보자
		t1.name="김민희";
		t1.addr="서울시";
	}
	
	//4.String
	public static void changeString(String str) {
		System.out.println("전달받은 문자: "+str);
		
		//문자열 변경
		str="변경되나 안되나 궁금?";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.value값
		int a=50;
		changeInt(a);
		System.out.println("a값이 바뀔까?"+a); //안바뀜
		
		//2.배열
		int [] arr2= {10,20,30}; //객체로 인식..레퍼런스 변수
		changeArray(arr2);
		
		System.out.println("메서드 호출후 배열값 확인");
		for(int ar:arr2)
			System.out.println(ar); //1번지값 바껴있음
		
		//3.직접만든 Test1클래스 전달
		Test1 t1=new Test1();
		changeTest(t1); //주소가 전달
		
		System.out.println(t1.name+","+t1.addr);
		
		//4.String 은 객체지만 값이 전달됨..8개의 기본형과 마찬가지
		String str="반가워";
		changeString(str);
		
		System.out.println("문자열변경확인: "+str);
		
	}

}
