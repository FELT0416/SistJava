package day0304;
class School{
	
	public static final String SCHOOLNAME="쌍용고등학교";
	private String schoolAddr;
	private int countStu;
	private int countTeacher;
	
	public School() {
		/*schoolAddr="강남구";
		countStu=200;
		countTeacher=15;*/
		
		this("강남구", 200, 15); //다른생성자 호출 this()
	}
	public School(String addr,int cntS,int cntT) {
		this.schoolAddr=addr;
		this.countStu=cntS;
		this.countTeacher=cntT;
	}
	
	//setters & getters
	public String getSchoolAddr() {
		return schoolAddr;
	}
	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}
	public int getCountStu() {
		return countStu;
	}
	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}
	public int getCountTeacher() {
		return countTeacher;
	}
	public void setCountTeacher(int countTeacher) {
		this.countTeacher = countTeacher;
	}
	
	
	
	//출력 메서드
	public void writeSchoolData()
	{
		System.out.println("학교주소: "+this.schoolAddr);
		System.out.println("학생수: "+this.countStu+" ,선생님수: "+this.countTeacher);

	}
	
}
//////////////////////
class Student extends School{
	
	private String stuName;
	private int score;
	
	public Student() {
		// 초기값 맘대로
	}
	
	public Student(String schoolAddr,int countStu,int countTeacher,String stuName,int score) {
		super(schoolAddr, countStu, countTeacher);
		this.stuName=stuName;
		this.score=score;
	}

	//setter & getters
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	//오버라이딩 메서드
	@Override
	public void writeSchoolData() {
		// TODO Auto-generated method stub
		
		System.out.println("학교명: "+SCHOOLNAME);
		super.writeSchoolData();
		System.out.println("학생명: "+stuName);
		System.out.println("성적: "+score);
	}
	
}
////////////////////////
public class Ex6InheritTest {

	public static void main(String[] args) {
		// 디폴트생성자,명시적생성자 각각 생성후 출력
		Student s1=new Student();
		s1.writeSchoolData();
		
		Student s2=new Student("부산시해운대구",300,200,"홍길동",88);
		s2.writeSchoolData();
		
		//수정
		s1.setStuName("이수연");
		s1.setScore(100);
		s1.writeSchoolData();
		
				
	}

}
