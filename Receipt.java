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

    public void display() {
        System.out.println(type);
        System.out.println("Date: " + date);
        System.out.println(" Quantity: " + symbol + quantity);
    }
}
