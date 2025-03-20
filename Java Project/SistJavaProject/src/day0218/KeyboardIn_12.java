package day0218;

import java.util.Scanner;

public class KeyboardIn_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //변수선언

        String name, city, job;
        int age;

        System.out.println("입력을 입력해보세요 ==>");
        name=sc.nextLine();
        System.out.println("사는 지역은 어디입니까?==>");
        city=sc.nextLine();
        System.out.println("당신의 나이는 몇살==>");
        //age=sc.nextInt(); 숫자입력후 엔터 누르면 엔터가 버퍼로 저장되어 다음 문장 읽을때 먼저 읽어버리므로
        age=Integer.parseInt(sc.nextLine());
        System.out.println("당신의 직업은==>");
        job=sc.nextLine();

        System.out.println("내이름은"+name+"입니다");
        System.out.println("사는 지역은"+city+"입니다");
        System.out.println("나이는"+age+"세 입니다");
        System.out.println("나의 직업은"+job+"입니다");
    }
}
