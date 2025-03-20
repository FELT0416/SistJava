package day0221;

import java.util.Scanner;

public class ForNumScan {
    public static void main(String[] args) {
        //점수를 3번 반복 입력해서 합계를 구하시오(1~100)
        //해당 범위를 벗어나면 잘못입력하였습니다. 반복문 진행하되 한번

        Scanner sc = new Scanner(System.in);
        int sum=0;
        for(int i = 1; i <= 3;){
            System.out.println(i+"번째 점수를 입력하세요");
            int n=sc.nextInt();
            if(n>=0 && n<=100){
                i+=1;
                sum+=n;
            }
            else{
                System.out.println("잘못 입력하였습니다");
            }
        }
        System.out.println("총 합계는 "+sum+"입니다.");


    }
}
