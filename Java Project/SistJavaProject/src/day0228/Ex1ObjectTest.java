package day0228;

class Coffee{
	
	private String americano;
	private String tea;
	private  static String mes="Happy Day~~";
	
	//setters & getters
	public String getAmericano() {
		return americano;
	}
	public void setAmericano(String americano) {
		this.americano = americano;
	}
	public String getTea() {
		return tea;
	}
	public void setTea(String tea) {
		this.tea = tea;
	}
	public static String getMes() {
		return mes;
	}
	public static void setMes(String mes) {
		Coffee.mes = mes;
	}
	
	
}

/////////////////////////
public class Ex1ObjectTest {

	//Coffee클래스의 변수값을 출력하기 위한 메서드
	public static void writeCoffee(Coffee coffee)
	{
		System.out.println("**Coffee클래스 출력**");
		System.out.println("커피종류: "+coffee.getAmericano());
		System.out.println("티종류: "+coffee.getTea());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("커피클래스의 메세지 출력");
		System.out.println(Coffee.getMes());
		
		Coffee c1=new Coffee();
		c1.setAmericano("연한 아메리카노");
		c1.setTea("캐모마일티");
		
		
		Coffee c2=new Coffee();
		c2.setAmericano("진한 아메리카노");
		c2.setTea("히비스커스");
		
		//같은클래스의 static 메서드도 호출은 클래스명 생략가능
		writeCoffee(c1);
		writeCoffee(c2);
		
		
	}

}
