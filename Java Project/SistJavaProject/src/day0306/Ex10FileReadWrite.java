package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex10FileReadWrite {

	static final String FILENAME="C:\\sist0217\\work\\sungjuk.txt";
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	Scanner sc=new Scanner(System.in);
	
	//추가/전체출력 선택하는 메서드
	public int getMenu()
	{
		int num=0;
		System.out.println("1.추가   2.전체출력  9.종료");
		num=Integer.parseInt(sc.nextLine());
		
		return num;
	}
	
	//정보입력해서 파일에 저장
	public void sungjukInput()
	{
		//이름과 점수입력
		System.out.println("학생명을 입력하시오");
		String name=sc.nextLine();
		System.out.println("점수를 입력하시오");
		int score=Integer.parseInt(sc.nextLine());
		
		//파일에 저장
		try {
			fw=new FileWriter(FILENAME,true);
			
			//입력한 내용파일에 저장
			fw.write(name+"\n");
			fw.write(score+"\n");
			
			System.out.println("**학생정보가 저장됨**");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//파일읽기
	public void sungjukOutput()
	{
		//제목부터 출력
		System.out.println("\t**학생 정보**");
		System.out.println("번호\t학생명\t점수\t학점");
		System.out.println("==================================");
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			int num=0;
			while(true)
			{
				String name=br.readLine();
				if(name==null)
					break;
				int score=Integer.parseInt(br.readLine());
				char grade=getGrade(score);
				
				
				System.out.println(++num+"\t"+name+"\t"+score+"\t"+grade);
				
			}
			
			System.out.println("***출력끝***");
					
			
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
	
	//학점..점수에 대한 학점 반환메서드
	public char getGrade(int score)
	{
		char grade=switch(score/10) {
			case 10,9->'A';
			case 8->'B';
			case 7->'C';
			case 6->'D';
			default->'F';
		};
		
		return grade;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Ex10FileReadWrite ex=new Ex10FileReadWrite();
         
         while(true) 
         {
        	 
        	 int num=ex.getMenu();
        	 
        	 if(num==1)
        	 {
        		 System.out.println("학생정보입력");
        		 ex.sungjukInput();
        	 }
        	 else if(num==9)
        	 {
        		 System.out.println("프로그램종료");
        		 break;
        	 }else if(num==2)
        	 {
        		 System.out.println("학생정보전체출력");
        		 ex.sungjukOutput();
        	 }
        		 
         }
         
         
	}

}
