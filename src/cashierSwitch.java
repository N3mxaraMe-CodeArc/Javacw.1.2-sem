import java.util.Scanner;

public class cashierSwitch {

    private static final int MaxCashierCustomers1 = 2;
    private static final int MaxCashierCustomers2 = 3;
    private static final int MaxCashierCustomers3 = 5;
    private static final int MaxCashierCount = 5;


    public static void main(String[] args) {

        int cashierCustomers1 = 0;
        int cashierCustomers2 = 0;
        int cashierCustomers3 = 0;
        int totalCustomer = 0;
        int maxCustomers = 10;

        Scanner route = new Scanner(System.in);

        while (true) {
            try {
                if (totalCustomer == maxCustomers) {
                    System.out.println("All cashiers are full. Program exiting...");
                    break;
                }

                System.out.print("Enter the cashier number (1, 2, 3): ");
                int cashierNumber = route.nextInt();

                switch (cashierNumber) {
                    case 1:
                        if (cashierCustomers1 < MaxCashierCustomers1) {
                            cashierCustomers1++;
                            totalCustomer++;
                            System.out.println("Customer added to cashier 1");
                            break;
                        } else {
                            System.out.println("Cashier 1 is full. Please choose another cashier.");
                        }
                        break;

                    case 2:
                        if (cashierCustomers2 < MaxCashierCustomers2) {
                            cashierCustomers2++;
                            totalCustomer++;
                            System.out.println("Customer added to cashier 2");
                            break;
                        } else {
                            System.out.println("Cashier 2 is full. Please choose another cashier.");
                        }
                        break;

                    case 3:
                        if (cashierCustomers3 < MaxCashierCustomers3) {
                            cashierCustomers3++;
                            totalCustomer++;
                            System.out.println("Customer added to cashier 3");
                            break;
                        } else {
                            System.out.println("Cashier 3 is full. Please choose another cashier.");
                        }
                        break;

                    default:
                        System.out.println("Invalid cashier number. Please try again.");
                        continue;
                }

                if (totalCustomer == maxCustomers) {
                    System.out.println("All cashiers are full. Program exiting...");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                route.nextLine();
            }

        }

        route.close();
    }
}
