package day0305;

public class Ex9Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("프로그램시작");
		
		try { 
			//예외발생코드
		  int num=5/0;  //정수를 0으로나누면 에러발생
		}catch(ArithmeticException e) {
			//예외를 처리할 코드
			//e.printStackTrace(); //자세한 예외정보출력
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 정상종료!!!");
	}

}
