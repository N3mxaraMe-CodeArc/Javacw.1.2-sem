import java.io.*;
import java.util.*;

public class FoodiesFaveFoodCenter {
    private static List<String> cashier1_queue = new ArrayList<>();
    private static List<String> cashier2_queue = new ArrayList<>();
    private static List<String> cashier3_queue = new ArrayList<>();
    private static int stock = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            switch (choice) {
                case 100:
                    printQueues();
                    break;
                case 101:
                    int emptyQueues = countEmptyQueues();
                    System.out.println("Number of empty queues: " + emptyQueues);
                    break;
                case 102:
                    addCustomer(scanner);
                    break;
                case 103:
                    removeCustomer(scanner);
                    break;
                case 104:
                    removeServedCustomer();
                    break;
                case 105:
                    viewCustomersSorted();
                    break;
                case 106:
                    storeProgramData();
                    break;
                case 107:
                    loadProgramData();
                    break;
                case 108:
                    printStock();
                    break;
                case 109:
                    addBurgers(scanner);
                    break;
                case 999:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("*****************");
        System.out.println("* Cashiers      *");
        System.out.println("*****************");
        printQueues();
        System.out.println("Menu options:");
        System.out.println("100 or VFQ: View all Queues");
        System.out.println("101 or VEQ: View all Empty Queues");
        System.out.println("102 or ACQ: Add customer to a Queue");
        System.out.println("103 or RCQ: Remove a customer from a Queue (From a specific location)");
        System.out.println("104 or PCQ: Remove a served customer");
        System.out.println("105 or VCS: View Customers Sorted in alphabetical order");
        System.out.println("106 or SPD: Store Program Data into file");
        System.out.println("107 or LPD: Load Program Data from file");
        System.out.println("108 or STK: View Remaining burgers Stock");
        System.out.println("109 or AFS: Add burgers to Stock");
        System.out.println("999 or EXT: Exit the Program");
        System.out.print("Enter your choice: ");
    }

    private static void printQueues() {
        System.out.println("Queue 1: " + getQueueStatus(cashier1_queue));
        System.out.println("Queue 2: " + getQueueStatus(cashier2_queue));
        System.out.println("Queue 3: " + getQueueStatus(cashier3_queue));
    }

    private static String getQueueStatus(List<String> queue) {
        int occupied = queue.size();
        int notOccupied = getQueueCapacity(queue) - occupied;
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < occupied; i++) {
            status.append("O ");
        }
        for (int i = 0; i < notOccupied; i++) {
            status.append("X ");
        }
        return status.toString().trim();
    }

    private static int getQueueCapacity(List<String> queue) {
        if (queue == cashier1_queue) {
            return 2;
        } else if (queue == cashier2_queue) {
            return 3;
        } else if (queue == cashier3_queue) {
            return 5;
        }
        return 0;
    }

    private static int countEmptyQueues() {
        int emptyQueues = 0;
        if (cashier1_queue.isEmpty()) {
            emptyQueues++;
        }
        if (cashier2_queue.isEmpty()) {
            emptyQueues++;
        }
        if (cashier3_queue.isEmpty()) {
            emptyQueues++;
        }
        return emptyQueues;
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter queue number (1, 2, or 3): ");
        int queueNumber;
        try {
            queueNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid queue number. Please try again.");
            return;
        }

        List<String> selectedQueue = getQueueByNumber(queueNumber);
        if (selectedQueue != null) {
            if (selectedQueue.size() < getQueueCapacity(selectedQueue)) {
                System.out.print("Enter customer name: ");
                String customerName = scanner.nextLine();
                selectedQueue.add(customerName);
                stock -= 5;
                checkStock();
                System.out.println("Customer added to Queue " + queueNumber);
            } else {
                System.out.println("Queue " + queueNumber + " is already full.");
            }
        } else {
            System.out.println("Invalid queue number.");
        }
    }

    private static List<String> getQueueByNumber(int queueNumber) {
        switch (queueNumber) {
            case 1:
                return cashier1_queue;
            case 2:
                return cashier2_queue;
            case 3:
                return cashier3_queue;
            default:
                return null;
        }
    }

    private static void removeCustomer(Scanner scanner) {
        System.out.print("Enter queue number (1, 2, or 3): ");
        int queueNumber;
        try {
            queueNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid queue number. Please try again.");
            return;
        }

        System.out.print("Enter customer position in the queue: ");
        int position;
        try {
            position = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid position. Please try again.");
            return;
        }

        List<String> selectedQueue = getQueueByNumber(queueNumber);
        if (selectedQueue != null) {
            if (position > 0 && position <= selectedQueue.size()) {
                String removedCustomer = selectedQueue.remove(position - 1);
                stock += 5;
                System.out.println("Customer " + removedCustomer + " removed from Queue " + queueNumber);
            } else {
                System.out.println("Invalid position in the queue.");
            }
        } else {
            System.out.println("Invalid queue number.");
        }
    }

    private static void removeServedCustomer() {
        if (!cashier1_queue.isEmpty()) {
            String removedCustomer = cashier1_queue.remove(0);
            stock += 5;
            System.out.println("Customer " + removedCustomer + " served and removed from Queue 1");
        } else if (!cashier2_queue.isEmpty()) {
            String removedCustomer = cashier2_queue.remove(0);
            stock += 5;
            System.out.println("Customer " + removedCustomer + " served and removed from Queue 2");
        } else if (!cashier3_queue.isEmpty()) {
            String removedCustomer = cashier3_queue.remove(0);
            stock += 5;
            System.out.println("Customer " + removedCustomer + " served and removed from Queue 3");
        } else {
            System.out.println("No served customers in any queue.");
        }
    }

    private static void viewCustomersSorted() {
        List<String> allCustomers = new ArrayList<>();
        allCustomers.addAll(cashier1_queue);
        allCustomers.addAll(cashier2_queue);
        allCustomers.addAll(cashier3_queue);

        Collections.sort(allCustomers);

        System.out.println("Customers sorted in alphabetical order:");
        for (String customer : allCustomers) {
            System.out.println(customer);
        }
    }

    private static void storeProgramData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("program_data.txt"))) {
            writer.println(stock);
            writer.println(cashier1_queue.size());
            for (String customer : cashier1_queue) {
                writer.println(customer);
            }
            writer.println(cashier2_queue.size());
            for (String customer : cashier2_queue) {
                writer.println(customer);
            }
            writer.println(cashier3_queue.size());
            for (String customer : cashier3_queue) {
                writer.println(customer);
            }
            System.out.println("Program data stored successfully.");
        } catch (IOException e) {
            System.out.println("Failed to store program data.");
        }
    }

    private static void loadProgramData() {
        try (Scanner scanner = new Scanner(new File("program_data.txt"))) {
            stock = Integer.parseInt(scanner.nextLine());
            int cashier1Size = Integer.parseInt(scanner.nextLine());
            cashier1_queue.clear();
            for (int i = 0; i < cashier1Size; i++) {
                cashier1_queue.add(scanner.nextLine());
            }
            int cashier2Size = Integer.parseInt(scanner.nextLine());
            cashier2_queue.clear();
            for (int i = 0; i < cashier2Size; i++) {
                cashier2_queue.add(scanner.nextLine());
            }
            int cashier3Size = Integer.parseInt(scanner.nextLine());
            cashier3_queue.clear();
            for (int i = 0; i < cashier3Size; i++) {
                cashier3_queue.add(scanner.nextLine());
            }
            System.out.println("Program data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Program data file not found.");
        } catch (IOException e) {
            System.out.println("Failed to load program data.");
        }
    }

    private static void printStock() {
        System.out.println("Remaining burgers in stock: " + stock);
    }

    private static void addBurgers(Scanner scanner) {
        System.out.print("Enter the number of burgers to add to stock: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity. Please try again.");
            return;
        }
        stock += quantity;
        System.out.println(quantity + " burgers added to stock. Total stock: " + stock);
    }

    private static void checkStock() {
        if (stock <= 10) {
            System.out.println("Warning: Remaining burgers in stock is " + stock);
        }
    }
}