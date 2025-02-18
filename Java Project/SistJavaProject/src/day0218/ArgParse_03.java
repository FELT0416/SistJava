package day0218;

public class ArgParse_03 {


    public static void main(String[] a) {

        String name = a[0];

        int kor=Integer.parseInt(a[1]);
        int eng=Integer.parseInt(a[2]);
        int mat=Integer.parseInt(a[3]);

        System.out.println("내이름은 "+name);
        System.out.println("국어 점수는 " +kor);
        System.out.println("영어 점수는 " +eng);
        System.out.println("수학 점수는 " +mat);
        System.out.println("세과목의 합계는 ="+(kor+eng+mat)+"점 입니다");


    }



}
