import java.util.Scanner;

public class TheMainLesson {

    // method that returns a value
    // method that does not return a value (void)

    //public static data-type method-name(parameter or pass-by value)
    public static double caloriesBurned(double weight, double myDistance) {

        // int x, y; note: this is not applicable to the parameter above mentioned.

        double caloriesBurned = .653 * weight * myDistance;
        return caloriesBurned;
    }

    public static double caloriesBurned2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Weight: ");
        double weight = input.nextDouble();
        System.out.print("Enter Distance: ");
        double distance = input.nextDouble();

       //caller variable
       // (weight, myDistance: distance) - arguments
       // double calories = caloriesBurned(weight, distance);
       double caloriesBurned = .653 * weight * distance;
       return caloriesBurned;
    }

    public static void caloriesBurned3() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Weight: ");
        double weight = input.nextDouble();
        System.out.print("Enter Distance: ");
        double distance = input.nextDouble();

        double caloriesBurned = .653 * weight * distance;
        System.out.println("Calories: " + caloriesBurned);
        return;
    }

    public static void caloriesBurned4(double weight, double distance) {
        double caloriesBurned = .653 * weight * distance;
        System.out.println("Calories: " + caloriesBurned);
        return;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Weight: ");
        double weight = input.nextDouble();
        System.out.print("Enter Distance: ");
        double distance = input.nextDouble();

        int ctr=0;
        while(ctr<3) {
            caloriesBurned4(weight, distance);
            ctr++;
        }

    }// main
}//class