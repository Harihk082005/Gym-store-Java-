import java.util.*;

public class Order {
    private List<Equipment> cart = new ArrayList<>();
    private double total = 0;

    public void addToCart(Equipment e) {
        cart.add(e);
        total += e.getPrice();
        System.out.println(e.getName() + " added to cart.");
    }

    public void viewBill() {
        System.out.println("\n--- Your Bill ---");
        for (Equipment e : cart) {
            System.out.println(e);
        }
        System.out.println("Total Amount: ₹" + total);
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }
}
