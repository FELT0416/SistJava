package day0228;

import java.util.Scanner;

//사원명   기본급     가족수    초과시간    가족수당   초과근무수당   총급여


class Emp{
	//멤버
	//변수:  사원명(name) 기본급(pay)  가족수(famSu)  초과근무시간(timeSu)
	//메서드: setters & getters,  getFamSudang,  getTimeSudang, getTotalPay
	private String name;
	private int pay;
	private int famSu;
	private int timeSu;
	
	//setters & getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getFamSu() {
		return famSu;
	}
	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	public int getTimeSu() {
		return timeSu;
	}
	public void setTimeSu(int timeSu) {
		this.timeSu = timeSu;
	}
	
	//가족수당..가족한명당 5만원(단 4인이상은 무조건 20만원으로 통일)
	public int getFamSudang()
	{
		int fs=0;
		if(famSu>=4)
			fs=20000;
		else
			fs=famSu*50000;
		return fs;
	}
	
	
	//오버타임수당..시간당 근무수당= 초과시간당 3만원(단 10시간 이상은 무조건 30만원으로 통일)
	public int getTimeSudang()
	{
		int ts=0;
		if(timeSu>=10)
			ts=300000;
		else
			ts=timeSu*30000;
		
		return ts;
	}
	
	//총급여 ..기본급+가족수당+오버타임
	public int getTotalPay()
	{
		int tp=pay+getFamSudang()+getTimeSudang();
		return tp;
	}
	
	//제목을 메서드로
	public static void showTitle()
	{
		System.out.println("***직원 급여현황***");
		System.out.println();
		System.out.println("사원명\t기본급\t가족수\t초과시간\t가족수당\t초과근무수당\t총급여");
		System.out.println("--------------------------------------------------------");
	}
	
}
///////////////////////////////////////
///메인에서는 인원을 입력후 해당사원에 대한 이름,기본급,가족수,오버타임을 입력받아 출력할것!!!
public class EmpSalery {

	//emp클래스 결과출력
	public static void showEmpSalery(Emp[] emp)
	{
		//제목까지 출력
		Emp.showTitle();
		for(Emp e:emp)
			System.out.println(e.getName()+"\t"+e.getPay()+"\t"+e.getFamSu()+"\t"
		+e.getTimeSu()+"\t"+e.getFamSudang()+"\t"+e.getTimeSudang()+"\t"+e.getTotalPay());
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int inwon;
		Emp [] emp;
		
		System.out.println("입력할 직원수는?");
		inwon=Integer.parseInt(sc.nextLine());
		
		//배열할당
		emp=new Emp[inwon];
		
		//인원수만큼 데이타 입력
		for(int i=0;i<inwon;i++)
		{
			emp[i]=new Emp(); //디폴트 생성자
			System.out.println("이름");
			String name=sc.nextLine();
			
			System.out.println("급여");
			int pay=Integer.parseInt(sc.nextLine());
			
			System.out.println("가족수는?");
			int fs=Integer.parseInt(sc.nextLine());
			
			System.out.println("초과근무시간?");
			int ts=Integer.parseInt(sc.nextLine());
			
			//setter메서드로 emp클래스에 데이타 넣기
			emp[i].setName(name);
			emp[i].setPay(pay);
			emp[i].setFamSu(fs);
			emp[i].setTimeSu(ts);
			
		}
		
		//출력
		showEmpSalery(emp);
	}

}
