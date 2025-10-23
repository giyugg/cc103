import java.util.Scanner;

public class MethodPractice {
    public static void main(String[] args) {
        String answer = "y";
        do {
            menu();
            input();
            answer = tryAgain();
            System.out.println(""); //new line rawr
        } while (answer.equalsIgnoreCase("y"));
    }
    
    public static void menu() {
        System.out.println("========================");
        System.out.println("        OPTIONS         ");
        System.out.println("========================");
        System.out.println("[A] - Add");
        System.out.println("[B] - Subtract");
        System.out.println("[C] - Multiply");
        System.out.println("[D] - Divide");
        System.out.println("========================");
    }

    public static void input() {
        Scanner x = new Scanner(System.in);

        System.out.print("First Number: ");
        int num1 = x.nextInt();

        System.out.print("Second Number: ");
        int num2 = x.nextInt();

        System.out.print("Enter choice: ");
        String choice = x.next();

        switch (choice) {
            case "a":
            case "A": {
                int sum = add(num1, num2);
                System.out.println("Add Method: " + sum);
                break;
            }
            case "b":
            case "B": {
                int diff = sub(num1, num2);
                System.out.println("Subtract Method: " + diff);
                break;
            }
            case "c":
            case "C": {
                mul(num1, num2);
                break;
            }
            case "d":
            case "D": {
                div(num1, num2);
                break;
            }
            default:
            {
                System.out.println("Incorrect letter...");
                break;
            }
        }
    }

    public static int add(int n1, int n2) { // n1 and n2 are just num1 and num2
        int sum = n1 + n2;
        return sum;
    }

    public static int sub(int n1, int n2) {
        int diff = n1 - n2;
        return diff;
    }

    public static void mul(int n1, int n2) {
        int prod = n1 * n2;
        System.out.println("Multiply Method: " + prod);
    }

    public static void div(int n1, int n2) {
        int quot = n1 / n2;
        System.out.println("Division Method: " + quot);
    }

    public static String tryAgain() {
        Scanner x = new Scanner(System.in);

        System.out.print("Try another?: ");
        String answer = x.next();
        return answer;
    }
}