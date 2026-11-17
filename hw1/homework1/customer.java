package hw1.homework1;

public class customer extends person {
    private order[] orders; // Array to hold customer's orders
    private int operator_ID; // Operator ID associated with the customer
    private String customertype; // Type of the customer (e.g., retail or corporate)

    // Constructor
    public customer(String name, String surname, String address, String phone, int ID, int operator_ID, String custtype) {
        super(name, surname, address, phone, ID); // Call superclass constructor
        this.operator_ID = operator_ID; // Initialize operator ID
        this.orders = new order[100]; // Initialize order array with a capacity of 100
        this.customertype = custtype; // Initialize customer type
    }

    // Getter method for operator ID
    public int getOPID(){
        return operator_ID;
    }

    // Getter method for customer orders
    public order[] getCustomerOrders(){
        return orders;
    }

    // Setter method for customer type
    public void setcustomertype(String ct){
        customertype=ct;
    }

    // Getter method for customer type
    public String getCustType(){
        return customertype;
    }

    // Method to print customer information
    public void print_customer(){
        // Print customer details
        System.out.println("Name & Surname: " + this.getName() + " " + this.getSurname() + "");
        System.out.println("Address: " + this.getAddress());
        System.out.println("Phone: " + this.getphone() + "\n" + "ID: " + this.getID() + "\n" + "Operator ID: " + this.getOPID());
        
        // Print customer orders
        this.print_orders();
    }

    // Method to print customer orders
    public void print_orders() {
        int i = 1;
        if (orders != null) {
            for (order obj : orders) {
                if (obj != null) {
                    obj.setIndex(i); // Set the index of the order
                    obj.print_order(); // Print the order
                }
                i++;                
            }
        } else {
            System.out.println("No orders available for this customer.");
        }
    }

    // Method to define customer orders
    public void define_orders(order[] allorders){
        if (allorders == null) {
            return; 
        }
        if (orders == null) {
            orders = new order[allorders.length];
        }
        int index = 0;
        for(order a : allorders){
            if(a != null && a.getCustomerID() == this.getID()){
                if (index == orders.length) {
                    order[] temp = new order[orders.length * 2]; 
                    System.arraycopy(orders, 0, temp, 0, orders.length); 
                    orders = temp;
                }
                orders[index++] = a; // Assign the order to the customer
            }
        }        
    }    
}



