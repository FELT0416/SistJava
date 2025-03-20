package day0227;

public class Ex5ConstSetter {

	private String name;
	private int age;
	
	//생성자
	public Ex5ConstSetter(String name) {
		
		this(name,44); //다른생성자 호출시 맨첫줄에...
		//this.name=name;
	}
	
	public Ex5ConstSetter(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	//getter메서드 _ 출력용
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex5ConstSetter ex5=new Ex5ConstSetter("홍길동");
		Ex5ConstSetter ex6=new Ex5ConstSetter("김민지",32);
		//Ex5ConstSetter ex5=new Ex5ConstSetter(); 디폴트는 없으므로 에러
		System.out.println("이름은 "+ex5.getName()+"이고 나이는 "+ex5.getAge()+"세 입니다");
		System.out.println("이름은 "+ex6.getName()+"이고 나이는 "+ex6.getAge()+"세 입니다");
	}

}
