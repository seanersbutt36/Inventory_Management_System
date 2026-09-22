import java.util.Scanner;
import java.util.ArrayList;

public class Product {
    private String name = "";
    private int quantity = 0;
    private ArrayList<Receipt> receipts = new ArrayList<>();
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
            System.out.print("1. Add a purchase receipt  2. Add a sale receipt  3. Finish");
            System.out.print("Enter an option: ");
            if (!_input.hasNextInt()) {
                System.out.println("Please enter a number.");
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
                    receipts.add(purchaseReceipt);
                    continue;
                case 2:
                    // Add sale receipt
                    Receipt saleReceipt = new Receipt(_input, "Sale");
                    quantity = saleReceipt.updateQuantity();
                    receipts.add(saleReceipt);
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

    public void menu(Scanner _input) {
        while (true) {
            for (int i = 0; i < receipts.size(); i++) {
                System.out.print((i + 1) + ". ");
                receipts.get(i).display();
            }

            System.out.println("1. Modify name  2. Edit a sales receipt  3. Delete a receipt  4. Cancel");
            System.out.print("Enter an option: ");

            int choice = _input.nextInt();
            _input.nextLine();

            switch (choice) {
                case 1:
                    // Change the name of the product
                    setName(_input.nextLine());
                    continue;
                case 2:
                    // Edit a receipt
                    int editReceipt = _input.nextInt();

                    if (!_input.hasNextInt()) {
                        System.out.println("Please enter an number.");
                        _input.next();
                    } else if (editReceipt > 0 && editReceipt < receipts.size()) {
                        System.out.println("Please enter the number of the receipt that is listed.");
                    } else {
                        receipts.get(editReceipt - 1).menu(_input);
                        System.out.println();
                    }

                    continue;
                case 3:
                    // Delete a receipt
                    int deleteReceipt = _input.nextInt();

                    if (!_input.hasNextInt()) {
                        System.out.println("Please enter an number.");
                        _input.next();
                    } else if (deleteReceipt > 0 && deleteReceipt < receipts.size()) {
                        System.out.println("Please enter the number of the receipt that is listed.");
                    } else {
                        receipts.remove(deleteReceipt - 1);
                        System.out.println();
                    }

                    continue;
                case 4:
                    // Exit the game
                    break;
            }
        }
    }

    public void setName(String _value) {
        name = _value;
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
    
    public void display() {
        String quantityStr = (quantity > quantityLowCount) ? String.valueOf(quantity) : String.valueOf(quantity) + "*";
        System.out.println(" " + name + " | " + quantityStr + " |");
    }
}