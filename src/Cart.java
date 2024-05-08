public class Cart {
    private Customer customer;
    private int nProducts = 0;
    private Product[] products;

    public Cart(Customer customer) {
        setCustomer(customer);
    }

    public Customer customer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int nProducts() {
        return nProducts;
    }

    public void setNProducts(int numberOfProducts) {
        this.nProducts = Math.abs(numberOfProducts);
    }

    public Product[] products() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void addProduct(Product ex){
        nProducts++;
        Product[] temp = new Product[nProducts];
        for(int i = 0;i < products.length;i++)
            temp[i] = products[i];
        temp[nProducts-1] = ex;
        products = temp;
    }
    public void removeProduct(int index){
        nProducts--;

        Product[] temp = new Product[nProducts];

        for(int i = 0;i < index;i++)
            temp[i] = products[i];

        for(int i = index;i < temp.length;i++)
            temp[i] = products[i+1];

        products = temp;
    }
    public float calculatePrice(){
        float total = 0;
        for(Product p:products)
            total += p.price();
        return total;
    }
    public Order placeOrder(){
        return new Order(this.customer(), this);
    }
}
