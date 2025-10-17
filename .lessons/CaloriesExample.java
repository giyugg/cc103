import java.util.Scanner;   //user's input
public class CaloriesExample {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in); //instantiation
        int weight, distance;

        System.out.print("Enter Weight (lb): ");
        weight = input.nextInt();
        System.out.print("Enter Distance (mi): ");
        distance = input.nextInt();

        double caloriesBurned = .653 * weight * distance;

        System.out.print("\"Calories Burned: " + caloriesBurned + " cal.\""); // used common escape sequences
        input.close(); //closing the scanner object for memory leak prevention
    }
}