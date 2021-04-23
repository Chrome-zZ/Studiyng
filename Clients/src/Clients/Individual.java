package Clients;

public class Individual implements Clients {

    private double amount;
    private double random = 1000 + Math.random() * 1000000;

    public Individual() {
        createAccount();
    }

    public void getMoney(double moneyAmount) {
        amount -= moneyAmount;
        System.out.printf("Ваш баланс IND: %.2f у. е.", amount);
        System.out.println();
    }

    public void putMoney(double moneyAmount) {
        amount += moneyAmount;
        System.out.printf("Ваш баланс IND: %.2f у. е.", amount);
        System.out.println();
    }

    public void createAccount() {
        amount = random;
    }

    public void checkAccount() {
        System.out.printf("Ваш баланс: %.2f у. е.", amount);
        System.out.println();
    }
}