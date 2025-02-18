package day0218;

public class DataType_05 {

    public static void main(String[] args) {

        boolean flag =false;
        
        char ch='가';
        
        byte a=-128; // 1바이트 -128-127
        short b= 32000; //16비트
        int c=670000; //32비트
        long num = 1001; // 64비트
        
        double d =4251.12587;// 64비트
        float f = 3.124587f; // 32비트 뒤에 f 붙이기

        System.out.println("flag="+flag);
        System.out.println("not flag="+!flag);
        System.out.println("ch="+ch);
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c="+c);
        System.out.println("num="+num);
        System.out.println("d="+d);
        System.out.println("f="+f);
        // 10자리중 소수점 2자리
        System.out.printf("d=%10.2f\n",d);
        System.out.printf("d=%.1f\n",f);
    }
}
