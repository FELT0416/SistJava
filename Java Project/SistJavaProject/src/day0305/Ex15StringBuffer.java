package day0305;

public class Ex15StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="Happy";
		//String ->StringBuffer
		StringBuffer sb=new StringBuffer(str);
		
		//인스턴스 변수인경우 변수명만 출력하면 자동으로 toString()호출
		//toString을 갖고있지않는경우 값이아니라 주소가 출력된다
		System.out.println(sb);
		System.out.println(sb.toString());
		
		//String 은 값자체를 변경할수 없지만 StringBuffer는 문자열 편집이 가능하다
		//맨뒤에 추가
		sb.append('A');
		sb.append(100);
		sb.append("SIST");
		System.out.println(sb);
		
		//삭제
		sb.delete(5, 9);//5~8인덱스부분이 제거
		System.out.println(sb); 
		
		//중간삽입
		sb.insert(3, "I Like Java"); //3번 인덱스 앞에 삽입
		System.out.println(sb); 
		
	}

}
