package Lesson6;
/* Write a program that takes three integers x, y, and z, as input and checks if they represent the sides of an equilateral triangle. 
An equilateral triangle has all sides of equal length, so this function checks if x, y, and z are all equal. 
If they are equal, it prints "Triangle is equilateral." Otherwise, it does nothing. */

import java.util.Scanner;

public class Topic4No1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter x: ");
        int x = input.nextInt();
        
        System.out.print("Enter y: ");
        int y = input.nextInt();
        
        System.out.print("Enter z: ");
        int z = input.nextInt();
        
        if (x == y && y == z) {
            System.out.println("Triangle is equilateral.");
        }
    }
}