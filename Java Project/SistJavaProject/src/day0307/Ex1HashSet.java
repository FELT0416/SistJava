package day0307;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1HashSet {

	//컬렉션_자료구조(Set,Vector,ArrayList,Map)
	//제네릭_명시한 자료형
	//(인터페이스)<데이터형> (인스턴스변수명)=new (클래스명) <데이터형>;
	//(클래스명)<데이터형> (인스턴스변수명)=new (클래스명) <데이터형>;
	
	//List :순서가 중요할때,인덱스번호를 알고있다,중복가능
	//Set: 순서가 안지켜짐,중복허용을 안한다
	//Map: 키<K>에 대한값<V>
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Set<String> set1=new HashSet<String>();
        
        set1.add("강아지");
        set1.add("고양이");
        set1.add("원숭이");
        set1.add("강아지"); //중복되므로 갯수에 포함안됨
        
        System.out.println("데이터 갯수: "+set1.size());
        
        System.out.println("출력 #1");
        for(String s:set1)
        	System.out.println(s);
        System.out.println();
        
        System.out.println("출력 #2");
        Iterator<String> iter=set1.iterator();
        
        while(iter.hasNext()) //데이타가 더이상 없으면 false값 반환
        {
        	String s=iter.next(); //다음..다음 마지막요소까지 돌려줌
        	System.out.println(s);
        }
        
        System.out.println("출력 #3");
        Object [] ob=set1.toArray();
        
        for(int i=0;i<ob.length;i++)
        	System.out.println(ob[i]);
        System.out.println();
        
        //모든데이타 삭제
        set1.clear();
        
        if(set1.isEmpty())
        	System.out.println("Set타입안에 데이타가 없다");
        else
        	System.out.println("Set타입안에 데이타가 있다");
        
        
        
        
		  
	}

}
