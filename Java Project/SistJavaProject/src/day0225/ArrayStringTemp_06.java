package day0225;

public class ArrayStringTemp_06 {

    public static void main(String[] args) {

        String [] stunames = {"공찬혁", "김민규", "박용희", "유혜지", "원주희", "조태민", "한승윤"};
        System.out.println("정렬전 출력");
        for (int i = 0; i < stunames.length; i++) {
            System.out.println(stunames[i]);
        }


        for (int i = 0; i < stunames.length; i++) {

            for (int j = i; j < stunames.length; j++) {
                if (stunames[i].compareTo(stunames[j])>0) {
                    String temp = stunames[i];
                    stunames[i] = stunames[j];
                    stunames[j] = temp;
                }
            }
        }

    }}
