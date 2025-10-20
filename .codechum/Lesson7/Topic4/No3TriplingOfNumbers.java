package Lesson7.Topic4;
/* Write a program that takes an integer n. 
Use a do-while loop to calculate and print the tripling of numbers 
from 1 to the entered number. */
import java.util.Scanner;

public class No3TriplingOfNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        int i = 1;
        do {
            System.out.println(i * 3);
            i++;
        } while (i <= n);
        input.close();
    }
}