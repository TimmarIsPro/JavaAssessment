/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment2darray;
import java.util.Arrays;
import java.util.*;

/**
 *
 * @author J380446
 */
public class Assessment2DArray {
    
    static Scanner console = new Scanner(System.in);

    static String seatingPlan[][] = new String[13][8];
    static Customer customers[] = new Customer[75]; //maximum number of seats plus some leeway i guess
            
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
        
        if (newCustomer.getClassType() == "F") {
            if (newCustomer.getSeatType() == "W") {
		//window seats are [1,1] [2,1] [1,7] [2,7] for first class in array
                //double for-loops to search in the specific rows(1 and 7) and columns(1 and 2) 
                
            } else if (newCustomer.getSeatType() == "M") {
                //middle seats are [1,2] [2,2] [1,6] [2,6] for first class
	
            } else if (newCustomer.getSeatType() == "A") {
                //aisle seats are [1,3] [2,3] [1,5] [2,5] for first class
                
            }
        }
        
        return newCustomer;
    }
    
            
            
            
    public static void main(String[] args) {
        
        String decision;
        Assessment2DArray arrayApp = new Assessment2DArray();
        
        arrayApp.initializeSeatingPlan();
        
        
        do{
            System.out.println("[view]\t to view current seating plan.");
            System.out.println("[add]\t to add a new booking.");
            System.out.println("[edit]\t to edit an existing booking.");
            System.out.println("[delete] to delete an existing booking.");
            System.out.println("[exit]\t to close program.");
            decision = console.next();
            switch (decision){
                case "view":                    
                    arrayApp.displaySeats();
                    break;
                case "add":
                    //method to add a customer booking
                    break;
                case "edit":
                    //method to edit an existing customer booking
                    break;
                case "delete":
                    //method to delete an existing customer booking
                    break;
                default:
                    break;
            }
        } while (!"exit".equals(decision));
        
                
        

        
        
        
    }
    
    
    
    
}
