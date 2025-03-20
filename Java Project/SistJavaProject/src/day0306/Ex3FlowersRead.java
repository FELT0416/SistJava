package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex3FlowersRead {

	public static void read()
	{
		String fileName="C:\\sist0217\\work\\flowers.txt";
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(fileName);
			br=new BufferedReader(fr);
			
			System.out.println("**꽃말및 가격 정보**");
			System.out.println("꽃이름\t꽃말\t한단가격");
			System.out.println("--------------------------------");
			
			while(true)
			{
				String s=br.readLine();
				
				//종료
				if(s==null)
					break;
				//split으로 분리
				//String [] data=s.split(",");
				//배열갯수만큼 반복해서 출력
				//System.out.println(data[0]+"\t"+data[1]+"\t"+data[2]);
				
				
				//StringTokneizer
				StringTokenizer st=new StringTokenizer(s, ",");
				System.out.println(st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken()+"원" );
				
				
			}
			
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
        read();
	}

}
