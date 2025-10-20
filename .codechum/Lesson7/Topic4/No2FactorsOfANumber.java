package Lesson7.Topic4;
/* Write a program that takes an integer number. 
Use a do-while loop to print all the factors of the entered number. 
A factor is a number that divides another number without leaving a remainder. */
import java.util.Scanner;

public class No2FactorsOfANumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        System.out.print("Factors of " + number + ": ");
        
        int i = 1;
        do {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
            i++;
        } while (i <= number);
        System.out.println();
        input.close();
    }
}