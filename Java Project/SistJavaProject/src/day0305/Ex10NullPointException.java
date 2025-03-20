package day0305;

import java.util.Date;

//널포인트 익셉션: 생성하지 않고 클래스의 메소드를 호출하는 경우
public class Ex10NullPointException {

	
	Date date;  //new Date();
	
	public void writeday()
	{
		int y,m,d;
		try {
			y=date.getYear()-1900;
			m=date.getMonth()+1;
			d=date.getDate();
			
			System.out.println(y+"년"+m+"월"+d+"일 입니다");
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace(); 예외가 발생한 라인을 추적해서 표시
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex10NullPointException ex=new Ex10NullPointException();
		ex.writeday();
		
		System.out.println("***정상종료***");
	}

}
