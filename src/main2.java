import java.util.Scanner;
import java.util.Stack;

public class main2 {

    private void viewAllQueues(){

        for (int i=0; i<17; i++){
            System.out.print("*");
        }
        System.out.println("*");
        System.out.print("*    Cashiers    ");
        System.out.println("*");
        for (int i=0; i<17; i++){
            System.out.print("*");
        }
        System.out.println("*");
        //Display cashier counters

        System.out.println("( X – Not Occupied / O – Occupied )");

    }
    private void viewEmptyQueues(){
        System.out.println("Empty Quoues");
    }
    private void addCustomerToQueues(){
        System.out.println("Add customer to quoues");
    }
    private void RemCustomerToQueues(){
        System.out.println("Remove customer to quoues");
    }
    private void RemServeCustomer(){
        System.out.println("Remove Served customer to quoues");
    }
    private void sortedCustomer(){
        System.out.println("View Customers Sorted in alphabetical order");
    }
    private void storeProgrameDataF(){
        System.out.println("Store Program Data into file");
    }
    private void loadProgrameDataF(){
        System.out.println("Load Program Data from file");
    }
    private void viewRemainBurgers(){
        System.out.println("Load Program Data from file");
    }
    private void addBurgerToStock(){
        System.out.println("Load Program Data from file");
    }
    private void Exit(){
        System.out.println("Load Program Data from file");
    }

    static class customers{

    }

    static class foodQueue{

    }

    public void foodoptions(){
        System.out.println ("100 or VFQ: View all Queues.");
        System.out.println ("101 or VEQ: View all Empty Queues.");
        System.out.println ("102 or ACQ: Add customer to a Queue.");
        System.out.println("103 or RCQ: Remove a customer from a Queue. (From a specific location)");
        System.out.println("104 or PCQ: Remove a served customer.");
        System.out.println("105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine)");
        System.out.println("106 or SPD: Store Program Data into file.");
        System.out.println("107 or LPD: Load Program Data from file.");
        System.out.println("108 or STK: View Remaining burgers Stock.");
        System.out.println("109 or AFS: Add burgers to Stock.");
        System.out.println("999 or EXT: Exit the Program.");
        return ;
    }

    private static final int MaxCashierCustomers1 = 2;
    private static final int MaxCashierCustomers2 = 3;
    private static final int MaxCashierCustomers3 = 5;
    public static void main(String[] args) {

        System.out.println(System.lineSeparator()+"Methods Of the foody fav ");
        System.out.println("===========*****============" + System.lineSeparator());

        //calling to menu method from main method
        main2 obj = new main2();
        obj.foodoptions();

        //Calling a input to continue
        Scanner route = new Scanner(System.in);
        System.out.print("Press the method number to continue : ");
        String inputMenu = route.nextLine().toUpperCase();


        //Select quoue method

        if (inputMenu.equals("100") || inputMenu.equals("VFQ")){
            obj.viewAllQueues();
        }
        else if(inputMenu.equals("101") || inputMenu.equals("VEQ")){
            obj.viewEmptyQueues();
        }
        else if(inputMenu.equals("102") || inputMenu.equals("ACQ")){
            obj.addCustomerToQueues();
        }
        else if(inputMenu.equals("103") || inputMenu.equals("RCQ")){
            obj.RemCustomerToQueues();
        }
        else if(inputMenu.equals("104") || inputMenu.equals("PCQ")){
            obj.RemServeCustomer();
        }
        else if(inputMenu.equals("105") || inputMenu.equals("VCS")){
            obj.sortedCustomer();
        }
        else if(inputMenu.equals("106") || inputMenu.equals("SPD")){
            obj.storeProgrameDataF();
        }
        else if(inputMenu.equals("107") || inputMenu.equals("LPD")){
            obj.loadProgrameDataF();
        }
        else if(inputMenu.equals("108") || inputMenu.equals("STK")){
            obj.viewRemainBurgers();
        }
        else if(inputMenu.equals("109") || inputMenu.equals("AFS")){
            obj.addBurgerToStock();
        }
        else if(inputMenu.equals("999") || inputMenu.equals("EXT")){
            obj.Exit();
        }
    }
}
