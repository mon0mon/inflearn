package xyz.mon0mon.core.singleton;

public class StatefulService {
    // 상태를 유지하는 필드
    private int price;

    public void order1(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int order2(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

    public int getPrice() {
        return price;
    }
}
