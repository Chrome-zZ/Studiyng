package Accounts;

public class CardAccount extends CheckingAccount {

    public CardAccount() {
    }

    public void setGettingAmount(int getAmount) {
    }

    public void setPuttingAmount(int putAmount) {
    }

    public void getComission() {
        int comission = (int) (0.01 * getAmount);
        int newAmount = accountAmount - comission;
        System.out.println("Комиссия составляет: " + comission + " у.е.");
        System.out.println("Баланс: " + newAmount + " у.е.");
    }

    public void checkMoney() {
        System.out.println("Ваш баланс: " + accountAmount + " у.е.");
    }
}
