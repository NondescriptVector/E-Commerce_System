import javax.swing.*;

public class EcommerceSystem {
    static boolean ord=false;

    static ElectronicProduct p1 = new ElectronicProduct(1, "Smartphone", 599.9f, "Samsung", 1);
    static ClothingProduct p2 = new ClothingProduct(2, "T-Shirt", 19.99f, "Medium", "Cotton");
    static BookProduct p3 = new BookProduct(3, "OOP", 39.99f, "O'Reilly", "X Publications");
    static ElectronicProduct p4 = new ElectronicProduct(4, "Smartphone", 249.9f, "Xiaomi", 1);
    static ClothingProduct p5 = new ClothingProduct(5, "Pull-over", 29.99f, "Large", "Wool");
    static Product[] productsList = {p1, p2, p3, p4, p5};

    static Customer me;
    static Cart myCart = new Cart(me);

    public static void main(String[] args) {


        String[] options = {"Products", "Cart", "Account info", "Exit"};
        String[] cartOptions = {"Checkout", "Add item", "Remove item", "Back"};

        int choice;

        registration();

        while (true) {
            choice = JOptionPane.showOptionDialog(null, "Choose what you want to do:",
                    "HomePage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    shopping();
                    break;
                case 1:
                    int c=-1;
                    try {
                        c = JOptionPane.showOptionDialog(null, "Cart: " + cartProducts()+"Total: "+myCart.calculatePrice(),
                                "Cart", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, cartOptions, cartOptions[0]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"Your cart is empty!",
                                "WARNING",JOptionPane.WARNING_MESSAGE);

                    }
                    switch (c) {
                        case 0:
                            checkout();
                            break;
                        case 1:
                            add();
                            break;
                        case 2:
                            remove();
                        case 3:
                            break;
                    }
                    break;
                case 2:
                    AccountInfo();
                    break;
                default:
                    break;
            }
            if (choice == 3 || choice == -1) {
                JOptionPane.showMessageDialog(null, "Thank you, please come again!");
                break;
            }
        }
    }

    public static void registration() {

        String name = null, address = null;
        int customerId = 0;

        while (name == null || name.isEmpty())
            name = JOptionPane.showInputDialog(null, "Enter your name",
                    "Name", JOptionPane.QUESTION_MESSAGE);

        while (address == null || address.isEmpty())
            address = JOptionPane.showInputDialog(null, "Enter your address",
                    "Address", JOptionPane.QUESTION_MESSAGE);

        while (customerId == 0) {
            try {

                customerId = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer ID",
                        "customer ID", JOptionPane.QUESTION_MESSAGE));

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Enter a valid customer ID",
                        "WARNING", JOptionPane.WARNING_MESSAGE);

            }
        }

        me = new Customer(name, address, customerId);
    }

    public static String allProducts() {
        StringBuilder s = new StringBuilder();
        for (Product prod : productsList)
            s.append(prod).append("\n");
        return s.toString();
    }

    public static String cartProducts() {
        StringBuilder s = new StringBuilder();
        for (int i=0;i<myCart.products().length;i++)
            s.append((i + 1)).append("- ").append(myCart.products()[i].toString()).append("\n");
        return s.toString();
    }

    public static void shopping() {
        String[] productOptions = {"1","2", "3", "4", "5"};
        String p;
        int pp=0;

        do {
            try {
                p = JOptionPane.showInputDialog(null, "Enter number of products",
                        "Products", JOptionPane.QUESTION_MESSAGE);
                if(p == null)
                    return;
                pp = Integer.parseInt(p);
                if (Integer.parseInt(p) <= 0) {
                    JOptionPane.showMessageDialog(null, "Input a valid product number!",
                            "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Input a valid product number!",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } while (pp <= 0);
        myCart.setNProducts(pp);
        myCart.setProducts(new Product[myCart.nProducts()]);
        for (int i=0;i<myCart.products().length;i++) {
            var cho = (String)JOptionPane.showInputDialog(null,"Products:\n"+allProducts()+"\nChoose product ID:",
                    "Products",JOptionPane.QUESTION_MESSAGE,null,productOptions,productOptions[0]);
            if(cho == null)
                return;
            var choice = Integer.parseInt(cho);
            for(Product prod:productsList){
                if(choice== prod.productID()){
                    myCart.products()[i] = prod;
                }
            }

        }
        ord = true;
    }
    public static void checkout(){
        if(!ord){
            JOptionPane.showMessageDialog(null,"You can't make an order with an empty cart!",
                    "WARNING",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Order order = myCart.placeOrder();
        ord = false;
        JOptionPane.showMessageDialog(null, "Order Info:" + order.printOrderInfo() + "\nPlease proceed with the payment.",
                "Order info", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Order placed successfully!",
                "Order successful", JOptionPane.INFORMATION_MESSAGE);
        Order.orderId++;
        myCart = new Cart(me);

    }
    public static void add(){
        String[] productOptions = {"1","2", "3", "4", "5"};
        var cho = (String)JOptionPane.showInputDialog(null,"Products:\n"+allProducts()+"\nChoose product ID:",
                "Products",JOptionPane.QUESTION_MESSAGE,null,productOptions,productOptions[0]);
        if(cho == null)
            return;
        var choice = Integer.parseInt(cho);
        for(Product prod:productsList){
            if(choice== prod.productID()){
                myCart.addProduct(prod);
            }
        }
    }
    public static void remove(){
        String[] removeOptions = new String[myCart.nProducts()];
        if(myCart.products().length == 1)
            myCart = new Cart(me);
        for(int i = 1;i<=myCart.nProducts();i++){
            removeOptions[i-1] = Integer.toString(i);
        }
        var cho = (String)JOptionPane.showInputDialog(null,"Cart:\n"+cartProducts()+"\nChoose product number:",
                "Products",JOptionPane.QUESTION_MESSAGE,null,removeOptions,removeOptions[0]);
        if(cho == null)
            return;
        var choice = Integer.parseInt(cho);
        myCart.removeProduct(choice-1);
    }
    public static void AccountInfo(){
        JOptionPane.showMessageDialog(null,
                "Account info:"+"\nName: "+me.name()+"\nCustomer ID: "+me.customerID()+"\n Address: "+ me.address(),
                "Account info",JOptionPane.INFORMATION_MESSAGE);
    }
}