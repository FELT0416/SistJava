package day0307;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MySawon
{
	public void sawonAdd(String name);
}

@FunctionalInterface
interface Sales
{
	public void sangpumAdd(String sangpum,int su,int dan);
}

public class Ex9RamdaTest {

	MySawon sawon1=(name)->System.out.println(name+"사원을 추가함!!!");
	
	Sales sa=(sang,su,dan)->{
		
		System.out.println(sang+"상품등록됨");
		System.out.println("수량: "+su+"개");
		System.out.println("단가: "+dan+"원");
		System.out.println("총금액: "+su*dan+"원");
		System.out.println("----------------------------------");
	};
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex9RamdaTest ex9=new Ex9RamdaTest();
		ex9.sawon1.sawonAdd("홍길동");
		ex9.sawon1.sawonAdd("이수연");
		
		ex9.sa.sangpumAdd("텀블러", 25, 25000);
		ex9.sa.sangpumAdd("카드지갑", 30, 45000);		
		
		//리스트
		List<String> list1=new ArrayList<String>();
		list1.add("사과");
		list1.add("오렌지");
		list1.add("사과");
		list1.add("오렌지");
		
		//출력1
		for(String s:list1)
			System.out.print(s+"  ");
		System.out.println();
		
		//출력2
		list1.forEach(s->System.out.println(s));
		
		
		
	}

}
