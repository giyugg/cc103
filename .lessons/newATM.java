import java.util.Scanner;

public class newATM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double balance=0, withdraw=0, deposit=0;
        String defaultPW = "bulsucict2025";
        String answer="y";
        
        do {
        System.out.println("***ATM SIMULATION***");
        System.out.println("[B]-Balance Inquiry");
        System.out.println("[W]-Withdraw");
        System.out.println("[D]-Deposit");
        System.out.println("[C]-Change Password");
        System.out.println("[E]-Exit");
        System.out.println("--------------------");
        System.out.print("Choice: ");
        String choice = input.next();
        
        switch(choice)
        {
            case "B":
            case "b":
            {
                System.out.println("Current Balance: " + balance);
                break;
            }
            case "W":
            case "w":
            {
                //min amount to withdraw:100-up
                System.out.print("Amount to Withdraw: ");
                withdraw = input.nextDouble();
                if(withdraw>=100 && balance>=withdraw)
                {
                    balance = balance - withdraw;
                    System.out.println("Successfully, you've withdrawn"
                                + withdraw + "...");
                }
                else
                    System.out.println("Invalid amount to withdraw..");
                break;
            }
            case "D":
            case "d":
            {
                //min to deposit: 100-up
                System.out.print("Amount to Deposit: ");
                deposit = input.nextDouble();
                if(deposit>=100)
                {
                    //balance = balance + deposit;
                    balance += deposit;
                    System.out.println("Successfully, you've deposited"
                            + deposit + "...");
                }
                else
                    System.out.println("Invalid amount to deposit..");
                break;
            }
            case "C":
            case "c":
            {
                System.out.print("Enter Old Password: ");
                String userOldPass = input.next();
                if(userOldPass.equals(defaultPW))
                {
                    System.out.print("Enter New Password: ");
                    String userNewPass = input.next();
                    defaultPW = userNewPass;
                    System.out.println("Successfully, you've changed password..");
                }
                else
                    System.out.println("Incorrect old password..");
                break;
            }
            case "E":
            case "e":
            {
                System.out.println("Program closed..");
                System.exit(0);
                break;
            }
            default:
            {
                System.out.println("Invalid letter of transaction..");
                break;
            }
        }//switch
        System.out.print("Try again?[Y/N]: ");
        answer = input.next();
        System.out.println("");
        } while(answer.equalsIgnoreCase("y"));
    }//main
}//class