import java.util.Scanner;
import java.util.ArrayList;

public class Product {
    private String name = "";
    private int quantity = 0;
    private ArrayList<Receipt> purchases = new ArrayList<>();
    private ArrayList<Receipt> sales = new ArrayList<>();
    private int quantityLowCount = -1;

    public Product(Scanner _input) {
        // Product's name
        System.out.println();
        System.out.print("Enter the product name: ");
        name = _input.nextLine();
        
        System.out.println();
        
        // Product's purchases/sales
        boolean check = false;
        while (!check) {
            System.out.print("1. Add a purchase receipt  2. Add a sale receipt  3. Finish: ");
            if (!_input.hasNextInt()) {
                System.out.println("Please follow the format.");
                _input.next();
                continue;
            }

            int choice = _input.nextInt();
            _input.nextLine();
            
            switch (choice) {
                case 1:
                    // Add purchase receipt
                    Receipt purchaseReceipt = new Receipt(_input, "Purchase");
                    quantity = purchaseReceipt.updateQuantity();
                    purchases.add(purchaseReceipt);
                    continue;
                case 2:
                    // Add sale receipt
                    Receipt saleReceipt = new Receipt(_input, "Sale");
                    quantity = saleReceipt.updateQuantity();
                    purchases.add(saleReceipt);
                    continue;
                case 3:
                    // Finish inputting the data
                    check = true;
                    break;
                default:
                    // Input not avaliable
                    System.out.println("Invalid input. Please choose one of the avaliable options.");
                    continue;
            }
            System.out.println("End of loop");
        }
        System.out.println("Looping end");

        // Product's Low Stock Setup
        System.out.println();
        System.out.print("Enter an amount to trigger an alert for low stock: ");
        if (!_input.hasNextInt()) {
            System.out.println("Please enter a number.");
            _input.next();
        }
        quantityLowCount = _input.nextInt();
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Scanner _input) {
        System.out.print("Enter the quantity: ");
        if (!_input.hasNextInt()) {
            System.out.println("Please enter a number.");
            _input.next();

        }
        quantity = _input.nextInt();
    }

    public Receipt getPurchase(int _index) {
        return purchases.get(_index);
    }

    public Receipt getSale(int _index) {
        return sales.get(_index);
    }

    public void display() {
        String quantityStr = (quantity > quantityLowCount) ? String.valueOf(quantity) : String.valueOf(quantity) + "*";
        System.out.println(" " + name + " | " + quantityStr + " |");
    }
}