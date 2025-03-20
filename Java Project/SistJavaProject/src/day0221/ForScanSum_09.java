package day0221;

import java.util.Scanner;

public class ForScanSum_09 {
    public static void main(String[] args) {
        // 총 5개의 점수를 입력받아서 1~100이 아닐 경우 다시입력받을것

        Scanner sc = new Scanner(System.in);

        int sum=0;

        for(int i = 1; i <= 5;){
            System.out.println(i+"번 점수:");
            int score = sc.nextInt();

            if(score<0 || score>100){
                System.out.println("잘못 입력했어요");
            }
            sum+=score;
            i+=1;
        }
        System.out.println("총점: "+sum);
        System.out.printf("평균 %.2f", (double)sum/5);

    }
}
