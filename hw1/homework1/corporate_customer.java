package hw1.homework1;

public class corporate_customer extends customer {
    private String company_name;

    // Constructor
    public corporate_customer(String name, String surname, String address, String phone, int ID, int operatorID, String ct, String company_name) {
        super(name, surname, address, phone, ID, operatorID, ct); // Call superclass constructor
        this.company_name = company_name; // Initialize company name
    }

    // Getter method for company name
    public String getcompanyname(){
        return company_name;
    }

    // Method to print customer information
    public void print_customer(){
        // Print customer details
        System.out.println("Name & Surname: " + this.getName() + " " + this.getSurname() + "");
        System.out.println("Address: " + this.getAddress());
        System.out.println("Phone: " + this.getphone() + "\n" + "ID: " + this.getID() + "\n" + "Operator ID: " + this.getOPID() + "\n" + "Company name: " + this.getcompanyname());
        
        // Print customer orders
        this.print_orders();
    }
}


