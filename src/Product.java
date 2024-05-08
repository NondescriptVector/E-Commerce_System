public class Product {
    private int productID;
    private String name;
    private float price;

    public Product(int productID, String name, float price) {
        setProductID(productID);
        setName(name);
        setPrice(price);
    }

    public int productID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = Math.abs(productID);
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float price() {
        return price;
    }

    public void setPrice(float price) {
        this.price = Math.abs(price);
    }

    @Override
    public String toString() {
        return "Name: " + name() +
                "\nProduct ID: " + productID() +
                "\nPrice: " + price();
    }
}
