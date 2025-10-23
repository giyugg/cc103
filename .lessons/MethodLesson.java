import java.util.Scanner;

// newMethod is void
// newMethodRT is return type
public class MethodLesson {
    static Scanner x = new Scanner(System.in);
    static int num;
    public static void main(String[] args) {
        System.out.print("Enter #: ");
        num = x.nextInt();
        newMethod(num);
        int y = newMethodRT();
        System.out.println("Times 5: " + y);
        x.close(); // ignore, just practice to close scanner.
    }

    public static void newMethod(int n) { // n = num on main
        int x;

        x = 5 * n;
        System.out.println(x);
    }

    public static int newMethodRT() {
        return num;
    }
}