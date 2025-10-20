package Lesson7.Topic4;
/* Write a program that takes an integer n.
Use a do-while loop to count from 1 to n (inclusive),
and print each number on a new line.
 */
import java.util.Scanner;

public class No5DoWhileLoopCounting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        int ctr = 1;
        do {
            System.out.println(ctr);
            ctr++;
        } while (ctr <= n);
        input.close();
    }
}