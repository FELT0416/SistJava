package day0310;

//스레드가 아닌상태에서의 실행결과
public class ThreadEx1 {

	String name;
	int num;
	
	public ThreadEx1(String name,int num) {
		this.name=name;
		this.num=num;
	}
	
	public void run()
	{
		for(int i=1;i<=num;i++)
		{
			System.out.println(name+"==>"+i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadEx1 th1=new ThreadEx1("하나", 300);
		ThreadEx1 th2=new ThreadEx1("둘", 300);
		ThreadEx1 th3=new ThreadEx1("셋", 300);
		
		//run메서드 호출
		th1.run();
		th2.run();
		th3.run();
		
	}

}
