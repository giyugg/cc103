package Lesson7.Topic2;
/* Write a program that takes an integer n. Use a while loop to iterate through the numbers from 1 to n (inclusive). 
For each number, check if it is even, and if so, print it on a separate line. */

import java.util.Scanner;

public class No3EvenNumberPrinter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        input.close();
        
        int i = 1;
        
        while (i <= n) {
            if (i % 2 == 0) {
                System.out.println(i);;
            }
            i++;
        }
    }
}