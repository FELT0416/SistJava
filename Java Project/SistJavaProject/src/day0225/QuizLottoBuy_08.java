package day0225;

import java.util.Scanner;

public class QuizLottoBuy_08 {
    public static void main(String[] args) {

        int [] lotto = new int [6];

        Scanner sc = new Scanner(System.in);
        System.out.println("로또 몇장 드릴까요?");
        int rep = sc.nextInt();

        for (int n=1; n<=rep; n++) {

            for (int i = 0; i < lotto.length; i++) {

                int temp = (int)(Math.random()*45+1);
                boolean isDup = false;

                for (int j = 0; j < i; j++) {
                    if(temp == lotto[j]) {
                        i-=1;
                        isDup = true;
                        break;
                    }
                }

                if(!isDup) {
                    lotto[i] = temp;
                }


            }

            for (int i = 0; i < lotto.length; i++) { // 정렬
                for (int j = i+1; j < lotto.length; j++) {
                    if (lotto[i] > lotto[j]) {
                        int temp = lotto[i];
                        lotto[i] = lotto[j];
                        lotto[j] = temp;

                    }
                }
            }
            System.out.println(n+"회: "+lotto[0]+"\t"+lotto[1]+"\t"+lotto[2]+"\t"+lotto[3]+"\t"+lotto[4]+"\t"+lotto[5]);

        }




    }
}
