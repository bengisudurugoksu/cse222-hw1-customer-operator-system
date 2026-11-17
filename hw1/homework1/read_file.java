package hw1.homework1;

import java.io.File;
import java.util.Scanner;

public class read_file {
    private int[] usedOperatorIDs = new int[100]; //Using these arrays to check for existing ID
    private int[] usedCustomerIDs = new int[100];
    private int operatorIndex = 0;
    private int customerIndex = 0;

    public operator[] readOperators(String filename) {
        operator[] operators = new operator[100]; 
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int index = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";"); // Splitting data with split

                try {
                    if (data.length != 7 || !data[0].equals("operator")) { // Checking for first element and missing or extra columns
                        continue; 
                    }

                    String name = data[1];
                    String surname = data[2];
                    String address = data[3];
                    String phone = data[4];
                    if (name.equals("") || surname.equals("") || address.equals("") || phone.equals("")) { //Checking for empty strings
                        continue;
                    }
                    int ID = Integer.parseInt(data[5]);

                    int wage = Integer.parseInt(data[6]);
                    if (ID < 0 || ID > Integer.MAX_VALUE || wage> Integer.MAX_VALUE|| wage < 0) {
                        continue;
                    }
                    if (idExists(usedCustomerIDs, ID) == 1) {
                        continue; 
                    }
                    if (idExists(usedOperatorIDs, ID) == 1) {
                        continue; 
                    }
                    usedOperatorIDs[operatorIndex++] = ID;
                    operator newOperator = new operator(name, surname, address, phone, ID, wage);
                    operators[index++] = newOperator;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            operator[] resizedOperators = new operator[index];
            System.arraycopy(operators, 0, resizedOperators, 0, index);
            operators = resizedOperators;
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operators;
    }

    public order[] readOrders(String filename) {
        order[] orders = new order[100]; 
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");

                try {
                    if (data.length != 6 || !data[0].equals("order")) {
                        continue; 
                    }
                    String productName = data[1];
                    if (productName.equals("")) {
                        continue;
                    }
                    int count = Integer.parseInt(data[2].trim());
                    int totalPrice = Integer.parseInt(data[3].trim());
                    int status = Integer.parseInt(data[4].trim());
                    int customerId = Integer.parseInt(data[5].trim());
                    if (count <= 0 || count>Integer.MAX_VALUE||totalPrice>Integer.MAX_VALUE||customerId>Integer.MAX_VALUE|| totalPrice < 0 || status < 0 || status > 4 || customerId < 0) {
                        continue;
                    }
                    order newOrder = new order(productName, count, totalPrice, status, customerId);
                    orders[index++] = newOrder;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            order[] resizedOrders = new order[index];
            System.arraycopy(orders, 0, resizedOrders, 0, index);
            orders = resizedOrders;
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public customer[] readCustomers(String filename) {
        customer[] customers = new customer[100]; 
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int index = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");

                try {
                    if ((data.length != 7 &&data[0].trim().equals("retail_customer")) || (data.length != 8 && data[0].trim().equals("corporate_customer"))|| (!data[0].trim().equals("retail_customer") && !data[0].trim().equals("corporate_customer"))) {
                        continue; 
                    }
                    String type = data[0].trim();
                    String name = data[1];
                    String surname = data[2];
                    String address = data[3];
                    String phone = data[4];
                    if (name.equals("") || surname.equals("") || address.equals("") || phone.equals("")) {
                        continue;
                    }

                    int ID = Integer.parseInt(data[5].trim());
                    int operatorID = Integer.parseInt(data[6].trim());

                    if (idExists(usedCustomerIDs, ID) == 1) {
                        continue; 
                    }
                    if (idExists(usedOperatorIDs, ID) == 1) {
                        continue;
                    }
                    usedCustomerIDs[customerIndex++] = ID;
                    if (ID < 0 || ID>Integer.MAX_VALUE||operatorID>Integer.MAX_VALUE||operatorID < 0) {
                        continue;
                    }
                    if (type.equals("retail_customer")) {
                        String ct = "a retail customer";
                        retail_customer retailCustomer = new retail_customer(name, surname, address, phone, ID, operatorID, ct);
                        customers[index++] = retailCustomer;
                    } else if (type.equals("corporate_customer")) {
                        if (data.length != 8) {
                            continue; 
                        }
                        String companyName = data[7].trim();
                        if (companyName.equals("")) {
                            continue;
                        }
                        String custtype = "a corporate customer";
                        corporate_customer corporateCustomer = new corporate_customer(name, surname, address, phone, ID, operatorID, custtype, companyName);
                        customers[index++] = corporateCustomer;
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            customer[] resizedCustomers = new customer[index];
            System.arraycopy(customers, 0, resizedCustomers, 0, index);
            customers = resizedCustomers;
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
    private int idExists(int[] array, int id) { //Method for checking an existing ID
        for (int i = 0; i < array.length; i++) {
            if (array[i] == id) {
                return 1;
            }
        }
        return 0;
    }
}


