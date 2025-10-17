import java.util.Scanner;

public class SwitchMath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //swtich
        //1-Addition
        //2-Subtraction
        //3-Multiplication
        //4-Division
        //X-exit

        System.out.println("**************************");
        System.out.println("     [1]-Addition         ");
        System.out.println("     [2]-Subtraction      ");
        System.out.println("     [3]-Multiplication   ");
        System.out.println("     [4]-Division         ");
        System.out.println("     [X]-Exit             ");
        System.out.println("**************************");
        System.out.print("Enter Value 1: ");
        int n1 = scan.nextInt();
        System.out.print("Enter Value 2: ");
        int n2 = scan.nextInt();
        System.out.print("Choice of operator: ");
        String choice = scan.next();
        scan.close(); // ignore this, this is just to close the scanner.

        switch(choice) {
            case "1": { // Addition
                int sum = n1 + n2;
                System.out.println("Sum: " + sum);
                break;
            }
            case "2": { // Subtraction
                int diff = n1 - n2;
                System.out.println("Difference: " + diff);
                break;
            }
            case "3": { // Multiplication
                int prod = n1 * n2;
                System.out.print("Product: " + prod);
                break;
            }
            case "4": { // Division
                int quo = n1 / n2;
                System.out.println("Quotient: " + quo);
                break;
            }
            case "X":
            case "x": { // Exit
                System.out.println("Program closed...");
                break;
            }
            default: { // Invalid choice
                System.out.println("Invalid input...");
                System.exit(0);
            }
        }
    } 
}
