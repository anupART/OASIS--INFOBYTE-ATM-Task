package com.atm.project;

public interface AtmOperationInterf {
    void viewBalance();
    void withdrawAmount(double withdrawAmount);
    void depositAmount(double depositAmount);
    void transferAmount(int recipientAccount, double transferAmount);
    void viewBankStatement();
}
