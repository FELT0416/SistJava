package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2FileException {

	//score1.txt 의 총갯수구하고 총점,평균구하기
	
	public static void scoreRead()
	{
		String fileName="C:\\sist0217\\work\\score1.txt";
		FileReader fr=null;
		BufferedReader br=null;
		int cnt=0; //갯수
		int total=0; //총점
		double avg=0; //평균
		
		//파일읽기
		try {
			fr=new FileReader(fileName);
			System.out.println("파일정상적으로 열림!!");
			
			br=new BufferedReader(fr);
			
			while(true)
			{
				String s=br.readLine();
				
				if(s==null)
					break;
				
				//문자열점수를 int로 변환하여 합계와 갯수구하기
				cnt++; //읽은갯수
				total+=Integer.parseInt(s);
				
			}
			
			//평균구하기
			avg=(double)total/cnt;
			
			System.out.println("총갯수: "+cnt);
			System.out.println("총점: "+total);
			System.out.printf("평균: %.2f\n ",avg);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		scoreRead();
		System.out.println("***정상종료***");
	}

}
