package day0304;

interface GameA{
	
	public void play();
}
interface GameB {
	public void stop();
}
class MyGame implements GameB,GameA{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("게임시작");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("게임중지");
	}
	
}
public class Ex13InterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.일반객체생성방법");
				
         MyGame my=new MyGame();
         my.play();
         my.stop();
         
         System.out.println("2.다형성 객체생성방법");
         GameA ga=new MyGame();
         ga.play();
         
         GameB gb=new MyGame();
         gb.stop();
		
	}

}
