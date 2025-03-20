package day0307;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex4List {

	public static void main(String[] args) {
		
		//List<String> list=new Vector<String>();
		Vector<String> list=new Vector<String>();
		
		//디폴트생성자의 경우 기본할당크기 10
		System.out.println("초기할당갯수: "+list.capacity());
		System.out.println("초기데이타 갯수: "+list.size());
		
		list.add("사과");
		list.add("오렌지");
		list.add("사과");
		list.add("키위");
		list.add("오렌지");
		list.add("사과");
		
		
		System.out.println("초기할당갯수: "+list.capacity());
		System.out.println("초기데이타 갯수: "+list.size());
		
		System.out.println("출력 #1");
		for(int i=0;i<list.size();i++)
		{
			String s=list.get(i);
			System.out.println(s);
		}
		
		System.out.println("출력 #2");
		for(String s:list)
			System.out.println(s);
		
		System.out.println("출력 #3");
		Iterator<String> iter=list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		

	}

}
