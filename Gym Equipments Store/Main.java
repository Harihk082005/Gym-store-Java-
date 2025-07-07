import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Order order = new Order(); 

        while (true) {
            System.out.println("\n--- Gym Equipment Buying Website ---");
            System.out.println("1. View Equipment");
            System.out.println("2. Buy Equipment");
            System.out.println("3. View Bill");
            System.out.println("4. Add Equipment (Admin)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    store.displayEquipment();
                    break;

                case 2:
                    store.displayEquipment();
                    System.out.print("Enter equipment number to buy: ");
                    int num = sc.nextInt();
                    Equipment selected = store.getEquipment(num - 1);
                    if (selected != null) {
                        order.addToCart(selected);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    if (order.isEmpty()) {
                        System.out.println("Your cart is empty!");
                    } else {
                        order.viewBill();
                    }
                    break;

                case 4:
                    System.out.print("Enter equipment name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    store.addEquipment(name, price);
                    break;

                case 5:
                    System.out.println("Thank you for visiting our Website!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
