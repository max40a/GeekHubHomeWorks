package products;


import products.interfaces.Product;

public class AbstractProduct implements Product {

    private String title;
    private int quantity;
    private double prise;

    public AbstractProduct(String title, int quantity, double prise) {
        this.title = title;
        this.quantity = quantity;
        this.prise = prise;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return prise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractProduct that = (AbstractProduct) o;

        if (quantity != that.quantity) return false;
        if (Double.compare(that.prise, prise) != 0) return false;
        return title != null ? title.equals(that.title) : that.title == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(prise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}