package Accounts;

import java.text.ParseException;
import java.util.Date;

public class DepositAccount extends CheckingAccount {
    public DepositAccount() {
    }

    private int daysDifference;
    public int valuableDifference = 30;

    public int getDaysDifference() {
        Date today = new Date();
        long difference = today.getTime() - puttingDate.getTime();
        daysDifference = (int) (difference / (24 * 60 * 60 * 1000));
        return daysDifference;
    }

    public void setGettingAmount(int getAmount) {
    }

    public void setPuttingAmount(int putAmount) throws ParseException {
        setPuttingDate();
    }

    public void checkMoney() {
        System.out.println("Ваш баланс: " + accountAmount + " у.е.");
    }
}