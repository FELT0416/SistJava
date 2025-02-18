package day0218;

import java.util.Calendar;

public class CalendarTest_09 {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();

        System.out.println("지금은"+cal.get(Calendar.YEAR));
        System.out.println("지금은"+cal.get((Calendar.MONTH)+1)+"월 입니다.");
        System.out.println("지금은"+cal.get(Calendar.DAY_OF_MONTH)+"일 입니다.");
        System.out.println("지금은"+cal.get(cal.DATE)+"일 입니다.");
        System.out.println("지금은"+cal.get(cal.HOUR_OF_DAY)+"시"+cal.get(cal.MINUTE)+"분 입니다.");
    }
}
