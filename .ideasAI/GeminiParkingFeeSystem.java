import java.util.Scanner;

public class GeminiParkingFeeSystem {

    // --- E. Security: Store credentials ---
    private static String username = "admin";
    private static String password = "password123";

    // --- C.3 Daily Summary Report Data ---
    private static int totalMotorcycles = 0;
    private static int totalCars = 0;
    private static int totalSuvTrucks = 0;
    private static double totalFeesCollected = 0;
    private static long totalParkingMinutes = 0;

    // A single Scanner for the entire application to avoid resource leaks
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // --- E.1 & E.2: Security - Login with 3 tries ---
        if (!handleLogin()) {
            System.out.println("Maximum login attempts reached. System will now terminate.");
            System.exit(0);
        }

        // --- D.3: Main loop-driven menu ---
        boolean exit = false;
        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    processNewTransaction();
                    break;
                case 2:
                    generateSummary();
                    break;
                case 3:
                    handleChangeCredentials();
                    break;
                case 4:
                    displayGroupAndStatusInfo();
                    break;
                case 5:
                    displayAboutDeveloper();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using the Parking Fee System. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println(); // Add a blank line for readability
        }
        scanner.close();
    }

    /**
     * Handles the user login process, allowing up to 3 attempts.
     * @return true if login is successful, false otherwise.
     */
    private static boolean handleLogin() {
        System.out.println("--- Welcome to the Parking Fee System ---");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter username: ");
            String enteredUser = scanner.nextLine();
            System.out.print("Enter password: ");
            String enteredPass = scanner.nextLine();

            if (enteredUser.equals(username) && enteredPass.equals(password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Invalid username or password. Attempts remaining: " + (2 - i));
            }
        }
        return false;
    }
    
    /**
     * Displays the main menu to the user.
     * III.A.2: Displays username of current user
     */
    private static void displayMenu() {
        System.out.println("=========================================");
        System.out.println("  Parking Fee System Menu");
        System.out.println("  Logged in as: " + username);
        System.out.println("=========================================");
        System.out.println("1. Park a New Vehicle (Add Record)");
        System.out.println("2. View Daily Summary");
        System.out.println("3. Change Username/Password");
        System.out.println("4. Display Group & Status Info");
        System.out.println("5. About the Developer");
        System.out.println("0. Exit");
        System.out.println("=========================================");
    }

    /**
     * D.1: Orchestrates the process for a new parking transaction.
     * This method calls other methods to get input, compute fees, and display the receipt.
     */
    private static void processNewTransaction() {
        // --- D.1: InputVehicleInfo() related logic ---
        String vehicleType = getValidatedVehicleType();
        System.out.print("Enter Plate Number: ");
        String plateNumber = scanner.nextLine();
        
        System.out.println("\nEnter Time-In (24-hour format)");
        int timeInHour = getTimeInput("Hour (0-23): ", 23);
        int timeInMinute = getTimeInput("Minute (0-59): ", 59);

        System.out.println("\nEnter Time-Out (24-hour format)");
        int timeOutHour, timeOutMinute;
        long durationMinutes;

        // II.A.2: Time Recording Validation (Time-out must be after Time-in)
        while (true) {
            timeOutHour = getTimeInput("Hour (0-23): ", 23);
            timeOutMinute = getTimeInput("Minute (0-59): ", 59);
            
            long timeInTotalMinutes = timeInHour * 60 + timeInMinute;
            long timeOutTotalMinutes = timeOutHour * 60 + timeOutMinute;

            durationMinutes = timeOutTotalMinutes - timeInTotalMinutes;

            if (durationMinutes >= 0) {
                break;
            }
            System.out.println("Error: Time-Out cannot be earlier than Time-In. Please enter again.");
        }

        // --- D.1 & D.2: ComputeParkingFee() Call ---
        double parkingFee = computeParkingFee(vehicleType, durationMinutes);

        // II.A.5: Lost Ticket Penalty
        System.out.print("\nWas the ticket lost? (yes/no): ");
        boolean isTicketLost = scanner.nextLine().equalsIgnoreCase("yes");
        if (isTicketLost) {
            parkingFee += 200.00;
        }

        // II.A.6: Discount Application
        System.out.print("Is the driver a Senior Citizen or PWD? (yes/no): ");
        boolean hasDiscount = scanner.nextLine().equalsIgnoreCase("yes");
        if (hasDiscount) {
            parkingFee *= 0.80; // Apply 20% discount
        }

        // --- D.1: DisplayReceipt() Call ---
        displayReceipt(plateNumber, vehicleType, timeInHour, timeInMinute, timeOutHour, timeOutMinute, durationMinutes, parkingFee, isTicketLost, hasDiscount);

        // --- Update Summary Data ---
        totalFeesCollected += parkingFee;
        totalParkingMinutes += durationMinutes;
        switch (vehicleType.toLowerCase()) {
            case "motorcycle":
                totalMotorcycles++;
                break;
            case "car":
                totalCars++;
                break;
            case "suv":
            case "truck":
                totalSuvTrucks++;
                break;
        }
    }

    /**
     * II.A.1: Prompts for and validates vehicle type input.
     * @return A valid vehicle type string ("Motorcycle", "Car", "SUV", or "Truck").
     */
    private static String getValidatedVehicleType() {
        while (true) {
            System.out.print("Enter Vehicle Type (Motorcycle, Car, SUV, Truck): ");
            String type = scanner.nextLine().trim();
            if (type.equalsIgnoreCase("Motorcycle") || type.equalsIgnoreCase("Car") ||
                type.equalsIgnoreCase("SUV") || type.equalsIgnoreCase("Truck")) {
                return type;
            }
            // C.2: Notification for invalid entry
            System.out.println("Invalid vehicle type. Please try again.");
        }
    }

    /**
     * A helper method to get and validate integer input for time.
     * @param prompt The message to display to the user.
     * @param max The maximum valid value (e.g., 23 for hour, 59 for minute).
     * @return A valid integer.
     */
    private static int getTimeInput(String prompt, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            value = getIntegerInput();
            if (value >= 0 && value <= max) {
                return value;
            }
            System.out.println("Invalid input. Please enter a value between 0 and " + max + ".");
        }
    }

    /**
     * D.1 & II.A.3: Computes parking fee based on vehicle type and duration.
     * @param vehicleType The type of the vehicle.
     * @param durationMinutes The total duration of parking in minutes.
     * @return The calculated parking fee.
     */
    private static double computeParkingFee(String vehicleType, long durationMinutes) {
        // II.A.4: Applies 30-minute grace period
        if (durationMinutes <= 30) {
            return 0.0;
        }

        // II.A.4: Partial hours are rounded up
        double billedHours = Math.ceil(durationMinutes / 60.0);
        double fee = 0.0;
        
        // Fee computation logic based on requirements
        switch (vehicleType.toLowerCase()) {
            case "motorcycle":
                if (billedHours <= 1) fee = 20.0;
                else fee = 20.0 + (billedHours - 1) * 10.0;
                break;
            case "car":
                if (billedHours <= 1) fee = 40.0;
                else fee = 40.0 + (billedHours - 1) * 20.0;
                break;
            case "suv":
            case "truck":
                if (billedHours <= 1) fee = 60.0;
                else fee = 60.0 + (billedHours - 1) * 30.0;
                break;
        }
        return fee;
    }

    /**
     * D.1 & C.1: Displays a formatted receipt for the transaction.
     */
    private static void displayReceipt(String plate, String type, int tInH, int tInM, int tOutH, int tOutM,
                                     long duration, double totalFee, boolean lost, boolean discount) {
        System.out.println("\n--- PARKING RECEIPT ---");
        System.out.println("Plate Number: " + plate);
        System.out.println("Vehicle Type: " + type);
        System.out.printf("Time-In:      %02d:%02d\n", tInH, tInM);
        System.out.printf("Time-Out:     %02d:%02d\n", tOutH, tOutM);
        System.out.printf("Duration:     %d hours and %d minutes\n", (duration / 60), (duration % 60));
        System.out.println("-------------------------");
        if (lost) System.out.printf("Lost Ticket Penalty: ₱%,.2f\n", 200.0);
        if (discount) System.out.println("Discount (20%): Applied");
        System.out.printf("TOTAL FEE:    ₱%,.2f\n", totalFee);
        System.out.println("-------------------------");

        // B.2: Handle payment and change
        double cash = 0;
        while (cash < totalFee) {
            System.out.print("Enter cash received: ");
            cash = getDoubleInput();
            if (cash < totalFee) {
                System.out.println("Insufficient cash. Please enter an amount greater than or equal to the total fee.");
            }
        }
        System.out.printf("Change:       ₱%,.2f\n", (cash - totalFee));
        System.out.println("--- Thank You! ---");
    }

    /**
     * D.1 & C.3: Generates and displays the daily summary report.
     */
    private static void generateSummary() {
        int totalVehicles = totalMotorcycles + totalCars + totalSuvTrucks;
        double averageDuration = 0;
        if (totalVehicles > 0) {
            averageDuration = (double) totalParkingMinutes / totalVehicles;
        }

        System.out.println("\n--- DAILY SUMMARY REPORT ---");
        System.out.println("Total Vehicles Parked by Type:");
        System.out.println("  - Motorcycles: " + totalMotorcycles);
        System.out.println("  - Cars: " + totalCars);
        System.out.println("  - SUV/Trucks:  " + totalSuvTrucks);
        System.out.println("-----------------------------");
        System.out.println("Total Vehicles Overall: " + totalVehicles);
        System.out.printf("Total Fees Collected:   ₱%,.2f\n", totalFeesCollected);
        System.out.printf("Average Parking Duration: %.2f minutes\n", averageDuration);
        System.out.println("--- End of Report ---");
    }
    
    /**
     * E.3: Provides an option for changing the username and password.
     */
    private static void handleChangeCredentials() {
        System.out.println("\n--- Change Credentials ---");
        System.out.print("Enter current password to confirm: ");
        String currentPass = scanner.nextLine();
        if (!currentPass.equals(password)) {
            System.out.println("Incorrect password. Action cancelled.");
            return;
        }
        System.out.print("Enter new username: ");
        username = scanner.nextLine();
        System.out.print("Enter new password: ");
        password = scanner.nextLine();
        System.out.println("Credentials updated successfully.");
    }

    /**
     * III.A.1: Displays group member information and assigned roles.
     */
    private static void displayGroupAndStatusInfo() {
        System.out.println("\n--- Group Member and Status Information ---");
        System.out.println("Project: Parking Fee System");
        System.out.println("Group Members:");
        System.out.println(" - [Your Name] - Project Lead / Programmer");
        System.out.println(" - [Member 2 Name] - Documentation / Tester");
        System.out.println(" - [Member 3 Name] - UI/UX Design / Tester");
        System.out.println("System Status: Operational");
        System.out.println("-------------------------------------------");
    }

    /**
     * III.B.1: Displays information about the developer.
     */
    private static void displayAboutDeveloper() {
        System.out.println("\n--- About the Developer ---");
        System.out.println("Presented by:");
        System.out.println("  Name: [Your Full Name]");
        System.out.println("  Course, Year, Section: [e.g., BSCS 1-A]");
        System.out.println("  Group: [Your Group Name/Number]");
        System.out.println("  Contact: [Your Email or Phone Number]");
        System.out.println("\nPresented to:");
        System.out.println("  Engr. Evelyn C. Samson");
        System.out.println("  Instructor");
        System.out.println("---------------------------");
    }
    
    /**
     * Helper method to safely get an integer input from the user.
     */
    private static int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // discard the non-integer input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the rest of the line
        return value;
    }

    /**
     * Helper method to safely get a double input from the user.
     */
    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: ");
            scanner.next(); // discard non-double input
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume the rest of the line
        return value;
    }
}