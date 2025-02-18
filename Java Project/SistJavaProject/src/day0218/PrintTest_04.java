package day0218;

public class PrintTest_04 {
    public static void main(String[] args) {
        //%d = 10진수정수 %f:10진수 실수 %s 문자열 %c 문자

        int num1=10,num2=20;
        int num3=num1+num2;
        System.out.println(num1+"+"+num2+"="+num3);
        System.out.printf("num1의 값은 %d, num2의 값은 %d, num3의 값은 %d입니다",num1,num2,num3);
        System.out.println();
        System.out.printf("%d+%d=%d",num1,num2,num3);
        System.out.println();


        String name = "김사랑";
        int age=25;

        System.out.printf("안녕하세요 제 이름은 %s입니다. \n나이는 %d세 입니다",name,age);


    }
}
