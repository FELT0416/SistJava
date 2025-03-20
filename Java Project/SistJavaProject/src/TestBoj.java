    import java.util.Scanner;

    public class TestBoj {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] words = input.split(" ");
            int [] inputs = new int[3];
            for (int i = 0; i < 3; i++) {
                inputs[i] = Integer.parseInt(words[i]);
            }

            int ans;
            ans = (inputs[0]+1)*(inputs[1]+1)/(inputs[2]+1);
            ans -= 1;



            System.out.println(ans);

        }
    }
