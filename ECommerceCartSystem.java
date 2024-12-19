import java.util.ArrayList; // Import ArrayList for dynamic list
import java.util.Scanner; // Import Scanner for user input

class Product {
    String name;
    double price;

    // Constructor to initialize the product
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method to display product details
    public void displayProduct() {
        System.out.println("Product: " + name + " | Price: $" + price);
    }
}

class ShoppingCart {
    ArrayList<Product> cart = new ArrayList<>(); // List to store products

    // Add a product to the cart
    public void addProduct(Product product) {
        cart.add(product);
    }

    // Display all products in the cart
    public void displayCart() {
        double total = 0;
        System.out.println("\n--- Shopping Cart ---");
        for (Product product : cart) {
            product.displayProduct();
            total += product.price;
        }
        System.out.println("Total: $" + total);
    }

    // Calculate the total with tax (10% tax rate)
    public void calculateTotalWithTax() {
        double total = 0;
        for (Product product : cart) {
            total += product.price;
        }
        double tax = total * 0.10; // 10% tax
        System.out.println("Total after tax (10%): $" + (total + tax));
    }
}

public class ECommerceCartSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list of available products
        Product product1 = new Product("Laptop", 800.00);
        Product product2 = new Product("Smartphone", 500.00);
        Product product3 = new Product("Headphones", 100.00);
        Product product4 = new Product("Tablet", 300.00);

        // Create a shopping cart instance
        ShoppingCart cart = new ShoppingCart();

        // Menu loop
        while (true) {
            System.out.println("\n--- E-Commerce Shopping Cart ---");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // View available products
                    System.out.println("\n--- Available Products ---");
                    product1.displayProduct();
                    product2.displayProduct();
                    product3.displayProduct();
                    product4.displayProduct();
                    break;

                case 2: // Add product to cart
                    System.out.print("Enter product number to add to cart (1-4): ");
                    int productChoice = scanner.nextInt();
                    switch (productChoice) {
                        case 1:
                            cart.addProduct(product1);
                            System.out.println("Laptop added to cart!");
                            break;
                        case 2:
                            cart.addProduct(product2);
                            System.out.println("Smartphone added to cart!");
                            break;
                        case 3:
                            cart.addProduct(product3);
                            System.out.println("Headphones added to cart!");
                            break;
                        case 4:
                            cart.addProduct(product4);
                            System.out.println("Tablet added to cart!");
                            break;
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                    break;

                case 3: // View cart
                    cart.displayCart();
                    break;

                case 4: // Checkout
                    cart.calculateTotalWithTax();
                    break;

                case 5: // Exit
                    System.out.println("Thank you for shopping with us!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
