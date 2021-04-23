import Accounts.CardAccount;
import Accounts.CheckingAccount;
import Accounts.DepositAccount;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        CheckingAccount mainAccount = new CheckingAccount() {
            @Override
            public void setPuttingAmount(int putAmount) {
            }

            @Override
            public void setGettingAmount(int putAmount) {
            }
        };
        DepositAccount mainDeposit = new DepositAccount();
        CardAccount mainCard = new CardAccount();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String input = scanner.nextLine();
            switch (input) {
                case "STATUS":
                    mainAccount.checkMoney();
                    break;
                case "PUT": {
                    System.out.print("Введите сумму пополнения: ");
                    String input2 = scanner.nextLine();
                    int inputAmount = Integer.parseInt(input2);
                    mainAccount.setPuttingAmount(inputAmount);
                    mainAccount.accountAmount += inputAmount;
                    System.out.println("Вы пополнили счет на " + inputAmount + " у.е.");
                    System.out.println("Ваш баланс: " + mainAccount.accountAmount + " у.е.");
                    break;
                }
                case "GET": {
                    System.out.print("Введите сумму снятия: ");
                    String input3 = scanner.nextLine();
                    int inputAmount = Integer.parseInt(input3);
                    mainAccount.setGettingAmount(inputAmount);
                    mainAccount.accountAmount -= inputAmount;
                    System.out.println("Вы сняли со счета " + inputAmount + " у.е.");
                    System.out.println("Ваш баланс: " + mainAccount.accountAmount + " у.е.");
                    break;
                }
                case "GET DEPOSIT": {
                    if (mainDeposit.getDaysDifference() > mainDeposit.valuableDifference) {
                        System.out.print("Введите сумму снятия: ");
                        String input3 = scanner.nextLine();
                        int inputAmount = Integer.parseInt(input3);
                        mainDeposit.setGettingAmount(inputAmount);
                        mainDeposit.accountAmount -= inputAmount;
                        System.out.println("Вы сняли со счета " + inputAmount + " у.е.");
                        System.out.println("Ваш баланс: " + mainDeposit.accountAmount + " у.е.");
                    } else {
                        System.out.println("С момента последнего пополнения прошло - " + mainDeposit.getDaysDifference()
                                + " дн. Невозможно снять средства со счёта");
                    }
                    break;
                }
                case "PUT DEPOSIT": {
                    System.out.print("Введите сумму пополнения: ");
                    String input5 = scanner.nextLine();
                    int inputAmount = Integer.parseInt(input5);
                    mainDeposit.setPuttingAmount(inputAmount);
                    mainDeposit.accountAmount += inputAmount;
                    System.out.println("Вы пополнили счет на " + inputAmount + " у.е.");
                    System.out.println("Ваш баланс: " + mainDeposit.accountAmount + " у.е.");
                    break;
                }
                case "PUT CARD": {
                    System.out.print("Введите сумму пополнения: ");
                    String input6 = scanner.nextLine();
                    int inputAmount = Integer.parseInt(input6);
                    mainCard.setPuttingAmount(inputAmount);
                    mainCard.accountAmount += inputAmount;
                    System.out.println("Вы пополнили счет на " + inputAmount + " у.е.");
                    System.out.println("Ваш баланс: " + mainCard.accountAmount + " у.е.");
                    break;
                }
                case "GET CARD": {
                    System.out.print("Введите сумму снятия: ");
                    String input7 = scanner.nextLine();
                    int inputAmount = Integer.parseInt(input7);
                    mainCard.getAmount = inputAmount;
                    mainCard.setGettingAmount(inputAmount);
                    mainCard.accountAmount -= inputAmount;

                    System.out.println("Вы сняли со счета " + inputAmount + " у.е.");
                    System.out.println("Ваш баланс: " + mainCard.accountAmount + " у.е.");
                    mainCard.getComission();
                }
                case "STATUS CARD": {
                    mainCard.checkMoney();
                    break;
                }
                case "STATUS DEPOSIT": {
                    mainDeposit.checkMoney();
                    break;
                }
            }
        }
    }
}
