package day0305;

public class Ex12ThreadSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("안녕하세요");
		
		
		System.out.println("5초후 작별합시다~~");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("안녕히 가세요~~~");
	}

}
