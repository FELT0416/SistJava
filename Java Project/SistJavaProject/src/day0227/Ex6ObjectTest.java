package day0227;

class MyDate{
	
	private int year;
	private int month;
	private int day;
	
	//명시적 생성자 (인자 3개 )
	public MyDate(int y,int m,int d) {
		this.year=y;
		month=m;
		day=d;
	}
	
	//getter 메서드
	public int getYear()
	{
		return year;
	}
	public int getMonth()
	{
		return month;
	}
	public int getDay()
	{
		return day;
	}
	
}
///////////////////////////////
public class Ex6ObjectTest {

	public static void main(String[] args) {
		// 인자3개를 가진 명시적생성자를 이용해서 객체생성

		MyDate my1=new MyDate(1988, 10, 10);
		
		//출력
		//System.out.println(my1.getYear()+"년 "+my1.getMonth()+"월 "+my1.getDay()+"일");
		System.out.println("년도: "+my1.getYear());
		System.out.println("월: "+my1.getMonth());
		System.out.println("일: "+my1.getDay());
	}

}
