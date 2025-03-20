    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int rep = Integer.parseInt(sc.nextLine());
            String [] dict = new String [rep];
            for (int i = 0; i < rep; i++) {
                dict [i] = sc.nextLine().trim();
            }

            Arrays.sort(dict);

            int [] lenDict = new int [rep];


            for (int i = 0; i < dict.length; i++) {
                lenDict[i]=dict[i].length();
            }

            Arrays.sort(lenDict);

            String[] ansDict = new String[rep];

            for (int strind = 0; strind < rep; strind++) {
                String checkStr = dict[strind];
                for (int i = 0; i < rep; i++) {
                    if (checkStr.length() == lenDict[i]) {
                        ansDict[i]=checkStr;
                        lenDict[i]=-1;
                        break;
                    }
                }

            }

            for (int strind = 0; strind < rep; strind++) {
                System.out.println(ansDict[strind]);
            }




        }
    }
