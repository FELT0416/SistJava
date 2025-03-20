package day2020;

import java.util.Scanner;

public class Quiz2020 {

    public static void quiz1(){
        int eventotal=0;
        int oddtotal=0;
        for (int i=1;i<=100;i++){
            if (i%2==0){
                eventotal+=i;
            }
            else{
                oddtotal+=i;
            }
        }
        System.out.println("짝수의 합:"+eventotal);
        System.out.println("홀수의 합:"+oddtotal);
    }

    public static void quiz2(){
        Scanner sc=new Scanner(System.in);
        System.out.println("합계를 더할 숫자를 입력하시오");
        int n=Integer.parseInt(sc.nextLine());
        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=i;
        }
        System.out.println("1부터 "+n+"까지의 합은 "+sum+"입니다.");

    }


    public static void main(String[] args) {
        quiz1();
        quiz2();
    }
}
