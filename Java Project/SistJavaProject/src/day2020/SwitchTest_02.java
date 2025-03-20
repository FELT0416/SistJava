package day2020;

public class SwitchTest_02 {
    public static void main(String[] args) {
        int n = 5;

        switch(n){
            case 1:
                System.out.println("n is 1");
                break;
            case 2:
                System.out.println("n is 2");
                break;
            case 3:
                System.out.println("n is 3");
                break;
            default:
                System.out.println("n은 3보다 크다");
                break;
        }
        char ch = 'B';
        switch (ch){
            case 'A':
                System.out.println("apple");
                break;
            case 'B':
                System.out.println("banana");
                break;
            default:
                System.out.println("다른 과일입니다");
        }



    }

}
