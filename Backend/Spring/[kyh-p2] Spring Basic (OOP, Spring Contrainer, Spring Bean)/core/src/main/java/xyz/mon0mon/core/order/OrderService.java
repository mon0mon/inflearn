package xyz.mon0mon.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
