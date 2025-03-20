package day2020;

public class SubStringTest_06 {
    public static void main(String[] args) {

        String str="나는 지금 쌍용교육센터에서 자바를 공부하고 있어요";

        char ch = str.charAt(6);
        String word1 =str.substring(6);
        String word2 =str.substring(6,12);

        System.out.println(ch);
        System.out.println(word1);
        System.out.println(word2);
        int i =str.length();
        System.out.println("총글자 갯수"+i);

    }
}
