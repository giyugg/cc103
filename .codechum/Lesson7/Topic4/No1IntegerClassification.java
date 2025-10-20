package Lesson7.Topic4;
/* Write a program that prints "positive" if the number is positive and "negative" if it is not. 
Use ado-while loop to repeatedly prompt for input until a 0 is entered. */
import java.util.Scanner;

public class No1IntegerClassification {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        
        do {
            System.out.print("Enter an integer: ");
            number = input.nextInt();
            
            if (number > 0) {
                System.out.println("positive");
            }
            else if (number < 0) {
                System.out.println("negative");
            }
        } while (number != 0);
        input.close();
    }
}