import products.interfaces.Product;
import inventory.Inventory;
import inventory.InventoryManager;
import products.creator.ProductCreator;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Inventory<Product> inventory = new Inventory<>();
        Product product;
        String productName;
        double prise;

        boolean isExit = true;
        do {
            System.out.println("Add the product to your inventory:\n\t\"Bread\"\n\t" +
                    "\"Cheese\"\n\t\"Sausage\"\n\t\"q\" - Quit and print result.\n");
            System.out.print("Chose : ");
            do {
                productName = scanner.next();
            } while (!validateInputString(productName));

            if (productName.equals("q")) {
                isExit = false;
            } else {

                System.out.print("Enter the " + productName + " prise : ");
                prise = scanner.nextDouble();
                System.out.println();
                product = ProductCreator.productCreate(productName, prise);
                if (product != null) {
                    inventory.addProduct(product);
                }
            }
        } while (isExit);

        InventoryManager manager = new InventoryManager(inventory);
        System.out.println(manager.printResult());
    }

    private static boolean validateInputString(String productName) {
        switch (productName) {
            case "Bread":
            case "Cheese":
            case "Sausage":
            case "q":
                return true;
        }
        System.out.println("Incorrect products. Permissible value : (Bread, Cheese, Sausage or \"q\" for exit and print result.)");
        return false;
    }
}