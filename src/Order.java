public class Order {
    Customer customer;
    static int orderId=1;
    Cart cart;
    float totalPrice;

    public Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        this.totalPrice = this.cart.calculatePrice();
    }
    public String printOrderInfo(){
        StringBuilder s= new StringBuilder();
        for(Product prod:this.cart.products())
            s.append(prod);
        return "Order number: "+orderId+"\n"+s+"\nTotal: "+this.totalPrice;
    }
}
