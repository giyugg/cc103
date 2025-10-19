package Lesson7.Topic2;
/* Write a program that takes an integer number. 
Use a while loop to count the number of digits in the entered number and print it. */

import java.util.Scanner;

public class No1DigitCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        input.close();
        
        int ctr = 0;
        
        if (number == 0) {
            ctr = 1;
        }
        else {
            int tempNum = number;
            
            while (tempNum > 0) {
                tempNum = tempNum / 10;
                ctr++;
            }
        }
        System.out.print("Number of digits: " + ctr);
    }
}