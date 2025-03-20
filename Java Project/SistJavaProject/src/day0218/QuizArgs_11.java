package day0218;

public class QuizArgs_11 {
    public static void main(String[] args) {

        String sangname=args[0];
        int price = Integer.parseInt(args[1]);
        int amount = Integer.parseInt(args[2]);
        int totPrice = price * amount;

        System.out.println("상품명: "+sangname);
        System.out.println("수량: "+amount+"개");
        System.out.println("가격: "+price+"원");
        System.out.println("총금액: "+totPrice+"원");
    }
}
