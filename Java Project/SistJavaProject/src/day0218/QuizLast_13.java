package day0218;

import java.util.Calendar;
import java.util.Scanner;

public class QuizLast_13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("당신의 이름은?");
        String name=sc.nextLine();
        System.out.println("당신의 출생년도는");
        int year=Integer.parseInt(sc.nextLine());

        Calendar cal=Calendar.getInstance();
        int curYear=cal.get(Calendar.YEAR);

        int age = curYear-year;

        System.out.println(name+"님은 "+year+"년생이며 "+age+"세 입니다");


    }
}
