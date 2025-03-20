package day0310;

//1번을 스레드를 상속받는 클래스로 구현
public class ThreadEx2 extends Thread{

	String name;
	int num;
	
	public ThreadEx2(String name,int num) {
		this.name=name;
		this.num=num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i=1;i<=num;i++)
		{
			System.out.println(name+"==>"+i);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//new로 생성
		ThreadEx2 th1=new ThreadEx2("하나", 300);
		ThreadEx2 th2=new ThreadEx2("둘", 300);
		ThreadEx2 th3=new ThreadEx2("셋", 300);
		
		//run메서드 호출_start
		th1.start(); //Rannable상태에서 스케쥴러에의해서 하나씩 Running상태가 된다
		th2.start();
		th3.start();
	}

}
