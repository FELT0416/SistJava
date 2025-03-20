package day0307;

import java.util.List;
import java.util.Vector;

public class Ex5List {

	public static void write(String title,List<String> list)
	{
		System.out.println("***"+title+"***");
		for(int i=0;i<list.size();i++)
		   System.out.println(i+":"+list.get(i));
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		String [] data={"피자","햄버거","비빔밥","초밥","된장찌개"};
		
		//배열 data를 list에 담기
		List<String> list=new Vector<String>();
		
		for(String d:data)
			list.add(d);
		write("초기데이타전체출력", list);
		
		System.out.println("1번 인덱스 삭제");
		list.remove(1);
		write("삭제후결과", list);
		
		System.out.println("한우 추가하기");
		list.add("한우");
		write("추가후결과", list);
		
		System.out.println("1번 인덱스의 비빔밥을 육회비빔밥으로 변경");
		list.set(1, "육회비빔밥");
		write("수정후결과", list);
		
		System.out.println("전체삭제");
		list.clear();
		System.out.println("데이타: "+list.size());
		
		

	}

}
