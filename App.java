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

        // If quit, stop the program
        input.close();
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
}