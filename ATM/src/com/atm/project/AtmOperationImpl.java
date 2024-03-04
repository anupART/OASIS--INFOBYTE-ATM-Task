package com.atm.project;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
    ATM atm = new ATM();
    Map<Double, String> ministmt = new HashMap<>();
    Map<Integer, Double> bankStatement = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                bankStatement.put(ministmt.size(), -withdrawAmount);
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        } else {
            System.out.println("Please enter the amount in multiple of 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount, " Amount Deposited");
        bankStatement.put(ministmt.size(), depositAmount);
        System.out.println(depositAmount + " Deposited Successfully !!");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void transferAmount(int recipientAccount, double transferAmount) {
        if (transferAmount <= atm.getBalance()) {
            ministmt.put(transferAmount, " Amount Transferred to Account: " + recipientAccount);
            bankStatement.put(ministmt.size(), -transferAmount);
            System.out.println("Amount Transferred Successfully to Account: " + recipientAccount);
            atm.setBalance(atm.getBalance() - transferAmount);
            viewBalance();
        } else {
            System.out.println("Insufficient Balance for Transfer!!");
        }
    }

    public void viewBankStatement() {
        System.out.println("Bank Statement:");
        for (Map.Entry<Integer, Double> entry : bankStatement.entrySet()) {
            System.out.println("Transaction ID: " + entry.getKey() + ", Amount: " + entry.getValue());
        }
    }
}
