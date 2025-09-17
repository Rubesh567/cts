import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Display product as "Product Name - ₹Price"
    public String toString() {
        return name + ":" + String.format("%.2f", price);
    }
}

class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addToCart(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\nYour Cart:");
        double total = 0;
        for (Product p : items) {
            System.out.println("- " + p);
            total += p.getPrice();
        }
        System.out.println("Total: \u20B9" + String.format("%.2f", total));
    }
}

public class EcommerceCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> store = new ArrayList<>();
        store.add(new Product("ASUS Laptop", 55000));
        store.add(new Product("Sony Headphones", 7999));
        store.add(new Product("Leather Wallet", 999));
        store.add(new Product("Office Chair", 3499));
        store.add(new Product("Atomic Habits Book", 499));

        Cart cart = new Cart();

        while (true) {
            System.out.println("\nAvailable Products:");
            for (int i = 0; i < store.size(); i++) {
                System.out.println((i + 1) + ". " + store.get(i));
            }
            System.out.println("0. Exit and show cart");

            System.out.print("Select a product to add to cart (1-" + store.size() + "): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice >= 1 && choice <= store.size()) {
                cart.addToCart(store.get(choice - 1));
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        cart.showCart();
        scanner.close();
    }
}
