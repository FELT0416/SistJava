package day0218;

public class ParseVar_02 {
    public static void main(String[] args) {

        String sul1 = "10";
        String sul2 = "2";

        System.out.println("두 수 더하기: " +(sul1+sul2));

        int s1 =Integer.parseInt(sul1);
        int s2 = Integer.parseInt(sul2);

        System.out.println("두수 더하기: "+(s1+s2));
        System.out.println("두수 빼기: "+(s1-s2));
        System.out.println("두수 곱하기: "+(s1*s2));
        System.out.println("두수 나누기: "+(s1/s2));


    }
}
