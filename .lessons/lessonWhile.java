import java.util.Scanner;

public class lessonWhile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ctr = 0;

        while (ctr < 3) {
            System.out.println("Enter a number: ");
            int num = scan.nextInt();
            ctr++;
        }
    }   
}