package products;


public class Product implements IProduct {

    private String title;
    private double prise;

    public Product(String title, double prise) {
        this.title = title;
        this.prise = prise;
    }

    @Override
    public double getPrise() {
        return prise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.prise, prise) != 0) return false;
        return title != null ? title.equals(product.title) : product.title == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        temp = Double.doubleToLongBits(prise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}