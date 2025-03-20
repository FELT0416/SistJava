package day0226;

import org.w3c.dom.ls.LSOutput;

public class SelectionSort_01 {
    public static void main(String[] args) {


        int[] data = {10, 2, 8, 1, 3, 6, 9, 4};
        System.out.println("일반출력");

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {

            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }


            }


        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }





    }
}
