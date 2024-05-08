public class ClothingProduct extends Product{
    private String size, fabric;

    public ClothingProduct(int productID, String name, float price, String size, String fabric) {
        super(productID, name, price);
        setSize(size);
        setFabric(fabric);
    }

    public String size() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String fabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nSize: " + size() +
                "\nFabric: " + fabric() + "\n";
    }
}