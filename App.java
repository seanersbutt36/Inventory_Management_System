/* 
Products                    Know what we have
Stock quatities             How much we have
Purchases/sales             How much they cost
Low-stock alerts            What are we low on
Search/filtering            Implement SQL - Query Language
Store data in a database    Update the database

Skills: Java, OOP, SQL JDBC, database design
*/

import java.util.Scanner;
import java.util.ArrayList;
/*import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;*/

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        boolean quit = false;

        // Select to create, update, delete, or quit
        while (!quit) {
            // Output the data
            display(products);

            System.out.println("1. Add   2. Update   3. Remove   4. Quit");
            System.out.print("Choose an option: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a number.");
                input.next();
                continue;
            }

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    // Create a product
                    Product product = new Product(input);
                    products.add(product);
                    break;
                case 2:
                    // Update a product info
                    break;
                case 3:
                    // Delete a product
                    break;
                case 4:
                    // Quitting
                    quit = true;
                    break;
                default:
                    System.out.println("Please choose a number from the options.");
                    break;
            }
        }

        // If create, create a new product
        // If update, choose which info to update
        // If delete, choose a product to delete

        // If quit, stop the program

        return;
    }

    static void display(ArrayList<Product> _products) {
        if (!_products.isEmpty()) {
            for (int i = 0; i < _products.size(); i++) {
                _products.get(i).display();
            }
            System.out.println();
        }
    }

    /*static void inputReceiptInfo(Scanner _input) {
        String type = "";
        int quantity = 0;
        boolean check = false;

        System.out.println("Enter the type of receipt.");
        System.out.print("1. Purchase  2. Sale: ");
        while (!check) {
            if (!_input.hasNextInt()) {
                System.out.println("Please follow the format.");
                _input.next();
                continue;
            }

            int choice = _input.nextInt();
            switch (choice) {
                case 1:
                    // A customer made a purchase
                    type = "Purchase";
                    check = true;
                    break;
                case 2:
                    // You made a purchase with a supplier
                    type = "Sale";
                    check = true;
                    break;
                default:
                    // Input doesn't exist
                    System.out.println("Input doesn't exist. Please enter one of the avaliable options: ");
                    break;
            }
        }

        // Reset the 'check' boolean for the next input
        check = false;

        System.out.print("Enter a date (MM-dd-yyyy): ");
        String inputDate = _input.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date data = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use MM-dd-yyyy.");
        }
    }*/
}