package com.atm.project;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        AtmOperationInterf op = new AtmOperationImpl();
        int atmnumber = 123;
        int atmpin = 123;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine !!!");
        System.out.print("Enter Atm Number : ");
        int atmNumber = in.nextInt();
        System.out.print("Enter Pin: ");
        int pin = in.nextInt();
        if ((atmnumber == atmNumber) && (atmpin == pin)) {
            while (true) {
                System.out.println("1. View Available Balance\n2. Withdraw Amount\n3. Deposit Amount\n4. Transfer Amount\n5. View Bank Statement\n6. Exit");
                System.out.println("Enter Choice : ");
                int ch = in.nextInt();
                switch (ch) {
                    case 1:
                        op.viewBalance();
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw ");
                        double withdrawAmount = in.nextDouble();
                        op.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter Amount to Deposit :");
                        double depositAmount = in.nextDouble();
                        op.depositAmount(depositAmount);
                        break;
                    case 4:
                        System.out.println("Enter recipient's account number: ");
                        int recipientAccount = in.nextInt();
                        System.out.println("Enter amount to transfer: ");
                        double transferAmount = in.nextDouble();
                        op.transferAmount(recipientAccount, transferAmount);
                        break;
                    case 5:
                        op.viewBankStatement();
                        break;
                    case 6:
                        System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
                        System.exit(0);
                    default:
                        System.out.println("Please enter correct choice");
                        break;
                }
            }
        } else {
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0);
        }
    }
}
