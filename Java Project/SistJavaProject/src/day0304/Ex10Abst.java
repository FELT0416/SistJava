package day0304;

import java.util.Scanner;

//추상클래스
abstract class Board{
	
	public abstract void process();  //추상메서드
}

//자식클래스 4개
class List extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판을 출력합니다");
	}
	
}
class Write extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판을 입력합니다");
	}
	
}
class Update extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판을 수정합니다");
	}
	
}
class Delete extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판을 삭제합니다");
	}
	
}
public class Ex10Abst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Board board=new Board(); //추상클래스는 new로 객체생성안됨
		/*Board board;
		board=new List();
		board.process();
		
		board=new Write();
		board.process();
		
		board=new Update();
		board.process();
		
		board=new Delete();
		board.process();*/
		
		Scanner sc=new Scanner(System.in);
		int num; //입력할 숫자
		Board board=null; //부모로 선언
		
		
		while(true)
		{
			System.out.println("1.입력   2.출력   3.수정   4.삭제   9.나머지숫자 종료");
			num=sc.nextInt();
			
			switch(num)
			{
			case 1:
				board=new Write();
				break;
			case 2:
				board=new List();
				break;
			case 3:
				board=new Update();
				break;
			case 4:
				board=new Delete();
				break;
			default:
				System.out.println("종료합니다");
				System.exit(0);  //강제종료
			}
			
			board.process(); //다형성이므로 하나의 변수로 4개의 메소드호출이 가능해짐!!!!!
			
		}
		
		
	}

}
