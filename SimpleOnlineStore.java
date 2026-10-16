import java.util.Scanner;
public class SimpleOnlineStore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] items = {"Laptop", "Phone", "Headphones"};
        double[] prices = {800.0, 500.0, 100.0};
        int[] stock = {2, 0, 5};

        double totalBill = 0;
        int itemCounter = 0;
        boolean shopping = true;

        while (shopping) {

            System.out.println("\n--- ONLINE STORE ---");
            System.out.println("1. Browse & Add to Cart");
            System.out.println("2. Checkout & Bill");
            System.out.println("3. Track Order");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- AVAILABLE ITEMS ---");

                    for (int i = 0; i < items.length; i++) {
                        System.out.println((i + 1) + ". " + items[i]
                                + " - $" + prices[i]
                                + " (Stock: " + stock[i] + ")");
                    }

                    System.out.print("Select item number to add: ");
                    int itemIndex = scanner.nextInt() - 1;

                    if (itemIndex >= 0 && itemIndex < items.length) {

                        if (stock[itemIndex] > 0) {
                            stock[itemIndex]--;
                            totalBill += prices[itemIndex];
                            itemCounter++;

                            System.out.println(items[itemIndex]
                                    + " added to cart!");
                        } else {
                            System.out.println("Sorry, "
                                    + items[itemIndex]
                                    + " is OUT OF STOCK!");
                        }

                    } else {
                        System.out.println("Invalid selection!");
                    }
                    break;

                case 2:
                    if (itemCounter == 0) {
                        System.out.println("Your cart is empty!");
                    } else {
                        System.out.println("\n--- CHECKOUT ---");
                        System.out.println("Items in cart: " + itemCounter);
                        System.out.println("Total Bill Amount: $" + totalBill);

                        System.out.print("Pay now? (1 for Yes, 0 for No): ");
                        int pay = scanner.nextInt();

                        if (pay == 1) {
                            System.out.println(
                                    "Payment Successful! Order placed.");

                            totalBill = 0;
                            itemCounter = 0;

                        } else {
                            System.out.println("Payment cancelled.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- ORDER TRACKING ---");
                    System.out.println(
                            "Status: Processing -> Dispatched -> Out for Delivery");
                    break;

                case 4:
                    shopping = false;
                    System.out.println("Thank you for shopping with us!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}