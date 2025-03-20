package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex7SawonRead {

	//번호   사원명  기본급  가족수   초과근무시간    가족수당   시간수당    총급여
	//가족수: 가족수 인원당 3만원
	//시간수당: 시간당 15000원
	public static void sawonRead()
	{
		String fileName="C:\\sist0217\\work\\sawon.txt";
		FileReader fr=null;
		BufferedReader br=null;
		
		int num=1;
		
		try {
			fr=new FileReader(fileName);
			br=new BufferedReader(fr);
			
			System.out.println();
			System.out.println("\t\t**사원급여현황**");
			System.out.println("번호\t사원명\t기본급\t가족수\t초과시간수\t가족수당\t시간수당\t총급여");
			System.out.println("--------------------------------------------------------");
			
			while(true)
			{
				String s=br.readLine();
				
				if(s==null)
					break;
				
				StringTokenizer st=new StringTokenizer(s, ",");
				
				String name=st.nextToken();
				int gibon=Integer.parseInt(st.nextToken());
				int famsu=Integer.parseInt(st.nextToken());
				int timesu=Integer.parseInt(st.nextToken());
				
				int famSudang=famsu*30000;
				int timeSudang=timesu*15000;
				int totalPay=gibon+famSudang+timeSudang;
				
				System.out.println(num++ +"\t"+name+"\t"+gibon+"원\t"+famsu+"\t"+timesu+"\t"
							+famSudang+"원\t"+timeSudang+"원\t"+totalPay+"원");
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
			sawonRead();
	}

}
