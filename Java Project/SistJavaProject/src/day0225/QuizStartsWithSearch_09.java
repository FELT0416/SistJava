package day0225;

import java.util.Scanner;

public class QuizStartsWithSearch_09 {
    public static void main(String[] args) {

        String [] celeb = {"공유", "신민아","이정재","손흥민","이강인","이효리","이진"};
        int csnt;
        Scanner sc = new Scanner(System.in);
        String search ="";

        while (!search.equals("종료")) {
            System.out.println("검색할 성을 입력해주세요(종료 입력시 프로그램 종료)");
            search = sc.nextLine();


            int count = 0;
            for (int i = 0; i < celeb.length; i++) {

                if (celeb[i].startsWith(search)) {
                    System.out.println(i + ":" + celeb[i]);
                    count += 1;
                }


            }
            if (search.equals("종료")){
                System.out.println("검색을 종료합니다");
                break;
            }
            if (count == 0)
                System.out.println(search + "씨 성을 가진 연예인은 없습니다");
            else
                System.out.println("\t 총 " + count + "명 검색");


        }
    }
}
