package day2020;

import java.util.Scanner;

public class ReviewIfScan_01 {
    public static void main(String[] args) {
        /*
        이름을 입력하세요
        홍길동
        정보처리기사 3과목의 점수를 입력하세요
        88 77 39
        ==================
        3과목의 평균:
        ==================
        합격조건: 평균이 60점 이상이고 각 과목이 모두 40점 이상이면합격
        ==================
        홍길동님은 불합격입니다.
         */

        Scanner sc=new Scanner(System.in);
        System.out.println("이름을 입력하세요:");
        String name=sc.nextLine();
        System.out.println("정보처리기사 3과목의 점수를 입력하세요:");
        int junga=Integer.parseInt(sc.nextLine());
        int jungb=Integer.parseInt(sc.nextLine());
        int jungc=Integer.parseInt(sc.nextLine());

        double avrg= (double)(junga+jungb+jungc)/3;

        if(avrg>60 && junga>=60 && jungb>=60 && jungc>=60){
            System.out.println(name+"님은 합격입니다");
        }
        else{
            System.out.println(name+"님은 불합격입니다");
        }











    }
}
