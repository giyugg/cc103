import java.util.Scanner;
public class BasicArithmetic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, c, d;
        
        System.out.print("Enter a: ");
        a = input.nextInt();
        System.out.print("Enter b: ");
        b = input.nextInt();
        System.out.print("Enter c: ");
        c = input.nextInt();
        System.out.print("Enter d: ");
        d = input.nextInt();
        input.close(); 
        
        int sum = (a+b) * (c+d);
        
    System.out.println("(" + a + " + " + b + ") * (" + c + " + " + d + ") = " + sum);
    }
}