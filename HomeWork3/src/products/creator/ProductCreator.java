package products.creator;

import products.Bread;
import products.Cheese;
import products.Sausage;
import products.interfaces.Product;

public class ProductCreator {
    public static Product productCreate(String productName, double prise) {
        switch (productName) {
            case "Bread":
                return new Bread(prise);
            case "Cheese":
                return new Cheese(prise);
            case "Sausage":
                return new Sausage(prise);
        }
        return null;
    }
}