package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileException {

	public static void read()
	{
		//경로표시 /, \\
		String fileName="C:\\sist0217\\work\\memo1.txt";
		BufferedReader br=null;
		FileReader fr=null;
		
		//읽기위해서 파일열기
		try {
			fr=new FileReader(fileName);
			System.out.println("파일을 열었어요!!!");
			
			br=new BufferedReader(fr);
			//여러줄을 읽어야 하므로 while
			while(true)
			{
				//메모장에서 내용을 한줄씩 읽는다
				String s=br.readLine();
				
				//마지막줄일경우 null값을 읽는다,null값일경우 빠져나간다
				if(s==null)
					break;
				
				
				System.out.println(s);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			//close할땐 open반대순,생성의 역순으로 닫는다
			try {
				br.close();
				fr.close();
				
				System.out.println("**파일에 대한 자원 모두 닫았습니다!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		read();
		System.out.println("**정상종료***");
	}

}
