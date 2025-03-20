package day0224;

import java.util.Scanner;

public class ArrayScanSum_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] a= new int[5];

        for (int i = 0; i < a.length; i++) {
            System.out.println((i+1)+"번째 값: ");
            a[i] = sc.nextInt();
        }

        for (int n: a){
            System.out.println(n);

        }


    }


}
