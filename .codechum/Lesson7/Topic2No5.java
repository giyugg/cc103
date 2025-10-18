package Lesson7;
/* Write a program that takes an integer input from the user and calculates the sum of its digits using a while loop. 
The program should output the result to the user. */

import java.util.Scanner;

public class Topic2No5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        input.close();
        
        int sum = 0;
        int tempNum = number;
        
        while (tempNum > 0) {
            int digit = tempNum % 10;
            sum += digit;
            tempNum /= 10;
        }
        System.out.print("Sum of digits: " + sum);
    }
}