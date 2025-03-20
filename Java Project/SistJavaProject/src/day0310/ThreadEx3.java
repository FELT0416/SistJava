package day0310;

public class ThreadEx3 implements Runnable{

	String name;
	int num;
	
	public ThreadEx3(String name,int num) {
		this.name=name;
		this.num=num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //Runnable 인터페이스 구현한 클래스 생성
		ThreadEx3 ex1=new ThreadEx3("하나", 300);
		ThreadEx3 ex2=new ThreadEx3("둘", 300);
		ThreadEx3 ex3=new ThreadEx3("셋", 300);
		
		//Thread생성
		Thread th1=new Thread(ex1);
		Thread th2=new Thread(ex2);
		Thread th3=new Thread(ex3);
		
		//run메서드 호출_start
		th1.start();
		th2.start();
		th3.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	    for(int i=1;i<=num;i++)
	    {
	    	System.out.println(name+"==>"+i);
	    	
	    	try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}

}
