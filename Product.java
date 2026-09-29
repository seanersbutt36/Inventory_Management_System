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
        System.out.print("Enter the product's name: ");
        name = _input.nextLine();
        
        System.out.println();
        
        // Product's purchases/sales
        boolean check = false;
        while (!check) {
            System.out.println("1. Add a purchase receipt  2. Add a sale receipt  3. Finish");
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
                    quantity += purchaseReceipt.getQuantity();
                    receipts.add(purchaseReceipt);
                    continue;
                case 2:
                    // Add sale receipt
                    Receipt saleReceipt = new Receipt(_input, "Sale");
                    quantity += saleReceipt.getQuantity();
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
        }

        // Product's Low Stock Setup
        System.out.println();
        System.out.println("Enter an amount to trigger an alert for low stock: ");
        if (!_input.hasNextInt()) {
            System.out.println("Please enter a number.");
            _input.next();
        }
        quantityLowCount = _input.nextInt();
    }

    public void menu(Scanner _input) {
        boolean exit = false;

        while (!exit) {
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
                    System.out.print("Enter the product's new name: ");
                    setName(_input.nextLine());
                    System.out.println();
                    continue;
                case 2:
                    // Edit a receipt
                    System.out.print("Pick a receipt to edit: ");
                    if (!_input.hasNextInt()) {
                        System.out.println("Please enter a number.");
                        _input.next();
                    }
                    
                    int editReceipt = _input.nextInt();
                    _input.nextLine();

                    if (editReceipt > 0 && editReceipt < receipts.size()) {
                        System.out.println("Please enter the number of the receipt that is listed.");
                    } else {
                        Receipt oldReceipt = receipts.get(editReceipt - 1);
                        receipts.get(editReceipt - 1).menu(_input);
                        Receipt newReceipt = receipts.get(editReceipt - 1);

                        if (newReceipt.getType() == "Purchase") {
                            quantity += (newReceipt.getQuantity() - oldReceipt.getQuantity());
                        }
                        else if (newReceipt.getType() == "Sale") {
                            quantity += (-newReceipt.getQuantity() + oldReceipt.getQuantity());
                        }

                        System.out.println();
                    }

                    continue;
                case 3:
                    // Delete a receipt
                    System.out.print("Pick a receipt to delete: ");
                    if (!_input.hasNextInt()) {
                        System.out.println("Please enter a number.");
                        _input.next();
                    }
                    
                    int deleteReceipt = _input.nextInt();
                    _input.nextLine();

                    if (deleteReceipt > 0 && deleteReceipt < receipts.size()) {
                        receipts.remove(deleteReceipt - 1);
                        System.out.println();
                    } else {
                        System.out.println("Please enter the number of the receipt that is listed.");
                    }

                    continue;
                case 4:
                    // Exit the product menu
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose a number from the options.");
                    break;
            }
        }
    }

    public void setName(String _value) {
        name = _value;
    }
    
    public void display() {
        String quantityStr = (quantity > quantityLowCount) ? String.valueOf(quantity) : String.valueOf(quantity) + "*";
        System.out.println(" " + name + " | " + quantityStr + " |");
    }
}