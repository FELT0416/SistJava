package day0227;

import java.util.Calendar;

class Happy{
	
	public Happy() {
		System.out.println("생성자1번");
	}
	public Happy(String msg) {
	   System.out.println("문자열"+msg+"를 받는 생성자 2번");
	}
	public Happy(int age) {
		System.out.println("숫자"+age+"를 받는 생성자 3번");
	}
	public Happy(int age,String msg) {
		System.out.println("숫자"+age+"와 문자"+msg+"를 받는 생성자 4번");
	}
	
	//생성자 대신 인스턴스를 반환해주는 메서드
	public static Happy getInstance()
	{
		return new Happy();
	}
	
}

////////////////////////
public class Ex8GetInstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Happy happy=Happy.getInstance();
        
        Happy happy1=new Happy();
        Happy happy2=new Happy("행복하다");
        Happy happy3=new Happy(33);
        Happy happy4=new Happy(44,"행복해");
        
        
        //Calendar 클래스 이용해서 날짜 출력
        Calendar cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        int m=cal.get(Calendar.MONTH)+1;
        int d=cal.get(Calendar.DATE);
        
        System.out.println("오늘날짜: "+y+"/"+m+"/"+d);
        
        
	}

}
