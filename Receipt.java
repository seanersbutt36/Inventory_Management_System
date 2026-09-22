import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Receipt {
    private String type = "";
    private Date date = null;
    private int quantity = 0;
    private char symbol = '+';

    public Receipt(Scanner _input, String _type) {
        String type = _type;
        boolean check = false;

        while (!check) {
            System.out.println();
            System.out.print("Enter a date (MM-dd-yyyy): ");
            String inputDate = _input.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            try {
                date = dateFormat.parse(inputDate);
                check = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use MM-dd-yyyy.");
                check = false;
            }
        }

        // Reset the "check" boolean for the next input.
        check = false;

        while (!check) {
            System.out.println();
            System.out.print("Enter the quantity: ");
            if (!_input.hasNextInt()) {
                System.out.println("Please enter an number.");
                _input.next(); 
            }
                
            int qunatityInput = _input.nextInt();
            _input.nextLine();

            if (qunatityInput < 0) {
                System.out.println("Enter a positive number.");
            } else {
                check = true;
            }
        }

        if (type == "Purchase") {
            symbol = '+';
        }
        else if (type == "Sale") {
            symbol = '-';
        }
    }

    public int updateQuantity() {
        return (symbol == '+') ? quantity : -quantity;
    }

    public void menu(Scanner _input) {
        while (true) {
            display();
            System.out.println("1. Change the type  2. Edit the date  3. Edit the quantity  4. Cancel");
            System.out.print("Enter an option: ");
            System.out.println();

            int choice = _input.nextInt();
            _input.nextLine();

            switch (choice) {
                case 1:
                    // Change the type of the receipt
                    String currentType = (type == "Purchase") ? "Purchase" : "Sale";
                    String newType = (type == "Purchase") ? "Sale" : "Purchase";

                    System.out.println("This receipt is currently a " + currentType + " receipt.");
                    System.out.println("Would you like to change this receipt to " + newType + " receipt?");
                    System.out.print("1. Yes  2. No: ");
                    
                    int changeTypeInput = _input.nextInt();

                    if (!_input.hasNextInt()) {
                        System.out.println("Please enter an number.");
                        _input.next();
                    } else if (changeTypeInput > 0 && changeTypeInput < 2) {
                        System.out.println("Please enter the number of the receipt that is listed.");
                    } else {
                        if (changeTypeInput == 1) {
                            type = newType;
                            System.out.println("The receipt type has changed.");
                        }
                        System.out.println();
                    }
                    continue;
                case 2:
                    // Edit the receipt's date
                    System.out.println();
                    System.out.print("Enter a date (MM-dd-yyyy): ");
                    String inputDate = _input.nextLine();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    try {
                        date = dateFormat.parse(inputDate);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use MM-dd-yyyy.");
                    }
                    continue;
                case 3:
                    // Edit the receipt's quantity
                    System.out.println();
                    System.out.print("Enter the quantity: ");
                    if (!_input.hasNextInt()) {
                        System.out.println("Please enter an number.");
                        _input.next(); 
                    }
                
                    int qunatityInput = _input.nextInt();
                    _input.nextLine();

                    if (qunatityInput < 0) {
                        System.out.println("Enter a positive number.");
                    } else {
                        quantity = qunatityInput;
                    }
                    continue;
                case 4:
                    // Exit the game
                    break;
            }
        }
    }

    public void display() {
        System.out.println(type);
        System.out.println("Date: " + date);
        System.out.println(" Quantity: " + symbol + quantity);
        System.out.println();
    }
}
