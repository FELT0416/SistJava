package day0304;

import java.util.Scanner;

/*  보너스는 개발부만 백만 나머지부서는 50만원 일괄지급
 * 사원명?
 * 홍길동
 * 부서?
 * 개발부
 * 기본급?
 * 2000000
 * ==========================================
 * 사원명    부서     기본급     보너스      총급여
 * 홍길동   개발부    2000000   1000000   3000000
 * 
 */

class Sawon{
	
	private String sawonName,buseo;
	private int gibonPay;
	
	
	//명시적생성자(3가지 인자 초기화하는 값 넘기기)
	public Sawon(String name,int gpay,String buseo) {
		sawonName=name;
		gibonPay=gpay;
		this.buseo=buseo;
	}	
	//메서드_getBonus
	public int getBonus()
	{
		if(buseo.equals("개발부"))
			return 1000000;
		else
			return 500000;
	}
	//메서드_getTotalPay
	public int getTotalPay()
	{
		return gibonPay+getBonus();
	}
	
	//최종급여출력
	public void writeSawonPay()
	{
		System.out.println(sawonName+"\t"+buseo+"\t"+gibonPay+"\t"
				+getBonus()+"\t"+getTotalPay());
	}
	
}
//////////////////////////////
public class QuizSawon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		//변수선언
		Sawon sawon;
		String name,buseo;
		int gibon;
		
		//입력
		System.out.println("사원명은?");
		name=sc.nextLine();
		System.out.println("부서는?");
		buseo=sc.nextLine();
		System.out.println("기본급은?");
		gibon=sc.nextInt();
		
		//생성
		sawon=new Sawon(name, gibon, buseo);
		
		//제목출력
		System.out.println("사원명\t부서명\t기본급\t보너스\t총급여");
		System.out.println("----------------------------------------");
		
		//출력메서드 호출
		sawon.writeSawonPay();
		
		
		
	}

}
