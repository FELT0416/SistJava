package day0226;

import java.util.Scanner;

public class BingoGame_07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("난수 생성");



        int [][] bingo = new int[3][3];
        for (int i =0; i <3; i++){
            for(int j =0; j <3; j++) {
                bingo[i][j] = (int) (Math.random() * 3) + 1;

            }
        }

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                System.out.print(bingo[i][j] + " ");
                System.out.println();
            }
        }





    }
}
