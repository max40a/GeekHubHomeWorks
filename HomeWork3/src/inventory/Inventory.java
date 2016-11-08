package inventory;

import products.interfaces.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory<T extends Product> implements Iterable<T> {

    private List<T> inventory = new ArrayList<>();

    public void addProduct(T product) {
        this.inventory.add(product);
    }

    @Override
    public Iterator<T> iterator() {
        return inventory.iterator();
    }
}