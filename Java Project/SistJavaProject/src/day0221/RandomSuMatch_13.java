package day0221;

import java.util.Scanner;

public class RandomSuMatch_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rnd=(int)(Math.random()*10)+1;
        int su;
        while (true){
            System.out.println("랜덤수를 맞추세요");
            su=sc.nextInt();
            if (su>=rnd){
                System.out.println(su+"보다 작습니다");
            }
            else if(su<rnd){
                System.out.println(su+"보다 큽니다");
            }
            else{
                System.out.println("맞았습니다 정답은 "+rnd+"입니다");
                break;
            }

        }

        

    }
}
