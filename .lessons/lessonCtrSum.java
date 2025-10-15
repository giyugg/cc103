import java.util.Scanner;

public class lessonCtrSum {
    public static void main(String[] args) { // Controlled Loop
        Scanner scan = new Scanner(System.in);

        int ctr = 5;    // control variable: 5,4,3,2,1
        int sum = 0;    // computes the total

        while(ctr>0) {  // testing: ctr>=1 or ctr>0
            System.out.print("Enter a #: ");
            int n1 = scan.nextInt();
            sum= sum + n1;
            ctr--;      // decrement
        }
        System.out.print("Sum: " + sum);
        scan.close();
    }
}
