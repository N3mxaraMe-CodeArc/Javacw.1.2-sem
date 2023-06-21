import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {

    static String[] Queue1 = new String[2];
    static String[] Queue2 = new String[3];
    static String[] Queue3 = new String[5];
    String customerName = "";

    static int cashierCustomers1 = 0;
    static int cashierCustomers2 = 0;
    static int cashierCustomers3 = 0;
    static int totalCustomers = 0;

    static int burgerCount = 50;
    static int SoldBurgers = 0;
    static final int MaxCashierCustomers1 = 2;
    static final int MaxCashierCustomers2 = 3;
    static final int MaxCashierCustomers3 = 5;
    static final int maxCustomers = 10;

    public static void main(String[] args) {

        System.out.println(System.lineSeparator() + "Methods Of the foody fav ");
        System.out.println("===========*****============" + System.lineSeparator());

        //calling to menu method from main method
        Main mainprogram = new Main();
        mainprogram.foodoptions();


        while (true) {
            //Calling a input to continue
            Scanner route = new Scanner(System.in);
            System.out.print("Input the method number to continue : ");
            String inputMenu = route.nextLine().toUpperCase();


            switch (inputMenu) {
                case "100", "VFQ":
                    mainprogram.viewAllQueues();
                    break;
                case "101", "VEQ":
                    mainprogram.viewEmptyQueues();
                    break;
                case "102", "ACQ":
                    mainprogram.addCustomerToQueues();
                    break;
                case "103" , "RCQ":
                    mainprogram.RemCustomerToQueues();
                    break;
                case "104" , "PCQ":
                    mainprogram.RemServeCustomer();
                    break;
                case "105","VCS":
                    mainprogram.sortedCustomer();
                    break;
                case "106","SPD":
                    mainprogram.storeProgrameDataF();
                    break;
                case "107","LPD":
                    mainprogram.loadProgrameDataF();
                    break;
                case "108" , "STK":
                    mainprogram.viewRemainBurgers();
                    break;
                case "109","AFS":
                    mainprogram.addBurgerToStock();
                    break;
                case "110","IFQ":
                    mainprogram.ViewIncome();
                    break;
                case "999" , "EXT":
                    mainprogram.Exit();
                    break;
                default:
                    System.out.println("Please enter the Valid Method");
            }
        }
    }

    private void viewAllQueues() {

        Main mainProgram = new Main();

        System.out.println("Cashier No.1");
        for (String item : Queue1) {
            System.out.println(item);
        }

        System.out.println("Cashier No.2");
        for (String item : Queue2) {
            System.out.println(item);
        }

        System.out.println("Cashier No.3");
        for (String item : Queue3) {
            System.out.println(item);
        }

        System.out.println("""
                ***************************************************
                
                *          *************************         *
                *          *  ---> Foody Fav <---  *         *
                *          *************************         *
                """);
        mainProgram.FlowDiagram();





        System.out.println("Remaining burgers : " + burgerCount);
        System.out.println("Total Number of customers : " + totalCustomers);
        System.out.println("Total Number of customers in this moment : " + (cashierCustomers1+cashierCustomers2+cashierCustomers3));
        System.out.println("Customers In Cashier 1 : " + cashierCustomers1);
        System.out.println("Customers In Cashier 2 : " + cashierCustomers2);
        System.out.println("Customers In Cashier 3 : " + cashierCustomers3);

        //Display cashier counters

        System.out.println("( X – Not Occupied / O – Occupied )");

    }

    private void viewEmptyQueues() {

        System.out.println("""
                ============================================================================
                ============================ * Empty Queues * ==============================
                ============================================================================
                """);

        for(int i=0; i<Queue1.length; i++){
            if (Queue1[i] == null){
                System.out.println("Cashier 1 position "+ (i+1) + " is empty");
            }
        }
        for(int i=0; i<Queue2.length; i++){
            if (Queue2[i] == null){
                System.out.println("Cashier 2 position "+ (i+1) + " is empty");
            }
        }
        for(int i=0; i<Queue3.length; i++){
            if (Queue3[i] == null){
                System.out.println("Cashier 3 position "+ (i+1) + " is empty");
            }
        }
        System.out.println("""
                
                ============================================================================
                ============================================================================
                """);
    }

    private void addCustomerToQueues() {
        String firstName = nameValid("First Name");
        String lastName = nameValid("Last Name");


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

                            for (int i = 0; i < Queue1.length; i++) {
                                if (Queue1[i] == null) {
                                    Queue1[i] = firstName;
                                    break;
                                }
                            }

                            System.out.println("Customer added to cashier 1.\n======================================================================");
                            if (cashierCustomers1 == 1) {
                                System.out.println("Alert : Remaining Only 1 Customer to add Cashier Number 1");
                            } else if (cashierCustomers1 == MaxCashierCustomers1) {
                                System.out.println("Warning : Cashier Number 1 is in Maximum Customers");
                            }

                            break;
                        } else {
                            System.out.println("Cashier 1 is full. Please choose another cashier.");
                            continue;
                        }


                    case 2:
                        if (cashierCustomers2 < MaxCashierCustomers2) {
                            cashierCustomers2++;
                            totalCustomers++;
                            for (int i = 0; i < Queue2.length; i++) {
                                if (Queue2[i] == null) {
                                    Queue2[i] = firstName;
                                    break;
                                }
                            }
                            System.out.println("Customer added to cashier 2\n======================================================================");
                            if (cashierCustomers2 == 2) {
                                System.out.println("Alert : Remaining Only 1 Customer to add Cashier Number 2");
                            } else if (cashierCustomers2 == MaxCashierCustomers2) {
                                System.out.println("Warning : Cashier Number 2 is in Maximum Customers");
                            }
                            break;
                        } else {
                            System.out.println("Cashier 2 is full. Please choose another cashier.");
                        }
                        continue;

                    case 3:
                        if (cashierCustomers3 < MaxCashierCustomers3) {
                            cashierCustomers3++;
                            totalCustomers++;
                            for (int i = 0; i < Queue3.length; i++) {
                                if (Queue3[i] == null) {
                                    Queue3[i] = firstName;
                                    break;
                                }
                            }

                            System.out.println("Customer added to cashier 3\n======================================================================");
                            if (cashierCustomers3 == 4) {
                                System.out.println("Alert : Remaining Only 1 Customer to add Cashier Number 3");
                            } else if (cashierCustomers3 == MaxCashierCustomers3) {
                                System.out.println("Warning : Cashier Number 3 is in Maximum Customers");
                            }
                            break;
                        } else {
                            System.out.println("Cashier 3 is full. Please choose another cashier.");
                        }
                        continue;

                    default:
                        System.out.println("Invalid cashier number. Please try again.");

                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                route.nextLine();
                continue;
            }
            if (cashierCustomers1 == 2 && cashierCustomers2 == 3 && cashierCustomers3 == 5) {
                System.out.println("=============== * All Cashiers Are Full * =====================");
            }
            if (burgerCount <= 10 && burgerCount >= 1) {
                System.out.println("======================================================================\n" +
                        "========== * Alert : There are " + burgerCount + " Burgers are remaining * ==========");
            } else if (burgerCount == 0) {
                System.out.println("Burgers are out of stock");
            }
            System.out.println("======================================================================");
            break;
        }
    }

    //================================================================================================
    private void RemCustomerToQueues() {
        Scanner route = new Scanner(System.in);
        System.out.print("Enter the Cashier No : ");
        int CashierNum = route.nextInt();
        System.out.print("Enter the Customer No : ");
        int CustomerNum = route.nextInt();

        switch (CashierNum) {
            case 1:
                if (Queue1[CustomerNum - 1] != null){
                    if (CustomerNum >= 0 && CustomerNum < Queue1.length) {
                        Queue1[CustomerNum-1] = null;
                        shiftElements(Queue1, CustomerNum);
                        cashierCustomers1--;
                        totalCustomers--;
                        System.out.println("Customer removed from cashier 1.\n======================================================================");
                    } else if (CustomerNum == 2) {
                        Queue1[1] = null;
                        totalCustomers--;
                        cashierCustomers1--;
                        System.out.println("Customer removed from cashier 1.\n======================================================================");
                    } else {
                        System.out.println("Invalid customer number for cashier 1.");
                    }
                    break;
                }else {
                    System.out.println("There are no customers in entered space");
                }

            case 2:
                if (Queue2[CustomerNum - 1] != null){
                    if (CustomerNum >= 0 && CustomerNum < Queue2.length) {
                    Queue2[CustomerNum-1] = null;
                    shiftElements(Queue2, CustomerNum);
                    cashierCustomers2--;
                    totalCustomers--;
                    System.out.println("Customer removed from cashier 2.\n======================================================================");
                }else if (CustomerNum == 3) {
                    Queue2[2] = null;
                    cashierCustomers2--;
                    totalCustomers--;
                    System.out.println("Customer removed from cashier 2.\n======================================================================");
                } else {
                    System.out.println("Invalid customer number for cashier 2.");
                }
                break;
                }else {
                    System.out.println("There are no customers in entered space");
                }

            case 3:
                if (Queue3[CustomerNum - 1] != null){
                    if (CustomerNum >= 0 && CustomerNum < Queue3.length) {
                        Queue3[CustomerNum-1] = null;
                        shiftElements(Queue3, CustomerNum);
                        cashierCustomers3--;
                        totalCustomers--;
                        System.out.println("Customer removed from cashier 3.\n======================================================================");
                    }else if (CustomerNum == 5) {
                        Queue3[4] = null;
                        cashierCustomers3--;
                        totalCustomers--;
                        System.out.println("Customer removed from cashier 3.\n======================================================================");
                    } else {
                        System.out.println("Invalid customer number for cashier 3.");
                    }
                    break;
                }else {
                    System.out.println("There are no customers in entered space");
                }

            default:
                System.out.println("Invalid cashier number. Please try again.");
                break;
        }
    }
    private void shiftElements(String[] queue, int startIndex) {
        for (int i = startIndex; i < queue.length - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[queue.length - 1] = null;
    }

    //=================================================================================================


    private void RemServeCustomer() {
        Scanner route = new Scanner(System.in);
        System.out.print("Enter the Cashier Number : ");
        int CashierNum = route.nextInt();

        switch (CashierNum){
            case 1 :
                if (CashierNum > 0 && CashierNum <= 3) {
                    Queue1[0] = null;
                    shiftElements(Queue1, 0);
                    cashierCustomers1--;
                    burgerCount = (burgerCount - 5);
                    System.out.println("1 Cashier Served Customer is Removed");
                    break;
                }else {
                    System.out.println("Enter the valid Cashier Number");
                }
            case 2:
                if (CashierNum > 0 && CashierNum <= 3) {
                    Queue2[0] = null;
                    shiftElements(Queue2, 0);
                    cashierCustomers2--;
                    burgerCount = (burgerCount - 5);
                    System.out.println("2 Cashier Served Customer is Removed");
                    break;
                }else {
                    System.out.println("Enter the valid Cashier Number");
                }
            case 3:
                if (CashierNum > 0 && CashierNum <= 3) {
                    Queue3[0] = null;
                    shiftElements(Queue3, 0);
                    cashierCustomers3--;
                    burgerCount = (burgerCount - 5);
                    System.out.println("3 Cashier Served Customer is Removed");
                    break;
                }else {
                    System.out.println("Enter the valid Cashier Number");
                }
            default:
                System.out.println("Enter the valid Cahier Number ");
            }
        }

    private void sortedCustomer() {

        String[] mergedQueue = new String[cashierCustomers1 + cashierCustomers2 + cashierCustomers3];
        System.arraycopy(Queue1, 0, mergedQueue, 0, cashierCustomers1);
        System.arraycopy(Queue2, 0, mergedQueue, cashierCustomers1, cashierCustomers2);
        System.arraycopy(Queue3, 0, mergedQueue, cashierCustomers1 + cashierCustomers2, cashierCustomers3);

        bubbleSort(mergedQueue);

        System.out.println("Sorted Customers:");
        for (int i = 0; i < mergedQueue.length; i++) {
            System.out.println(mergedQueue[i]);
        }
    }

    private void bubbleSort(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void storeProgrameDataF() {

        try {
            FileWriter fileWriter = new FileWriter("ProgramData.txt");
            fileWriter.write("Cashier 1 Customers: " + Arrays.toString(Queue1) + System.lineSeparator());
            fileWriter.write("Cashier 2 Customers: " + Arrays.toString(Queue2) + System.lineSeparator());
            fileWriter.write("Cashier 3 Customers: " + Arrays.toString(Queue3) + System.lineSeparator());
            fileWriter.close();
            System.out.println("Program data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }


    private void loadProgrameDataF() {
        try (Scanner scanner = new Scanner(new File("ProgramData.txt"))) {
            String programData = scanner.nextLine();
            String[] data = programData.split(";");
            burgerCount = Integer.parseInt(data[0]);
            cashierCustomers1 = Integer.parseInt(data[1]);
            cashierCustomers2 = Integer.parseInt(data[2]);
            cashierCustomers3 = Integer.parseInt(data[3]);

            System.out.println("Program data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Program data file not found. No data loaded.");
        }
    }


    private void viewRemainBurgers() {
        System.out.println("Remaining Burgers : " + burgerCount);
    }

    private void addBurgerToStock() {
        Scanner route = new Scanner(System.in);
        while (true){
            try {
                System.out.print("No of burgers do you added : ");
                int addedBurgers = route.nextInt();

                burgerCount = (burgerCount + addedBurgers);
                System.out.println(addedBurgers + " Burgers added to queue");
                System.out.println("Now there are " + burgerCount + " burgers in burger stock");
                break;

            }catch (Exception e){
                System.out.println("! Enter the Valid Number");
                route.nextLine();
            }
            break;
        }
    }

    private void Exit() {
        System.out.println("Exiting the program...");
        System.exit(0);
    }

    private void ViewIncome() {
        SoldBurgers = (50 - burgerCount);
        System.out.println("Total Income : Rs." + (SoldBurgers * 650) + ".00");
    }
    private void FlowDiagram() {
        String[] flowQueue1 = Queue1.clone();
        String[] flowQueue2 = Queue2.clone();
        String[] flowQueue3 = Queue3.clone();

        for (int i = 0; i < flowQueue1.length; i++) {
            if (flowQueue1[i] != null) {
                flowQueue1[i] = " O ";
            } else {
                flowQueue1[i] = " X ";
            }
        }

        for (int i = 0; i < flowQueue2.length; i++) {
            if (flowQueue2[i] != null) {
                flowQueue2[i] = " O ";
            } else {
                flowQueue2[i] = " X ";
            }
        }

        for (int i = 0; i < flowQueue3.length; i++) {
            if (flowQueue3[i] != null) {
                flowQueue3[i] = " O ";
            } else {
                flowQueue3[i] = " X ";
            }
        }

        System.out.println("""
        Cashier 1           cashier 2            Cashier3
        """);

        System.out.println(" " + flowQueue1[0] + "                  " + flowQueue2[0] + "                  " + flowQueue3[0]);
        System.out.println(" " + flowQueue1[1] + "                  " + flowQueue2[1] + "                  " + flowQueue3[1]);
        System.out.println("                      " + flowQueue2[2] + "                  " + flowQueue3[2]);
        System.out.println("                                           " + flowQueue3[3]);
        System.out.println("                                           " + flowQueue3[4]);

        System.out.println("""
        
        ***************************************************
        ***************************************************
        """);
    }

    //----------------------  Name / burger Validation Part  -------------------------

    public String nameValid(String nameType) {
        while (true) {
            Scanner route = new Scanner(System.in);
            System.out.print("Enter Your " + nameType + ": ");
            String name = route.nextLine();
            if (!name.isEmpty() && !name.trim().isEmpty() && !name.matches(".*[0-9!@#$%^&*(),.?\":{}|<>]+.*")) {
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
        //-------------------------- Food Option Part ------------------------------------------

    public void foodoptions() {
        String menu = """
                100 or VFQ: View all Queues.
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue. (From a specific location).
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine).
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining burgers Stock.
                109 or AFS: Add burgers to Stock.
                110 or ACQ: View income of each Queue.
                999 or EXT: Exit the Program.
                ============================================================================================""";

        System.out.println(menu);
        return;
    }
}
