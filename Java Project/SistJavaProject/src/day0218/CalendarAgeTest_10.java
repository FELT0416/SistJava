package day0218;

import java.util.Calendar;

public class CalendarAgeTest_10 {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();

        String name =args[0];
        //String age =args[1];
        int myBirthYear=Integer.parseInt(args[1]);
        //현재년도
        int calYear=cal.get(cal.YEAR);

        int myAge=calYear-myBirthYear;

        System.out.println("이름: "+name);
        System.out.println("태어난 연도:"+myBirthYear+"년생");
        System.out.println("나이: "+myAge+"세");



    }
}
