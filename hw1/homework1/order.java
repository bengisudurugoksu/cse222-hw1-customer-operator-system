package hw1.homework1;

public class order {
    private String product_name; // Name of the product
    private int count; // Number of items in the order
    private int total_price; // Total price of the order
    private int status; // Status of the order
    private int customer_ID; // ID of the customer associated with the order
    private int index; // Index of the order

    // Default constructor
    public order() {}

    // Parameterized constructor
    public order(String pn, int c, int tp, int s, int ID) {
        product_name = pn;
        count = c;
        total_price = tp;
        status = s;
        customer_ID = ID;
    }

    // Getter methods
    public String getProductName() {
        return product_name;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return total_price;        
    }

    public int getStatus() {
        return status;
    }

    // Method to get status as a string
    public String Status() {
        String str = "";
        // Convert status integer to corresponding string
        switch(this.getStatus()) {
            case 0:
                str = "Initialized";
                break;
            case 1:
                str = "Processing";
                break;
            case 2:
                str = "Completed";
                break;
            case 3:
                str = "Cancelled";
                break;
        }
        return str;
    }

    // Method to print order details
    public void print_order() {
        System.out.println("Order #" + this.getIndex() + " => Product name: " + this.getProductName() +
                           " - Count: " + this.getCount() + " - Total price: " + this.getTotalPrice() +
                           " - Status: " + this.Status() + ".");
    }

    // Setter methods
    public void setProduct_name(String pn) {
        product_name = pn;
    }

    public void setCount(int c) {
        count = c;
    }

    public void setTotal_price(int tp) {
        total_price = tp;
    }

    public void setStatus(int s) {
        status = s;
    }

    public void setIndex(int i) {
        index = i;
    }

    public void setCustomer_ID(int ID) {
        customer_ID = ID;
    }

    // Getter method for order index
    public int getIndex() {
        return index;
    }

    // Getter method for customer ID associated with the order
    public int getCustomerID() {
        return customer_ID;
    }
}


