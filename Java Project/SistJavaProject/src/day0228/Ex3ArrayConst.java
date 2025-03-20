package day0228;

class MyShop{
	
	private String sangName;
	private int su;
	private int dan;
	
	//생성자 인자3개
	public MyShop(String name,int su,int dan) {
		this.sangName=name;
		this.su=su;
		this.dan=dan;
	}
	
	//출력
	public void writeSangpum()
	{
		System.out.println("상품명: "+sangName);
		System.out.println("수량: "+su);
		System.out.println("단가: "+dan);
	}
	
}

public class Ex3ArrayConst {

	public static void main(String[] args) {
		
		MyShop[] ms= {
				new MyShop("사과", 100, 4000),
				new MyShop("오렌지", 200, 1500),
				new MyShop("바나나", 150, 3000)
		};
		
		System.out.println("for문 출력");
		for(int i=0;i<ms.length;i++)
		{
			//MyShop s=ms[i];
			//s.writeSangpum();
			ms[i].writeSangpum();
			System.out.println("----------------------------");
		}
		
		System.out.println("for~each문 출력");
		for(MyShop m:ms)
		{
			m.writeSangpum();
			System.out.println("--------------------------");
		}
		

	}

}
