package day0307;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ex3Set {

	public static void main(String[] args) {
		// 난수발생시켜서 1~45사이의 난수6개구해서 출력
		
		Set<Integer> set=new HashSet<Integer>();
		//Random r=new Random();
		while(true)
		{
			//1~45사이 난수 발생
			//int n=r.nextInt(45)+1;
			int n=(int)(Math.random()*45)+1;
			
			//발생된 난수를 set에 담기
			set.add(n);
			
			//갯수가 6개가 되면 빠져나가기
			if(set.size()==6)
				break;
		
		}
		
		//출력
		System.out.println("출력 #1");
		for(int n:set)
			System.out.printf("%4d",n);
		System.out.println();
		
		System.out.println("출력 #2");
		Object[] ob=set.toArray();
		
		//정렬
		Arrays.sort(ob); //오름차순
		
		for(int i=0;i<ob.length;i++)
			System.out.printf("%4d",ob[i]);

		
	}

}
