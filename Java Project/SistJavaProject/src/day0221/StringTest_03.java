package day0221;

import java.util.Scanner;

public class StringTest_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int cnt=0;
        while(true){

            System.out.println("이름을 입력해주세요(종료=종료)");
            name = sc.nextLine();

            if(name.equals("끝")){
                break;
            }

            if(name.startsWith("김")){
                cnt++;
            }
        }

    }
}
