package day0306;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex6Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date=new Date();
		System.out.println(date);
		
		//날짜,시간을 원하는 양식으로 출력  HH:24시간표기   MM:월  mm:분
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(sdf1.format(date));
		
		//a:오전/오후  hh:12시간표기
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		System.out.println(sdf2.format(date));
		//EEE:요일짧게   EEEE:요일길게
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd HH:mm EEE");
		System.out.println(sdf3.format(date));
		
		SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");
		System.out.println(sdf4.format(date));
		
		//숫자는 문자열로 변환해서 출력(컴마나 소수점지정)
		int money=6580000;
		double num=68.5489;
		
		NumberFormat nf1=NumberFormat.getCurrencyInstance();//원단위 화폐와 컴마제공
		System.out.println(nf1.format(money));
		
		NumberFormat nf2=NumberFormat.getInstance();//컴마제공
		System.out.println(nf2.format(money));
		System.out.println(nf2.format(num));
		
	}

}
