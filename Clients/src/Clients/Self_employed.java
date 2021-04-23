package Clients;

public class Self_employed implements Clients {
    //    У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.
    private double amount;
    private double random = 1000 + Math.random() * 1000000;

    public Self_employed() {
        createAccount();
    }

    public void getMoney(double moneyAmount) {
        amount -= moneyAmount;
        System.out.printf("Ваш баланс SELF: %.2f у. е.", amount);
        System.out.println();
    }

    public void putMoney(double moneyAmount) {
        if (moneyAmount < 1000) {
            double comission = 0.01 * moneyAmount;
            amount = amount + moneyAmount - comission;
            System.out.println("Комиссия составляет: " + comission + " у.е.");
            System.out.printf("Ваш баланс SELF: %.2f у. е.", amount);
            System.out.println();
        } else if (moneyAmount >= 1000) {
            double comission = 0.005 * moneyAmount;
            amount = amount + moneyAmount - comission;
            System.out.println("Комиссия составляет: " + comission + " у.е.");
            System.out.printf("Ваш баланс SELF: %.2f у. е.", amount);
            System.out.println();
        }
    }

    public void createAccount() {
        amount = random;
    }

    public void checkAccount() {
        System.out.printf("Ваш баланс: %.2f у. е.", amount);
        System.out.println();
    }
}
