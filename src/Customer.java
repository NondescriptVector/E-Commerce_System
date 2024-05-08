public class Customer {
    private String name, address;
    private int customerID;

    public Customer(String name, String address, int customerID) {
        setAddress(address);
        setName(name);
        setCustomerID(customerID);
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int customerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = Math.abs(customerID);
    }
}