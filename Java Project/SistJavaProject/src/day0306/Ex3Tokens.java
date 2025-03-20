package day0306;

import java.util.StringTokenizer;

public class Ex3Tokens {

	public static void main(String[] args) {
		// 문자열을 특정문자로 분리하는 방법
		
		String str="장미,백합,튤립,후리지아,수국,안개꽃";
		
		System.out.println("String의 객체를 split을 이용한 분리");
		String [] flowers=str.split(",");
		System.out.println("총 "+flowers.length+"개");
		//for
		for(int i=0;i<flowers.length;i++)
		{
			System.out.println(i+":"+flowers[i]);
		}
		
		
		System.out.println("String의 객체를 StringTokenizer을 이용한 분리");
		StringTokenizer st=new StringTokenizer(str,",");
		System.out.println("총토큰수: "+st.countTokens());
		
		while(st.hasMoreTokens()) //다음토큰이 있다면 true,없으면 false반환
		{
			System.out.println(st.nextToken()); //다음토큰얻기
		}

	}

}
