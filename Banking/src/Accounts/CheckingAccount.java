package Accounts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class CheckingAccount {
    public int accountAmount;
    public int getAmount;
    protected Date puttingDate;
    SimpleDateFormat format = new SimpleDateFormat("MM.dd.yy");

    protected CheckingAccount() {
    }

    public void checkMoney() {
        System.out.println("Ваш баланс: " + accountAmount + " у.е.");
    }

    public abstract void setPuttingAmount(int putAmount) throws ParseException;

    protected void setPuttingDate() throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите дату пополнения: ");
        puttingDate = format.parse(input.nextLine());
    }

    public abstract void setGettingAmount(int getAmount);
}