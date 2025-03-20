package day0221;

import java.util.Scanner;

public class GuguScan_07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("원하는 단을 입력하세요(0=종료): ");
            int a = sc.nextInt();

            if(a==0){
                break;
            }


            for (int i = 1; i <= 9; i++) {
                System.out.println(a+"*"+i+"="+i*a);
            }
        }

    }
}
