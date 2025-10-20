package Lesson7.Topic4;
/* Write a program that continuously prompt the user to enter a number.
 * If the number is divisible by 3, print "Fizz". If the number is divisible by 5, print "Buzz".
 * If the number is divisible by both 3 and 5, print "FizzBuzz".
 * Otherwise, print the number itself.
Use a do...while loop to repeatedly perform this operation until the user enters a zero. */
import java.util.Scanner;

public class No4FizzBuzzDoWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        
        do {
            System.out.print("Enter a number: ");
            number = input.nextInt();
            
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("FizzBuzz");
            }
            else if (number % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (number % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(number);
            }
        } while (number != 0);
        input.close();
    }
}