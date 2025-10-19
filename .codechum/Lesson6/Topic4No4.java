package Lesson6;
/* Write a program that takes an integer year as input and performs the following steps 
to determine if the year is a leap year:

1. Checks if year is divisible by 4 (i.e., year % 4 == 0) to check if it's a multiple of 4.
2. Checks if year is not divisible by 100 (i.e., year % 100 != 0) to exclude years that 
are multiples of 100 but not multiples of 400.
3. Checks if year is divisible by 400 (i.e., year % 400 == 0) to include years that are multiples of 400.
 * Input: An integer, year, representing a year.

The program should print "Year is a leap year." if condition is met. Otherwise, do nothing. */

import java.util.Scanner;

public class Topic4No4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the year: ");
        int year = input.nextInt();

        input.close();
        
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.print("Year is a leap year.");
        }
    }
}