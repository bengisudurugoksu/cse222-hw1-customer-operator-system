package hw1.homework1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        read_file fileReader = new read_file();
        String filename = "hw1/homework1/content.txt";
        order[] orders=fileReader.readOrders(filename);
        operator[] operators=fileReader.readOperators(filename);
        customer[] customers=fileReader.readCustomers(filename);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your ID...\n");
        int ID = scanner.nextInt();
        int val = 0;
        if(ID<0 || ID>Integer.MAX_VALUE){
            System.out.println(ID + " is not a valid ID.");
        }
        else{
        for(operator operator : operators){ //Using enhanced for loop to go through customer, order, and operator arrays
            if(operator != null && operator.getID() == ID){
                operator.define_customers(customers);
                for(customer customer: customers){
                    customer.define_orders(orders);
                }
                operator.print_operator();
                val = 1;
            }
        }
        for(customer customer : customers){
            if(customer != null && customer.getID() == ID){
                customer.define_orders(orders);
                System.out.println("*** Customer Screen ***");
                customer.print_customer();
                val = 1;
            }
        }
        if(val==0){
            System.out.println("No operator/customer was found with ID " + ID + ". Please try again.");
        }
        scanner.close();
    }
    }
    
}



