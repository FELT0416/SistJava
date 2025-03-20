package day0228;

class Sangjum{
	
	private String sangpum;
	private int price;
	private String color;
	
	//생성자3개
	public Sangjum(String s,int p,String c) {
		sangpum=s;
		price=p;
		color=c;
	}
	
	//제목을 메서드로
	public static void showTitle() {
		System.out.println("상품명\t단가\t색상");
		System.out.println("================================");
	}
	//출력문
	public void showSangpum() {
		
		System.out.println(sangpum+"\t"+price+"원\t"+color);
	}
	
}

public class Ex4ArrayConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sangjum [] sj=new Sangjum[4]; //4개를 생성할거란 주소만 할당되어있는 상태(초기값 모두 null)
		
		//4개의 상점배열에 생성자를 통해서 생성
		sj[0]=new Sangjum("청바지", 45000, "블루");
		sj[1]=new Sangjum("블라우스", 55000, "핑크");
		sj[2]=new Sangjum("점퍼", 99000, "블랙");
		sj[3]=new Sangjum("화이트진", 42000, "화이트");
		
		//출력
		Sangjum.showTitle();
		for(int i=0;i<sj.length;i++)
		{
			sj[i].showSangpum();
		}
		
		System.out.println("------------------------");
		for(Sangjum s:sj)
		{
			s.showSangpum();
		}
		
		
	}

}
