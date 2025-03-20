package day0227;

class MyCar{
	
	private String carName;//null
	private int carPrice;//0
	private String carColor;
	
	//setter..3개
	public void setCarName(String cname)
	{
		carName=cname;
	}
	
	public void setCarPrice(int cprice)
	{
		carPrice=cprice;
	}
	 public void setCarColor(String ccolor)
	 {
		 this.carColor=ccolor;
	 }
	
	//getter..3개
	public String getCarName()
	{
		return carName;
	}
	
	public int getCarPrice()
	{
		return carPrice;
	}
	
	public String getCarColor()
	{
		return carColor;
	}
	
	//출력용 메서드
	public void writeCarInfo()
	{
		System.out.println("자동차명: "+this.carName);
		System.out.println("자동차가격: "+carPrice);
		System.out.println("자동차색상: "+carColor);
	}
	
}
///////////////////
public class Ex9ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyCar car=new MyCar();
		car.setCarName("그랜져");
		car.setCarPrice(45000000);
		car.setCarColor("블랙");
		
		System.out.println("[나의 자동차 정보]");
		//getter메서드로 읽어오기
		System.out.println(car.getCarName());
		System.out.println(car.getCarPrice());
		System.out.println(car.getCarColor());
		
		//setter메서드로 수정
		System.out.println("[나의 자동차 정보 수정]");
		car.setCarName("아우디");
		car.setCarPrice(65000000);
		car.setCarColor("화이트");
		
		//출력메서드
		car.writeCarInfo();
	}

}
