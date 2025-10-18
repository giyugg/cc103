package Lesson7;
/* Write a program that takes an integer number. 
Use a while loop to print the square of numbers from 1 to the inputted number. 
Each square should be printed on a separate line. */

import java.util.Scanner;

public class Topic2No4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        input.close();
        
        int i = 1;
        
        while (i <= number) {
            int sqroot = i * i;
            
            System.out.println(sqroot);
            i++;
        }
    }
}