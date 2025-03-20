package day0225;

public class RndSortLotto_05 {
    public static void main(String[] args) {
        int [] lotto = new int[6];

        for (int i = 0; i < lotto.length; i++) {
            lotto[i]=(int)(Math.random()*45+1);
            System.out.println(lotto[i]);
        }
        System.out.println("=======================");


        for (int i = 0; i < lotto.length; i++) {
            for (int j = i; j < lotto.length; j++) {

                if (lotto[i] > lotto[j]) {
                    int temp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = temp;
                }

            }


        }

        for (int i = 0; i < lotto.length; i++) {
            System.out.println(lotto[i]);
        }





    }
}
