package Lesson6.Topic4;
/* Write a program that takes a character, character, as input and checks if it is a special character. 
If the character is neither an alphabet letter nor a digit, it prints "Character is a special character." 
Otherwise, it does nothing. */

import java.util.Scanner;

public class No3SpecialCharacters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter character: ");
        char character = input.next().charAt(0);

        input.close();
        
        if (!Character.isLetterOrDigit(character)) {
            System.out.print("Character is a special character.");
        }
    }
}