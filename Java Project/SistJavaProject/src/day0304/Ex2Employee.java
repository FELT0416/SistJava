package day0304;

//부모
public class Ex2Employee {

	String sName;
	int salary;
	
	//명시적 생성자
	public Ex2Employee(String name,int sal) {
		sName=name;
		salary=sal;
	}
	
	//출력 메서드
	public String getEmp()
	{
		String s=sName+","+salary;
		return s;
	}
}
