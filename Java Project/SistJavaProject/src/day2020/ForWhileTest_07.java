package day2020;

public class ForWhileTest_07 {

    public static void main(String[] args) {
        int n=0;

        while(n<10){
            n++;
            System.out.printf("%4d",n);
        }
        while(n<10){
            System.out.printf("%4d",++n);
        }
        System.out.println();

    }}
