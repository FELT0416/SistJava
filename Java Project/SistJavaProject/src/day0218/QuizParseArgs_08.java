package day0218;

public class QuizParseArgs_08 {
    public static void main(String[] args) {
        // 메인 파라메타 값으로 3과목의 점수를 읽어서 총점과 평균(소수점2자리)을 출력하시오
        //3과목은 Java, Oracle, Html 총점 tot 평균 arg

        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int c=Integer.parseInt(args[2]);

        int sum = a+b+c;
        double avg = (double)sum/3;

        System.out.printf("총점: %d\n평균: %.2fCc",sum,avg);




    }
}
