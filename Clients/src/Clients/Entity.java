package Clients;

public class Entity implements Clients {
    //    У юридических лиц — снятие с комиссией 1%.
    private double amount;
    private double random = 1000 + Math.random() * 1000000;

    public Entity() {
        createAccount();
    }

    public void getMoney(double moneyAmount) {
        double comission = 0.01 * moneyAmount;
        amount = amount - moneyAmount - comission;
        System.out.println("Комиссия составляет: " + comission + " у.е.");
        System.out.printf("Ваш баланс ENT: %.2f у. е.", amount);
        System.out.println();
    }

    public void putMoney(double moneyAmount) {
        amount += moneyAmount;
        System.out.printf("Ваш баланс ENT: %.2f у. е.", amount);
        System.out.println();
    }

    @Override
    public void createAccount() {
        amount = random;
    }

    public void checkAccount() {
        System.out.printf("Ваш баланс: %.2f у. е.", amount);
        System.out.println();
    }
}
