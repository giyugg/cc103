import java.util.Scanner;

public class lessonCChighestValue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int ctr = 0;
        int highest;

        System.out.print("Enter #: ");
        highest = scan.nextInt();
        ctr++;

        while (ctr < 3) {
            System.out.print("Enter #: ");
            int n1 = scan.nextInt();
            if (n1 > highest) {
                highest = n1;
            }
            ctr++;
        }

        System.out.println("Highest value: " + highest);
        scan.close();
    }
}