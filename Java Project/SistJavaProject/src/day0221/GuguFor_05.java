package day0221;

public class GuguFor_05 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i+"*"+j+"="+i*j);
            }

        }

    gugudan:    for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                    if(j==4)
                        break gugudan;
                System.out.println(i+"*"+j+"="+i*j);
            }

        }




    }
}
