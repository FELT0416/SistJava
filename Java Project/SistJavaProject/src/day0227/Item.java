package day0227;

public class Item {

    static int count=0;
    static String store;
    private int counter;
    private String name;
    private int amount;
    private int price;


    public Item(String names, int amounts, int prices) {
        count+=1;
        counter=count;
        name =names;
        amount=amounts;
        price=prices;
    }

    public int getAmount() {
        return amount;
    }
    public int getCounter() {
        return counter;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }



}
