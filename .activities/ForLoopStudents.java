import java.util.Scanner;
public class ForLoopStudents {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter # of Students: ");
        int studNum = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter # of Subjects: ");
        int subjNum = scan.nextInt();
        scan.nextLine();

        System.out.println("--------------------------------");
        System.out.println("Enter Subject Names:");
        for (int subjCtr = 0; subjCtr < subjNum; subjCtr++) {
            System.out.print((subjCtr + 1) + ". ");
            String subjName = scan.nextLine();
        }
        System.out.println("--------------------------------");
        
        for (int ctr = 0; ctr < studNum; ctr++) {
            System.out.print("Enter Name of Student " + (ctr + 1) + ": ");
            String studName = scan.nextLine();

            for (int gradectr = 0; gradectr < subjNum; gradectr++) {
                System.out.print("Grade #" +  (gradectr + 1) + ": ");
                int studGrade = scan.nextInt();
                scan.nextLine();
            } // nested for
            System.out.println(""); // for new line
        } // main `for`
    }
}