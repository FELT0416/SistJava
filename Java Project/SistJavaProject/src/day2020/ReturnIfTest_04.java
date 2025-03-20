package day2020;

import java.util.Scanner;

public class ReturnIfTest_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score;

        System.out.println("점수입력(1~100)");
        score = sc.nextInt();

        if(score<1 ||score> 100){
            System.out.println("점수범위를 잘못 입력했어요");
            return;
        }
        else{
            System.out.println("점수: "+score+"점");
        }



    }
}
