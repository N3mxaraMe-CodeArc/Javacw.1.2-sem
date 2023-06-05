import java.util.Scanner;

public class Main {

    String customerName = "";
    int burgercount = 0;
    int remBurgerCount = 50;

    private static final int MaxCashierCustomers1 = 2;
    private static final int MaxCashierCustomers2 = 3;
    private static final int MaxCashierCustomers3 = 5;
    private static final int MaxCashierCount = 5;

    private int cashierCustomers1 = 0;
    private int cashierCustomers2 = 0;
    private int cashierCustomers3 = 0;
    private int totalCustomers = 0;

    public void cashierChecker() {
        int maxCustomers = 10;
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
                            break;
                        } else {
                            System.out.println("Cashier 1 is full. Please choose another cashier.");
                        }
                        continue;

                    case 2:
                        if (cashierCustomers2 < MaxCashierCustomers2) {
                            cashierCustomers2++;
                            totalCustomers++;
                            System.out.println("Customer added to cashier 2");
                            break;
                        } else {
                            System.out.println("Cashier 2 is full. Please choose another cashier.");
                        }
                        continue;

                    case 3:
                        if (cashierCustomers3 < MaxCashierCustomers3) {
                            cashierCustomers3++;
                            totalCustomers++;
                            System.out.println("Customer added to cashier 3");
                            break;
                        } else {
                            System.out.println("Cashier 3 is full. Please choose another cashier.");
                        }
                        continue;

                    default:
                        System.out.println("Invalid cashier number. Please try again.");
                        continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                route.nextLine();
                continue;
            }
            break;

        }
    }

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

    public static void main(String[] args) {
        Main cashierChoose = new Main();
        Main validateName = new Main();

        while (true) {
            cashierChoose.cashierChecker();

            String firstName = validateName.nameValid("First Name");
            String lastName = validateName.nameValid("Last Name");

            while (true) {
                Scanner route2 = new Scanner(System.in);
                System.out.print("Enter the number of burgers you need: ");
                String inputBurgerCount = route2.nextLine();

                if (!inputBurgerCount.isEmpty() && !inputBurgerCount.trim().isEmpty()) {
                    try {
                        validateName.burgercount = Integer.parseInt(inputBurgerCount);
                        if (validateName.burgercount > 5) {
                            System.out.println("Sorry, you can buy a maximum of 5 pieces of burgers. Please try again.");
                        } else if (validateName.burgercount < 1) {
                            System.out.println("Enter a Valid Number");
                        } else {
                            validateName.remBurgerCount= (validateName.remBurgerCount- validateName.burgercount);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid Burger Count");
                    }
                } else {
                    System.out.println("Enter a valid Burger Count");
                }
            }

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("Customer Name: " + firstName + " " + lastName);
            System.out.println("Number of burgers: " + validateName.burgercount);
            System.out.println("Cashier Number : " + cashierChoose);

            //-----------------------------------------------------------------------------------

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------");

            Scanner route = new Scanner(System.in);
            System.out.print("If you need to exit, press 'Q'. To continue, press 'C': ");
            String exitChoice = route.nextLine().toUpperCase();

            if (exitChoice.equals("Q")) {
                for (int i = 0; i < 50; i++) {
                    System.out.print("*");
                }
                System.out.println("");
                System.out.println("");
                for (int i = 0; i < 50; i++) {
                    System.out.print("*");
                }
                System.out.println("");

                //---------------------------------------End of Histogram-----------------------------------------------------------------



                //--------------------------------------Customer Counts------------------------------------------------------------------

                System.out.println("Number of customers at Cashier 1: " + cashierChoose.cashierCustomers1);
                System.out.println("Number of customers at Cashier 2: " + cashierChoose.cashierCustomers2);
                System.out.println("Number of customers at Cashier 3: " + cashierChoose.cashierCustomers3);
                System.out.println("Total number of customers: " + cashierChoose.totalCustomers);
                break;
            } else if (exitChoice.equals("C")) {
                continue;
            } else {
                System.out.println("Enter a valid choice (Q or C)");
            }
        }
        //--------------------------------------Remaining burgers-----------------------------------------------------------------

        System.out.println("Remaining burgers = " + validateName.remBurgerCount);
    }
}