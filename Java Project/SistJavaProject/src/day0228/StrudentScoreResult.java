package day0228;

import java.util.Scanner;

class StudentScore{
	
	private String stuName;
	private int java,html,mysql;
	
	//setters & getters
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getMysql() {
		return mysql;
	}
	public void setMysql(int mysql) {
		this.mysql = mysql;
	}
	
	//총점
	public int getTotal()
	{
		return java+html+mysql;
	}
	//평균
	public double getAverage()
	{
		return getTotal()/3.0;
	}
	
	//평가
	public String getPungga()
	{
		if(getAverage()>=90)
			return "장학생";
		else if(getAverage()>=80)
			return "우수생";
		else
			return "재수강";
	}
}
////////////////////////
public class StrudentScoreResult {

	public static void writeScoreResult(StudentScore s)
	{
		System.out.println(s.getStuName()+"\t"+s.getJava()+"\t"+s.getHtml()+"\t"
				+s.getMysql()+"\t"+s.getTotal()+"\t"+s.getAverage()+"\t"+s.getPungga());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int inwon;
		String name;
		int java,html,mysql;
		StudentScore [] stu;
		
		System.out.println("입력할 학생수는?");
		inwon=Integer.parseInt(sc.nextLine());
		
		//인원수만큼 StudentScore클래스 배열할당
		stu=new StudentScore[inwon];
		
		//인원수만큼 입력
		for(int i=0;i<inwon;i++)
		{
			System.out.println(i+"번 학생 이름");
			name=sc.nextLine();
			System.out.println("Java,Html,Mysql점수 입력");
			java=Integer.parseInt(sc.nextLine());
			html=Integer.parseInt(sc.nextLine());
			mysql=Integer.parseInt(sc.nextLine());
			
			//i번째 StudentScore 생성
			stu[i]=new StudentScore();
			stu[i].setStuName(name);
			stu[i].setJava(java);
			stu[i].setHtml(html);
			stu[i].setMysql(mysql);
		}
		
		System.out.println("**시험 결과 출력**");
		System.out.println("학생명\tJava\tHtml\tMysql\t총점\t평균\t종합평가");
		System.out.println("====================================================");
		for(StudentScore s:stu)
			writeScoreResult(s);
		
		
	}

}
