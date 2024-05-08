public class ElectronicProduct extends Product{
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(int productID, String name, float price, String brand, int warrantyPeriod) {
        super(productID, name, price);
        setBrand(brand);
        setWarrantyPeriod(warrantyPeriod);
    }

    public String brand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int warrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBrand: " + brand() +
                "\nWarranty: " + warrantyPeriod() + "\n";
    }
}
