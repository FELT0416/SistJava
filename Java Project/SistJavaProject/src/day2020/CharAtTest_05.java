package day2020;

public class CharAtTest_05 {
    public static void main(String[] args) {
        String jumin = "850754-2260719";

        char seventh = jumin.charAt(7);

        if(seventh == '1')
            System.out.println("남자입니다");
        else if(seventh == '2')
            System.out.println("여자입니다");
        else if(seventh == '3')
            System.out.println("2000년 이후 남자입니다");
        else if(seventh == '4')
            System.out.println("2000년 이후 여자입니다");
        else
            System.out.println("오류입니다.");

    }
}
