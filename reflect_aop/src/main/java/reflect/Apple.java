package reflect;

public class Apple {
    private int price;

    public void setPrice(int price) {
        System.out.println(price);
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public static void main(String[] args) {
        System.out.println("apple");
    }
}
