package day2020;

import java.util.Scanner;

public class EqualTest_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;

        System.out.println("영어 단어 입력하세요");
        System.out.println("ex) cat, dog, angel, rose");
        word = sc.nextLine();

        System.out.println("입력한 문자열: " + word);
        // if(word=="cat)
        if(word.equals("cat"))
            System.out.println("***고양이***");
        else if(word.equalsIgnoreCase("dog"))
            System.out.println("***강아지***");
        else if(word.equalsIgnoreCase("angel"))
            System.out.println("***천사***");
        else if(word.equalsIgnoreCase("rose"))
            System.out.println("***장미***");
        else
            System.out.println("***단어가 등록되지 않았습니다***");



    }
}
