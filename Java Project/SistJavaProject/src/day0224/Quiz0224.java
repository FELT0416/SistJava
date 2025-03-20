package day0224;

import java.util.Arrays;

public class Quiz0224 {
    public static void main(String[] args) {

        String[] name = {"현승훈", "이우형","박참배","최태림"};
        int[] java = {90,77,88,54};
        int[] oracle = {89,56,79,98};
        int[] spring = {100,89, 99, 79};
        int[] tot = new int[4];
        double [] avg = new double[4];
        int [] rank = new int[4];
        int [] test = new int[4];

        for (int i =0; i<tot.length; i++){
            tot[i] = java[i] + oracle[i] + spring[i];
            avg[i] = (double)tot[i]/3;
            test[i] = java[i] + oracle[i] + spring[i];



        }
        System.out.println("번호 이름 자바 오라클 스프링 총점 평균 등수");


        for (int i =0; i<tot.length; i++){
            Arrays.sort(test);
            System.out.println(test[i]+ "\t" + tot[i]);
            for (int j=0; j<4; j++){

                if(test[i] == tot[j])
                    rank[j] = 4-i;


            }
        }

        for (int i =0; i<tot.length; i++){

           System.out.println((i+1)+"\t"+name[i]+"\t"+java[i]+"\t"+oracle[i]+"\t"+spring[i]+"\t"+tot[i]+"\t"+avg[i]+"\t"+(rank[i]));

        }






    }
}
