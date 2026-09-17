import java.util.Scanner;
import java.util.ArrayList;

public class Product {
    private String name = "";
    private int quantity = 0;
    private ArrayList<Receipt> purchase = new ArrayList<>();
    private ArrayList<Receipt> sales = new ArrayList<>();
    private int quantityLowCount = -1;

    public Product(Scanner _input) {
        // Product's name
        System.out.print("Enter the product name: ");
        name = _input.nextLine();

        // Product's quantity
        System.out.print("Enter the quantity: ");
        if (!_input.hasNextInt()) {
            System.out.println("Please enter a number.");
            _input.next();

        }
        quantity = _input.nextInt();

        // Product's purchases/sales
        /*System.out.println("Add any purchase and/or sale receipts.");
        System.out.print("1. Add  2. Finish: ");
        while (true) {
            if (!_input.hasNextInt()) {
                System.out.println("Please follow the format.");
                _input.next();
                continue;
            }
            int choice = _input.nextInt();
            
            switch (choice) {
                case 1:
                    // Add receipt
                    inputReceiptInfo(_input);
                    break;
                case 2:
                    // Finish inputting the data
                    break;
            }
            break;
        }*/

        // Product's Low Stock Setup
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

    public void setQuantity(int _value) {
        quantity = _value;
    }

    public Receipt getPurchase(int _index) {
        return purchase.get(_index);
    }

    public Receipt getSale(int _index) {
        return sales.get(_index);
    }

    public void display() {
        String quantityStr = (quantity > quantityLowCount) ? String.valueOf(quantity) : String.valueOf(quantity) + "*";
        System.out.println(" " + name + " | " + quantityStr + " |");
    }
}