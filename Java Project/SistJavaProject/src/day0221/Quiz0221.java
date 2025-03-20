package day0221;

import java.util.Scanner;

public class Quiz0221 {
    public static void main(String[] args) {

    }

    public static void quiz1(){
        //5개의 숫자를 양수 음수 상관없이 입력한 후 각각 양수의 갯수와 음수의 갯수 구하기

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 5개 입력하세요: ");

        int posc = 0;
        int negc = 0;
        for(int i = 1; i <= 5; i++){

            System.out.println(i+":");
            int a = sc.nextInt();
            if (a>0){
                posc+=1;
            }
            else if (a<0){
                negc+=1;
            }
        }
        System.out.println("양수 갯수: "+ posc+ "개");
        System.out.println("음수 갯수: "+ negc+"개");
    }


    public static void quiz2(){

        //나이를 반복해서 입력받는다 0이되면 빠져나와 출력
        //나이가 50 이상이면 a 변수 증가
        //나이가 30 이상이면 b 변수 증가
        // 나머지는 c 변수 증가

        int a=0, b=0, c=0;

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("나이를 입력하세요(0이면 종료): ");
            int test = sc.nextInt();
            if (test == 0){
                break;
            }
            else if (test >=50){
                a+=1;
            }
            else if (test >=30){
                b+=1;
            }
            else{
                c+=1;
            }
        }
        System.out.println("50세 이상: "+a+"명");
        System.out.println("30세 이상: "+b+"명");
        System.out.println("그 이외: "+c+"명");



    }




}
