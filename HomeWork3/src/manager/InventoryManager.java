package manager;

import products.IProduct;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class InventoryManager {

    private static final String header = "\n==============IN TOTAL===============\n";
    private static final String footer = "\n=======================================";
    private static final String interHeader = "=====INFO FOR %s======\n";
    private static final String priseAllProducts = "total prise = %.2f $.\n";
    private static final String numberAllProducts = "Total numbers od products : %d\n";
    private static final String priseParticularProducts = "All %s is coast = %.2f\n";
    private static final String numberParticularProducts = "Total %s is %d\n";

    public static double calculatePriceOfAllProducts(Map<String, List<IProduct>> map) {
        Set<Map.Entry<String, List<IProduct>>> set = map.entrySet();
        double totalPrise = 0;
        for (Map.Entry<String, List<IProduct>> entrySet : set) {
            List<IProduct> list = entrySet.getValue();
            for (IProduct p : list) {
                totalPrise += p.getPrise();
            }
        }
        return totalPrise;
    }

    public static int calculateNumberOfAllProducts(Map<String, List<IProduct>> map) {
        int numberProduct = 0;
        for (String key : map.keySet()) {
            numberProduct += map.get(key).size();
        }
        return numberProduct;
    }

    public static double calculateTotalPriceOfParticularProduct(Map<String, List<IProduct>> map, String productName) {
        double sumPriceProduct = 0;
        List<IProduct> products = map.get(productName);
        for (IProduct p : products) {
            sumPriceProduct += p.getPrise();
        }
        return sumPriceProduct;
    }

    public static int calculateTotalNumberOfParticularProduct(Map<String, List<IProduct>> map, String productName) {
        return map.get(productName).size();
    }

    public static void printInventoryState(Map<String, List<IProduct>> map) {
        System.out.println(header);
        System.out.printf(priseAllProducts, calculatePriceOfAllProducts(map));
        System.out.printf(numberAllProducts, calculateNumberOfAllProducts(map));
        System.out.println();
        for (String s : map.keySet()) {
            System.out.printf(interHeader, s);
            System.out.printf(priseParticularProducts, s, calculateTotalPriceOfParticularProduct(map, s));
            System.out.printf(numberParticularProducts, s, calculateTotalNumberOfParticularProduct(map, s));
            System.out.println();
        }
        System.out.println(footer);
    }
}