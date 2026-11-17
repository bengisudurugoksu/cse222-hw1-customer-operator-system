/*package hw1.homework1;

public class operator extends person{
        private int wage;
        private customer[] customers;
        public operator(String name, String surname, String address, String phone, int ID, int wage) {
                super(name, surname, address, phone, ID);
                this.wage = wage;
            }
        public int getWage(){
                return wage;
        }
        public void print_operator(){
                System.out.println("*** Operator Screen ***");
                System.out.println("----------------------------");
                System.out.println("Name & Surname: " + this.getName() + " " + this.getSurname() + "");
                System.out.println("Address: " + this.getAddress());
                System.out.println("Phone: " + this.getphone() + "\n" + "ID: " + this.getID() + "\n" + "Wage: " + this.getWage());
                System.out.println("----------------------------");
                this.print_customers();

        }
        public void print_customers() {
            if (customers == null || customers.length == 0) {
                System.out.println("This operator doesn't have any customers.");
                System.out.println("----------------------------");
                return; 
            }
        
            int i = 1;
            int hasCustomers = 0;
            
            for (customer cust : customers) {
                if (cust != null) {
                    hasCustomers = 1; 
                    System.out.println("Customer #" + i + " (" + cust.getCustType() + ") :");
                    cust.print_customer();
                    System.out.println("----------------------------");
                    i++;
                }
            }
        
            if (hasCustomers==0) {
                System.out.println("This operator doesn't have any customers.");
                System.out.println("----------------------------");
            }
        }
        
        
        public void define_customers(customer[] allcustomers){
                if (allcustomers == null) {
                        return; 
                    }
                    if (customers == null) {
                        customers = new customer[allcustomers.length];
                    }
                    int index=0;
                    for(customer a : allcustomers){
                        if(a !=null && a.getOPID()==this.getID()){
                            if (index == customers.length) {
                                customer[] temp = new customer[customers.length * 2]; 
                                System.arraycopy(customers, 0, temp, 0, customers.length); 
                                customers = temp; 
                            }
                            customers[index++] = a;
                        }
                    } 

        }    
}*/
package hw1.homework1;

public class operator extends person {
    private int wage;
    private customer[] customers; // Array to hold operator's customers

    // Constructor
    public operator(String name, String surname, String address, String phone, int ID, int wage) {
        super(name, surname, address, phone, ID); // Call superclass constructor
        this.wage = wage; // Initialize wage
    }

    // Getter method for wage
    public int getWage(){
        return wage;
    }

    // Method to print operator information and associated customers
    public void print_operator() {
        System.out.println("*** Operator Screen ***");
        System.out.println("----------------------------");
        System.out.println("Name & Surname: " + this.getName() + " " + this.getSurname() + "");
        System.out.println("Address: " + this.getAddress());
        System.out.println("Phone: " + this.getphone() + "\n" + "ID: " + this.getID() + "\n" + "Wage: " + this.getWage());
        System.out.println("----------------------------");
        this.print_customers(); // Print associated customers
    }

    // Method to print associated customers
    public void print_customers() {
        // Check if customers array is null or empty
        if (customers == null || customers.length == 0) {
            System.out.println("This operator doesn't have any customers.");
            System.out.println("----------------------------");
            return; // Exit the method if there are no customers
        }

        int i = 1; // Counter for printing customer numbers
        int hasCustomers = 0; // Flag to track if any customers are found
        
        // Iterate through the customers array
        for (customer cust : customers) {
            if (cust != null) {
                hasCustomers = 1; // Set flag to indicate that customers are found
                System.out.println("Customer #" + i + " (" + cust.getCustType() + ") :");
                cust.print_customer(); // Print customer details
                System.out.println("----------------------------");
                i++; // Increment customer number
            }
        }

        // If no customers are found, print a message
        if (hasCustomers == 0) {
            System.out.println("This operator doesn't have any customers.");
            System.out.println("----------------------------");
        }
    }
    
    // Method to define customers associated with the operator
    public void define_customers(customer[] allcustomers) {
        if (allcustomers == null) {
            return; // Exit the method if the input array is null
        }
        
        // Initialize the customers array if it's null
        if (customers == null) {
            customers = new customer[allcustomers.length];
        }

        int index = 0; // Index to keep track of the next available position in the customers array
        
        // Iterate through all customers
        for (customer a : allcustomers) {
            // Check if the customer is associated with this operator
            if (a != null && a.getOPID() == this.getID()) {
                // Resize the customers array if needed
                if (index == customers.length) {
                    customer[] temp = new customer[customers.length * 2];
                    System.arraycopy(customers, 0, temp, 0, customers.length);
                    customers = temp; // Update reference to the new array
                }
                customers[index++] = a; // Assign the customer to the customers array
            }
        }
    }
}



