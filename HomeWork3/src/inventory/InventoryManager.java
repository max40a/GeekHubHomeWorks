package inventory;

import products.interfaces.Product;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Inventory<Product> inventory;

    public InventoryManager(Inventory<Product> inventory) {
        this.inventory = inventory;
    }

    public Map<String, Integer> getTotalByProducts() {
        int totalQuantity;
        Map<String, Integer> products = new HashMap<>();

        for (Product product : inventory) {
            if (products.containsKey(product.getTitle())) {
                totalQuantity = products.get(product.getTitle()) + 1;
                products.replace(product.getTitle(), totalQuantity);
            } else {
                products.put(product.getTitle(), 1);
            }
        }

        return products;
    }

    public Map<String, Double> getTotalPriseByProduct() {
        double totalPrise;
        Map<String, Double> products = new HashMap<>();

        for (Product product : inventory) {
            if(products.containsKey(product.getTitle())) {
                totalPrise = products.get(product.getTitle()) + product.getPrice() * product.getQuantity();
                products.replace(product.getTitle(), totalPrise);
            } else {
                products.put(product.getTitle(), product.getPrice() * product.getQuantity());
            }
        }
        return products;
    }

    public String printResult() {
        Map<String, Integer> totalByProducts = getTotalByProducts();
        Map<String, Double> totalPriseByProduct = getTotalPriseByProduct();
        double totalPrise = 0;

        StringBuilder result = new StringBuilder();
        result.append("\n===============================\n");
        result.append("Products in the Inventory : \n");

        for(Map.Entry<String, Integer> entry : totalByProducts.entrySet()) {
            result.append(String.format("%s\t%d units,  price = %.2f\n",
                    entry.getKey(),
                    entry.getValue(),
                    totalPriseByProduct.get(entry.getKey())));
            totalPrise += totalPriseByProduct.get(entry.getKey());
        }

        result.append(String.format("Total coast : %.2f" , totalPrise));
        result.append("\n===============================\n");
        return result.toString();
    }
}