package Lesson7;
/* Write a program that takes an integer n.
Use a while loop to count from 1 to n (inclusive), and print each number on a new line. */

import java.util.Scanner;

public class Topic2No2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        input.close();
        
        int i = 1;
        
        while (i <= n) {
            System.out.println(i);
            i++;
        }
    }
}