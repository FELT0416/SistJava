package day0221;

import java.util.Scanner;

public class WhileSumAvg_02 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int su;
        int sum=0;
        double avg=0;
        int cnt=0;

        while(true){
            System.out.println("숫자를 입력하세요(종료:0)");
            su=sc.nextInt();

            if(su==0){
                System.out.println("종료합니다");
                break;
            }

            sum+=su;
            cnt++;



        }
        avg=(double) sum/cnt;
        System.out.println("총 입력한 횟수 "+cnt);
        System.out.println("입력한 수의 합 "+sum);
        System.out.println("입력한 수의 평균 "+avg);

    }
}
