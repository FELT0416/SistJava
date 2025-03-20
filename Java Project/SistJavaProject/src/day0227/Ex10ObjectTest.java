package day0227;

class Jungbo{
	
	private String name;
	private int age;
	private String job;
	private String hobby;
	
	//setter & getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	//출력메서드
	public void writeJungbo() {
		System.out.println("이름: "+this.name+" ,나이: "+this.age+" ,직업: "+job+" ,취미: "+hobby);
	}
	
	
}
/////////////////////////////////
public class Ex10ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jungbo jb=new Jungbo();
		jb.writeJungbo();
		
		jb.setName("김연아");
		jb.setAge(33);
		jb.setJob("주부");
		jb.setHobby("여행");
		
		//출력 메서드로 조회
		jb.writeJungbo();
		
		
		//2번째 객체 생성해서 setter이용 수정  getter이용 출력
		Jungbo jb2=new Jungbo();
				
		System.out.println("두번째 객체생성후 수정 조회");
		jb2.setName("손흥민");
		jb2.setAge(35);
		jb2.setJob("교사");
		jb2.setHobby("게임");
		
		System.out.println("이름: "+jb2.getName());
		System.out.println("나이: "+jb2.getAge());
		System.out.println("직업: "+jb2.getJob());
		System.out.println("취미: "+jb2.getHobby());
		
	}

}
