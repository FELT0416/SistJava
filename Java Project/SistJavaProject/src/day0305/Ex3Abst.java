package day0305;

//추상메서드 하나라도 가지고 있다면 추상클래스
abstract class Game{
	abstract void play(); //추상메서드
	abstract void stop();
}
///////////////////
class YongHee extends Game{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("용희 님이 게임을 시작합니다");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("용희님이 게임을 중지합니다");
	}
	
}
class JooHee extends Game{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("주희님이 게임을 시작합니다");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("주희님이 게임을 중단합니다");
	}
	
}
class HeaJee extends Game{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("혜지님이 게임을 시작합니다");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("혜지님이 게임을 중단합니다");
	}
	
}

public class Ex3Abst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //배열선언 3개
		Game[] game=new Game[3]; //부모로 선언
		
		//각각의 자식으로 생성..다형성
		game[0]=new YongHee();
		game[1]=new JooHee();
		game[2]=new HeaJee();
		
		//출력
		for(int i=0;i<game.length;i++)
		{
			game[i].play();
		}
		System.out.println("==================");
		for(int i=game.length-1;i>=0;i--)
		{
			game[i].stop();
		}
	}

}
