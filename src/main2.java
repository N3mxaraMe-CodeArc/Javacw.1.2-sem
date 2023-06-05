import java.util.Scanner;

public class main2 {

    private void viewAllQueues(){
        System.out.println("Show All quoues");
    }
    private void viewEmptyQueues(){
        System.out.println("Empty Quoues");
    }
    private void addCustomerToQueues(){
        System.out.println("Add customer to quoues");
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
        System.out.println("999 or EXT: Exit the Program.\n");
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
        String inputMenu = route.nextLine();

        //import main method objects
        main2 emptyquoues = new main2();

        //Select quoue method

        if (inputMenu.equals("100") || inputMenu.equals("VFQ")){
            emptyquoues.viewAllQueues();
        }
        else if(inputMenu.equals("101") || inputMenu.equals("VEQ")){
            emptyquoues.viewEmptyQueues();
        }
        else if(inputMenu.equals("102") || inputMenu.equals("ACQ")){
            emptyquoues.addCustomerToQueues();
        }






    }
}
