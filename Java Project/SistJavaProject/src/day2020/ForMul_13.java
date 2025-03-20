package day2020;

import java.util.Scanner;

public class ForMul_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하세요");
        int n = Integer.parseInt(sc.nextLine());
        int val=1;
        for (int i = 1; i<=n; i++){
            val= val*i;
        }
        System.out.println(n+"!="+val);



    }
}
