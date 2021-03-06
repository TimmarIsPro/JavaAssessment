/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment2darray;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;
import java.io.RandomAccessFile;

/**
 *
 * @author J380446
 */
public class Assessment2DArray {
    
    static Scanner console = new Scanner(System.in);

    static String seatingPlan[][] = new String[13][8];
    static Customer customers[] = new Customer[75]; //maximum number of seats plus some leeway i guess
    static int idCounter = 1; //Might be necessary for now
    String filename = "SeatingPlan.dat"; //Seating plan binary file.
            
    public void displaySeats() { 
        
        System.out.println();
        for (int row = 0; row<seatingPlan.length; row++) {
            for (int col=0; col<seatingPlan[row].length; col++) {
                System.out.print(String.format("%5s",seatingPlan[row][col]));
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private static void writeToRandomAccessFile(String file, String record){
        try {
            RandomAccessFile fileStore = new RandomAccessFile(file, "rw");
            long position = fileStore.length();
            fileStore.seek(position);
            fileStore.writeUTF(record);
            fileStore.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void writeToRandomAccessFileAtPosition(String file, int position, String record){
        try {
            RandomAccessFile fileStore = new RandomAccessFile(file, "rw");
            fileStore.seek(position);
            fileStore.writeUTF(record);
            fileStore.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static int obtainRandomAccessFilePosition()
    {
        int result = 0;
        
        
        return result;
    }
    
    public void initializeSeatingPlan() {
        
        //if time permits, make this look more proper
        for (String[] row: seatingPlan) {
            Arrays.fill(row, "*");
        }        
        
        seatingPlan[0][0] = " ";
        seatingPlan[0][1] = "A";
        seatingPlan[0][2] = "B";
        seatingPlan[0][3] = "C";
        seatingPlan[0][4] = " ";
        seatingPlan[0][5] = "D";
        seatingPlan[0][6] = "E";
        seatingPlan[0][7] = "F";
                
        
        for (int i = 1; i < 13; i++){
            seatingPlan[i][0] = ("Row" + i);
        }
        for (int i = 1; i < 13; i++){
            seatingPlan[i][4] = (" ");
        }


        for (int i = 1; i < seatingPlan.length; i++){
            for (int j = 1; j < seatingPlan[i].length; j++)
         /*   {
                writeToRandomAccessFile(filename,seatingPlan[i][j]);
                
            }    */
            {
                if (seatingPlan[i][j] == "*")
                {
                    int location = Integer.parseInt("" + i + "" + j);                    
                    writeToRandomAccessFileAtPosition(filename, location, seatingPlan[i][j]);
                }
            }   
        } 
        //thing to test if binary file is working right
        //writeToRandomAccessFileAtPosition(filename, 2 , "9");
    }
    
    public void checkSeating(int rowNum, int colNum) {
        
    }
    
    public void cancelSeatAllocation(int idToSearch) {
        for (int i = 1; i < idCounter; i++){
            if (idToSearch == customers[i].getId()){
                System.out.println("Do you wish to cancel your seat allocation? (Y/N)");
                String decision = console.next();
                if ("Y".equals(decision)) {
                    int rowChange = customers[i].getSeatRow();
                    int colChange = customers[i].getSeatColumn();
                    seatingPlan[rowChange][colChange] = "*";
                }
            }
        }
    }
    
    public int obtainFileLocation(int posA, int posB)
    {
        int location = Integer.parseInt("" + posA + "" + posB);
        return location;
    }
    
    public void allocateCustomer(Customer allocatedCustomer) {
        switch(allocatedCustomer.getClassType()) {
            case "F":
                if ("W".equals(allocatedCustomer.getSeatType())){
                    for (int i = 1; i <= 2; i++) {
                        if (seatingPlan[i][1] == "*"){
                            seatingPlan[i][1] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i) ;
                            allocatedCustomer.setSeatColumn(1);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 1), seatingPlan[i][1]);
                            break;
                        } else if (seatingPlan[i][7] == "*"){
                            seatingPlan[i][7] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i) ;
                            allocatedCustomer.setSeatColumn(7);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 7), seatingPlan[i][7]);
                            break;
                        }
                    }
                } else if ("M".equals(allocatedCustomer.getSeatType())) {
                    for (int i = 1; i <= 2; i++){
                        if (seatingPlan[i][2] == "*") {
                            seatingPlan[i][2] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(2);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 2), seatingPlan[i][2]);
                            break;
                        } else if (seatingPlan[i][6] == "*") {
                            seatingPlan[i][6] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(6);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 6), seatingPlan[i][6]);
                            break;
                        }
                    }
                } else if ("A".equals(allocatedCustomer.getSeatType())) { 
                    for (int i = 1; i <= 2; i++){
                        if (seatingPlan[i][3] == "*") {
                            seatingPlan[i][3] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(3);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 3), seatingPlan[i][3]);
                            break;
                        } else if (seatingPlan[i][5] == "*") {
                            seatingPlan[i][5] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(5);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 5), seatingPlan[i][5]);
                            break;
                        }
                    }
                }
                break;
            case "B":
                if ("W".equals(allocatedCustomer.getSeatType())){
                    for (int i = 3; i <= 6; i++) {
                        if (seatingPlan[i][1] == "*"){
                            seatingPlan[i][1] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i) ;
                            allocatedCustomer.setSeatColumn(1);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 1), seatingPlan[i][1]);
                            break;
                        } else if (seatingPlan[i][7] == "*"){
                            seatingPlan[i][7] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i) ;
                            allocatedCustomer.setSeatColumn(7);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 7), seatingPlan[i][7]);
                            break;
                        }
                    }
                } else if ("M".equals(allocatedCustomer.getSeatType())) {
                    for (int i = 3; i <= 6; i++){
                        if (seatingPlan[i][2] == "*") {
                            seatingPlan[i][2] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(2);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 2), seatingPlan[i][2]);
                            break;
                        } else if (seatingPlan[i][6] == "*") {
                            seatingPlan[i][6] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(6);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 6), seatingPlan[i][6]);
                            break;
                        }
                    }
                } else if ("A".equals(allocatedCustomer.getSeatType())) { 
                    for (int i = 3; i <= 6; i++){
                        if (seatingPlan[i][3] == "*") {
                            seatingPlan[i][3] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(3);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 3), seatingPlan[i][3]);
                            break;
                        } else if (seatingPlan[i][5] == "*") {
                            seatingPlan[i][5] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(5);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 5), seatingPlan[i][5]);
                            break;
                        }
                    }
                }
                break;
            case "E":
                if ("W".equals(allocatedCustomer.getSeatType())){
                    for (int i = 7; i <= 12; i++) {
                        if (seatingPlan[i][1] == "*"){
                            seatingPlan[i][1] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i) ;
                            allocatedCustomer.setSeatColumn(1);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 1), seatingPlan[i][1]);
                            break;
                        } else if (seatingPlan[i][7] == "*"){
                            seatingPlan[i][7] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i) ;
                            allocatedCustomer.setSeatColumn(7);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 7), seatingPlan[i][7]);
                            break;
                        }
                    }
                } else if ("M".equals(allocatedCustomer.getSeatType())) {
                    for (int i = 7; i <= 12; i++){
                        if (seatingPlan[i][2] == "*") {
                            seatingPlan[i][2] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(2);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 2), seatingPlan[i][2]);
                            break;
                        } else if (seatingPlan[i][6] == "*") {
                            seatingPlan[i][6] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(6);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 6), seatingPlan[i][6]);
                            break;
                        }
                    }
                } else if ("A".equals(allocatedCustomer.getSeatType())) { 
                    for (int i = 7; i <= 12; i++){
                        if (seatingPlan[i][3] == "*") {
                            seatingPlan[i][3] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(3);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 3), seatingPlan[i][3]);
                            break;
                        } else if (seatingPlan[i][5] == "*") {
                            seatingPlan[i][5] = allocatedCustomer.getAge();
                            allocatedCustomer.setSeatRow(i);
                            allocatedCustomer.setSeatColumn(5);
                            writeToRandomAccessFileAtPosition(filename, obtainFileLocation(i, 5), seatingPlan[i][5]);
                            break;
                        }
                    }
                }
                break; 
            default:
                break;
        }
        allocatedCustomer.setId(idCounter);
        System.out.println("Your seat has been booked. The Id assigned to you is " + allocatedCustomer.getId());
    }
    
    public Customer addCustomer() {
        Customer newCustomer = new Customer();
        
        System.out.print("Enter your name: ");
        newCustomer.setName(console.next());
        System.out.println("Enter 'A' for Adult, 'C' for Child: ");
        newCustomer.setAge(console.next());
        System.out.println("Enter your preferred class type. 'F' for First, 'B' for Business, 'E' for Economy: ");
        newCustomer.setClassType(console.next());
        System.out.println("Enter your preferred seat location. 'W' for Window, 'A' for Aisle, 'M' for Middle: ");
        newCustomer.setSeatType(console.next());
        
        allocateCustomer(newCustomer);

        return newCustomer;
    }
  
    public void viewCustomer(int idToSearch) {
        for (int i = 1; i < idCounter; i++) {
            if (idToSearch == customers[i].getId()) {
                String customerDetails = customers[i].toString();
                System.out.println(customerDetails);
            }
        }
    }
    
    public void searchCustomers() {
   /*     for (int i = 1; i < idCounter; i++) {
            Customer customer = customers[i];
            //System.out.println(customer);
        }*/
        System.out.println("Enter the name to search for: ");
        String toSearch = console.next();
       
        
        
        //Arrays.sort(customers);        
        Arrays.sort(customers, new Comparator<Object>() {
       @Override
       public int compare(Object o1, Object o2) {
           if (o1 == null && o2 == null) {
               return 0;
           }
           if (o1 == null) {
               return 1;
           }
           if (o2 == null) {
               return -1;
           }
           Customer c1 = (Customer)o1;
           Customer c2 = (Customer)o2;
           return c1.getName().compareTo(c2.getName());
       }});        
        
        for (int i = 0; i < idCounter - 1; i++)
        {
            Customer customer = customers[i];
            System.out.println(customers[i].getName());
        }        
        
        int first = 0;
        int last = idCounter - 1;

        int mid = 0;
        
        boolean found = false;

        try {
            while (first <= last) {
            mid = (first + last) / 2;
            //this here might need to be modified
            if (customers[mid].getName().compareTo(toSearch) < 0 ) {
                first = mid + 1;
            } else if (customers[mid].getName().compareTo(toSearch) > 0) {
                last = mid - 1;
            } else {
                found = true;
                first = last + 1;
            }
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
        if (found) {
            System.out.println(customers[mid].toString());
        } else {
            System.out.println("Customer not found.");
        }
        
    }
    
    public static void main(String[] args) {
        
        String decision;
        int checkId;
        Assessment2DArray arrayApp = new Assessment2DArray();
        
        arrayApp.initializeSeatingPlan();        
        
        do{
            System.out.println("[view]\t\t to view current seating plan.");
            System.out.println("[add]\t\t to add a new booking.");
            //System.out.println("[edit]\t to edit an existing booking.");
            System.out.println("[delete]\t to delete an existing booking.");
            System.out.println("[customer]\t to see customer details.");
            System.out.println("[search]\t to search customers by name.");
            System.out.println("[exit]\t\t to close program.");
            decision = console.next();
            switch (decision){
                case "view":                    
                    arrayApp.displaySeats();
                    break;
                case "add":
                    //method to add a customer booking
                    customers[idCounter] = arrayApp.addCustomer();
                    idCounter++;
                    break;
/*                case "edit":
                    //method to edit an existing customer booking
                    break;
*/
                case "customer" :
                    System.out.println("Enter the Id associated with your seat: ");
                    checkId = console.nextInt();
                    arrayApp.viewCustomer(checkId);
                    break;
                case "search" :
                    //stuff in here should take in a copy of the customers array, sort it in alphabetical order, then
                    //search it for a specific name
                    arrayApp.searchCustomers();
                    break;
                case "delete":
                    //method to delete an existing customer booking
                    System.out.println("Enter the Id associated with your seat: ");
                    checkId = console.nextInt();
                    arrayApp.cancelSeatAllocation(checkId);
                    break;
                default:
                    break;
            }
        } while (!"exit".equals(decision));
        
                
        

        
        
        
    }
    
    
    
    
}
