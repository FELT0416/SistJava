package day0228;

class Student{
	
	private String stuName;
	private String hp;
	private int score;
	
	//명시적생성자3개인자
	public Student(String name,String hp,int score) {
		this.stuName=name;
		this.hp=hp;
		this.score=score;
	}
	
	//출력메시도
	public void writeData()
	{
		System.out.println("이름: "+stuName);
		System.out.println("핸드폰: "+hp);
		System.out.println("점수: "+score);
	}
}
///////////////////////////////////
public class Ex2ArrayConst {

	public static void main(String[] args) {
		// 생성을 배열로
		Student [] stu1=new Student[3];
		
		//번지주소값에 따른 초기화
		stu1[0]=new Student("홍길동", "010-2222-3333", 77);
		stu1[1]=new Student("이순신", "010-111-2222", 88);
		stu1[2]=new Student("김민선", "010-777-8888", 99);
		
		//for문으로 출력
		System.out.println("출력방법1");
		for(int i=0;i<stu1.length;i++)
		{
			/*Student s=stu1[i];
			s.writeData();*/
			stu1[i].writeData();
			System.out.println("=======================");
		}
		
		//for~each
		System.out.println("출력방법2");
		for(Student s:stu1)
		{
			s.writeData();
			System.out.println("=========================");
		}
		
		

	}

}
