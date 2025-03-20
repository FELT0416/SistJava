package day0221;

import java.util.Scanner;

public class BreakContinueTest_01 {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        int sum=0;
        while(true){
            System.out.println("점수를 입력하세요:");
            int score=sc.nextInt();

            if(score==0){
                break;
            }

            if(score<=0 || score>=100){
                continue;
            }
            sum+=score;
        }
        System.out.println("총 합계:"+sum);

    }
}
