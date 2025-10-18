package Lesson6;
/* Write a program that takes two integers, x and y, as input and checks if they are equal. 
If x is equal to y, it print "Numbers are equal." */

import java.util.Scanner;

public class Topic4No5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter x: ");
        int x = input.nextInt();
        
        System.out.print("Enter y: ");
        int y = input.nextInt();
        
        if (x == y) {
            System.out.print("Numbers are equal.");
        }
    }
}