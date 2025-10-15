import java.util.Scanner;

public class lessonInputLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter # of students: ");
        int studNum = scan.nextInt();
        scan.nextLine(); 

        int ctr = 0;
        while (ctr<studNum) {
            System.out.print("Enter Name of student " + (ctr+1) + ": ");
            String name = scan.nextLine();
            ctr++;
        }
        scan.close();
    }
}