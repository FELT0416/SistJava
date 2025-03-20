package day0225;

public class ArrayStringTemp_07 {
    public static void main(String[] args) {

        String [] names ={"유재석", "이효리", "하하", "김영웅"};

        int [] ages ={34, 52, 48, 38};

        System.out.println("정렬전 출력");
        System.out.println("번호\t이름\t나이");
        for(int i=0; i<names.length; i++) {
            System.out.println(i+1+"\t"+names[i]+"\t"+ages[i]);
        }

        System.out.println();


        for (int i = 0; i < names.length; i++) {
            for(int j = i; j < ages.length; j++) {
                if(names[i].compareTo(names[j]) > 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;

                }


            }
        }

        System.out.println("정렬후 출력");
        for(int i=0; i<names.length; i++) {
            System.out.println(i+1+"\t"+names[i]+"\t"+ages[i]);
        }

    }
}
