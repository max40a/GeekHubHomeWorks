import manager.InventoryManager;
import products.*;

import java.util.*;

public class Main {

    private static final int numberOfProductsNames = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, List<IProduct>> productMap = new HashMap<>();
        List<IProduct> sausageList = new ArrayList<>();
        List<IProduct> breadList = new ArrayList<>();
        List<IProduct> cheeseList = new ArrayList<>();

        String productName;
        int quantity;
        double prise;

        for (int i = 0; i < numberOfProductsNames; i++) {
            System.out.println("Enter the name of product (valid product : Bread, Cheese, Sausage): ");
            do {
                productName = scanner.next();
            } while (!validateInput(productName));
            System.out.print("How much " + productName + " : ");
            quantity = scanner.nextInt();
            System.out.print("price : ");
            prise = scanner.nextDouble();
            switch (productName) {
                case "Sausage":
                    for (int j = 0; j < quantity; j++) {
                        sausageList.add(new Sausage(prise));
                    }
                    productMap.put(productName, sausageList);
                    break;
                case "Bread":
                    for (int j = 0; j < quantity; j++) {
                        breadList.add(new Bread(prise));
                    }
                    productMap.put(productName, breadList);
                    break;
                case "Cheese":
                    for (int j = 0; j < quantity; j++) {
                        cheeseList.add(new Cheese(prise));
                    }
                    productMap.put(productName, cheeseList);
                    break;
            }
        }

        InventoryManager.printInventoryState(productMap);
    }

    private static boolean validateInput(String s) {
        switch (s) {
            case "Bread":
            case "Cheese":
            case "Sausage":
                return true;
        }
        System.out.println("Incorrect products. Permissible value : (Bread, Cheese, Sausage)");
        return false;
    }
}