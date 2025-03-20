package day0305;

//super
class Car{
	private String carName;
	private String carColor;
	
	//디폴트생성자
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	//명시적생성자
	public Car(String name,String color) {
		carName=name;
		carColor=color;
	}
	
	//setters & getters
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	//메서드
	public void writeCar()
	{
		System.out.println("내차는 "+carName+"이고 색상은 "+carColor+" 입니다");
	}
	
	
}

//sub
class MyCar extends Car{
	
	private int carPrice;
	
	//디폴트 생성자
	public MyCar() {
		super(); //생략되어있음
	}
	
	//명시적생성자
	public MyCar(String carName,String carColor,int carPrice) {
		super(carName, carColor);//반드시 첫줄에....
		this.carPrice=carPrice;
		
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	//오버라이딩
	@Override
	public void writeCar() {
		// TODO Auto-generated method stub
		super.writeCar();
		System.out.println("내차의 가격은 "+carPrice+"원 입니다");
	}
	
}

public class Ex1Extends {

	public static void main(String[] args) {
		//자식클래스 디폴트생성
		MyCar my1=new MyCar();
		my1.writeCar();
		
		//자식클래스 명시적생성
		MyCar my2=new MyCar("아우디", "블랙", 54000000);
		my2.writeCar();
		
		//my1을 수정
		System.out.println("my1의 Car값 수정해보기");
		my1.setCarName("그랜져");
		my1.setCarColor("화이트");
		my1.setCarPrice(45000000);
		
		my1.writeCar();

	}

}
