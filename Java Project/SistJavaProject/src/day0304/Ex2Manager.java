package day0304;

//자식
public class Ex2Manager extends Ex2Employee{

	String dept; //부서
	
	public Ex2Manager(String name, int sal,String d) {
		super(name, sal); //부모생성자 호출
		dept=d;  //초기화
		
	}

	//오버라이딩
	@Override
	public String getEmp() {
		// TODO Auto-generated method stub
		return super.getEmp()+": "+dept;
	}
}
