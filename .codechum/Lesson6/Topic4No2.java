package Lesson6;
/* Write a program that takes two integers, num1 and num2, as input and checks if they have the same sign.
If both num1 and num2 are greater than 0 or both are less than 0, it prints "Numbers have the same sign." 
Otherwise, it does nothing. */

import java.util.Scanner;

public class Topic4No2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        input.close();
        
        if ((num1 > 0 && num2 > 0) || (num1 < 0 && num2 < 0)) {
            System.out.println("Numbers have the same sign.");
        }
    }
}