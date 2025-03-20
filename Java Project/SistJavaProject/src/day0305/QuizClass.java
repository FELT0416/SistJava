package day0305;

import java.text.NumberFormat;
import java.util.Scanner;

class Company{
	
	private String staff,position; //직원명,직급
	private int famSu; //가족수
	
	//디폴트 생성자
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	//사원명,직급,가족수를 인자로 받는 생성자
	public Company(String staff,String position,int famsu) {
		this.staff=staff;
		this.position=position;
		this.famSu=famsu;
	}

	//각각의 setters & getters
	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFamSu() {
		return famSu;
	}

	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	
	//직급에 따라 기본급:  부장->450 과장->350  대리->280  사원->220  getGibonPay()
	public int getGibonPay()
	{
		int gibon=switch(position)
				{
		           case "부장"->4500000;
		           case "과장"->3500000;
		           case "대리"->2800000;
		           case "사원"->2200000;
		           default->0;
				};
		
		return gibon;
	}
	
	//직급에 따라 수당: 부장,과장==>100  대리,사원==>70만원  getSudangPay()
	public int getSudangPay()
	{
		int sudang=switch(position) {
		
			case "부장","과장"->1000000;
			case "대리","사원"->700000;
			default->0;
		};
		
		return sudang;
	}
	
	//가족수가 5인이상: 30만 5인미만2인이상은 10만원   나머지는 0  getFamSudang()
	public int getFamSudang()
	{
		int fsudang=0;
		
		   if(famSu>=5)
			   fsudang=300000;
		   else if(famSu>=2)
			   fsudang=100000;
		   else
			   fsudang=0;
		
		return fsudang;
	}
	//세금:   기본급의 5%를 반환받아서 세금   getTax()
	public int getTax()
	{
		int tax=getGibonPay()*5/100;
		
		return tax;
	}
	
	//실수령액:  기본급+수당+가족수당-세금   getNetPay()
	public int getNetPay()
	{
		return getGibonPay()+getSudangPay()+getFamSudang()-getTax();
	}
	
	
}
///////////////////////////
public class QuizClass {
	
	
	//제목출력 메서드(showTitle())
	//사원명    직급    기본급    수당    가족수당    세금    실수령액
	public static void showTitle()
	{
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(50));
	}
	//한개의 사원데이타 출력  메서드   writeSawon()
	public static void writeSawon(Company company)
	{
		NumberFormat nf=NumberFormat.getInstance();
		
		System.out.println(company.getStaff()+"\t"+company.getPosition()+"\t"
				+ nf.format(company.getGibonPay()) +"\t"
				+ company.getSudangPay() +"\t"+company.getFamSudang() +"\t"
				+company.getTax() +"\t"+company.getNetPay() );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//인원수를 입력후 인원수만큼 배열 메모리에 할당
		int inwon;
		Company [] myCompany;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("입력할 사원수는?");
		inwon=Integer.parseInt(sc.nextLine());
		
		myCompany=new Company[inwon];
		
		//배열에 데이타를 입력후 생성자를 통해서 데이타 저장하기
		for(int i=0;i<inwon;i++)
		{
			System.out.println("사원명은?");
			String staff=sc.nextLine();
			System.out.println("직급은?");
			String pos=sc.nextLine();
			System.out.println("가족수는?");
			int fsu=Integer.parseInt(sc.nextLine());
			
			//사원생성_방법1
			/*myCompany[i]=new Company(); //디폴트
			myCompany[i].setStaff(staff);
			myCompany[i].setPosition(pos);
			myCompany[i].setFamSu(fsu);*/
			
			//사원생성_방법2
			myCompany[i]=new Company(staff, pos, fsu);
		}
		
		
		//제목출력
		showTitle();
		
		//반복문통해서 데이타출력하는 메서드 호출
		for(Company c:myCompany)
			writeSawon(c);

	}

}
