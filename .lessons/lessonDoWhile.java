import java.util.Scanner;

public class lessonDoWhile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ctr = 0;

        do {
            System.out.print("Enter a number: ");
            int num = scan.nextInt();
            ctr++;
        } while (ctr < 3);
    }
}