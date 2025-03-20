package day0305;

import java.util.StringTokenizer;

public class Ex16StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String msg="red:pink:yellow:black:white";
		String msg2="red,pink,yellow,black,white";
		
		//|로 분리해서 출력
		String [] arr=msg.split(":");
		for(String a:arr)
			System.out.println(a);
		
		System.out.println("StringToknizer로 분리");
		StringTokenizer st=new StringTokenizer(msg, ":");
		System.out.println("분리할 총 토큰수: "+st.countTokens());
		
		//countTokens()는 토큰을 읽을때마다 갯수가 줄어든다
		//방법1
		int count=st.countTokens();
		for(int i=0;i<count;i++)
		{
			System.out.println(st.nextToken());
		}
		System.out.println("--------------------------");
		//방법2
		StringTokenizer st2=new StringTokenizer(msg2, ",");
		while(st2.hasMoreElements())
		{
			System.out.println(st2.nextToken());
		}
		
	}

}
