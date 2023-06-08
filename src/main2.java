import java.util.Scanner;

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
    private void ViewIncome(){
        System.out.println("Total Income : "+ (burgerCount*650));
    }

    //----------------------  Name / burger Validation Part  -------------------------
    String customerName = "";
    public String nameValid(String nameType) {
        while (true) {
            Scanner route = new Scanner(System.in);
            System.out.print("Enter Your " + nameType + ": ");
            String name = route.nextLine();
            if (!name.isEmpty() && !name.trim().isEmpty()) {
                try {
                    Integer.parseInt(name);
                    System.out.println("Enter a valid name");
                } catch (NumberFormatException e) {
                    customerName = name.toUpperCase();
                    break;
                }
            } else {
                System.out.println("Enter a valid name");
            }
        }
        return customerName;
    }


     int cashierCustomers1 = 0;
     int cashierCustomers2 = 0;
    int cashierCustomers3 = 0;
    int totalCustomers = 0;
    int burgerCount = 0 ;
    static final int MaxCashierCustomers1 = 2;
    static final int MaxCashierCustomers2 = 3;
    static final int MaxCashierCustomers3 = 5;
    static final int maxCustomers=10;



    //----------------- Class burger count and Validation -------------------------------------

    public int burgerCount(String NoOfBurgers){

        System.out.println("No of " + NoOfBurgers +" : ");
        Scanner route = new Scanner(System.in);
        int BurgerRequaired = route.nextInt();
        burgerCount = (BurgerRequaired+burgerCount);

        return BurgerRequaired;
    }


    static class customers{

        main2 validateName = new main2();
        String firstName = validateName.nameValid("First Name");
        String lastName = validateName.nameValid("Last Name");

        main2 objBurger = new main2();
        int RequairedBurger = objBurger.burgerCount("Burgers Requaired");

    }

    //------------------------------ Food Queue Part ------------------------------------



    class foodQueue{
        public void queue() {

            Scanner route = new Scanner(System.in);

            while (true) {
                try {
                    if (totalCustomers == maxCustomers) {
                        System.out.println("All cashiers are full. Program exiting...");
                    }

                    System.out.print("Enter the cashier number (1, 2, 3): ");
                    int cashierNumber = route.nextInt();

                    switch (cashierNumber) {
                        case 1:
                            if (cashierCustomers1 < MaxCashierCustomers1) {
                                cashierCustomers1++;
                                totalCustomers++;
                                System.out.println("Customer added to cashier 1");
                            } else {
                                System.out.println("Cashier 1 is full. Please choose another cashier.");
                            }
                            break;

                        case 2:
                            if (cashierCustomers2 < MaxCashierCustomers2) {
                                cashierCustomers2++;
                                totalCustomers++;
                                System.out.println("Customer added to cashier 2");
                            } else {
                                System.out.println("Cashier 2 is full. Please choose another cashier.");
                            }
                            break;

                        case 3:
                            if (cashierCustomers3 < MaxCashierCustomers3) {
                                cashierCustomers3++;
                                totalCustomers++;
                                System.out.println("Customer added to cashier 3");
                            } else {
                                System.out.println("Cashier 3 is full. Please choose another cashier.");
                            }
                            break;

                        default:
                            System.out.println("Invalid cashier number. Please try again.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    route.nextLine();
                }
            }
        }
    }


    //-------------------------- Food Option Part ------------------------------------------

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
        System.out.println("110 or ACQ: View income of each Queue.");
        System.out.println("999 or EXT: Exit the Program.");
        return ;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------

    //----------------------- ------------------Main Method -------------------------------------------------------------------

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
            main2.customers customer = new main2.customers();
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
        } else if (inputMenu.equals("110") || inputMenu.equals("IFQ")) {
            obj.ViewIncome();
        } else if(inputMenu.equals("999") || inputMenu.equals("EXT")){
            obj.Exit();
        }
    }
}
