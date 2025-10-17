import java.util.Scanner;

public class SpecialCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char character = input.next().charAt(0);

        if (!Character.isLetterOrDigit(character)) {
            System.out.println("Character is a special character.");
        }
        input.close();
    }
}