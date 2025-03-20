package day0307;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex7BoardList {

	//클래스형으로 지정했으므로 데이터를 꺼내고 받을때도 클래스
	List<Ex7Board> list=new Vector<Ex7Board>();
	
	//데이타 입력
	public void inputData()
	{
		Scanner sc=new Scanner(System.in);
		String writer,subject,content;
		
		System.out.println("작성자명");
		writer=sc.nextLine();
		System.out.println("글제목");
		subject=sc.nextLine();
		System.out.println("글내용");
		content=sc.nextLine();
		
		Ex7Board data=new Ex7Board(writer, subject, content);
		list.add(data);
		
		System.out.println("현재 데이타 갯수: "+list.size()+"개");
		
	}
	
	//데이타 출력
	public void writeData()
	{
		System.out.println("\t**게시판 출력**");
		System.out.println("===================================");
		for(int i=0;i<list.size();i++)
		{
			Ex7Board b=list.get(i); //리스트내의 지정된위치에 있는 요소값을 돌려준다
			
			System.out.println("번호: "+(i+1)+"\t작성자: "+b.getWriter());
			System.out.println("제목: "+b.getSubject());
			System.out.println("내용: "+b.getContent());
			System.out.println("==========================================");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex7BoardList ex7=new Ex7BoardList();
		Scanner sc=new Scanner(System.in);
		int n=0;
		
		while(true)
		{
			System.out.println("1.추가    2.전체출력   9.종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				ex7.inputData();
			else if(n==2)
				ex7.writeData();
			else if(n==9)
			{
				System.out.println("종료합니다");
				break;
			}
				
		}
		
	}

}
