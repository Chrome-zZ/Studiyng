
import java.util.HashSet;
import java.util.Scanner;

public class main {
    static HashSet<String> emails = new HashSet<>();
    public static String mail;
    public static String input;
    final static String REG_COMMAND = "[A-Z]{3,4}.+";

    public static void main(String[] args) {
        System.out.println("Введите команду: ");
        input = new Scanner(System.in).nextLine();
        check();
    }

    public static void check() {
        if (input.matches(REG_COMMAND)) {
            if (input.matches("LIST")) {
                list();
                input = new Scanner(System.in).nextLine();
            } else if (input.matches("ADD.+")) {
                add();
                input = new Scanner(System.in).nextLine();
            } else if (input.matches("EXIT")) {
                exit();
            } else {
                System.out.println("Неверный ввод! \n Повторите снова:");
                input = new Scanner(System.in).nextLine();
                check();
            }
        }
    }

    public static void add() {
        String[] command = input.split("\\s+", 2);
        mail = command[1];
        if (mail.matches("[A-z._0-9-]+@[A-z]+[.][A-z]+")) {
            if (!emails.contains(mail)) {
                emails.add(mail);
            } else {
                System.out.println("Данный почтовый адрес уже содержится в списке!");
                System.out.println("Введите команду: ");
                input = new Scanner(System.in).nextLine();
                check();
            }
            System.out.println("Введите команду: ");
            input = new Scanner(System.in).nextLine();
            check();
        } else {
            System.out.println("Ошибка ввода!");
            System.out.println("Введите команду: ");
            input = new Scanner(System.in).nextLine();
            check();
        }
    }

    public static void list() {
        for (String point : emails) {
            System.out.println(point);
        }
        System.out.println("Введите команду: ");
        input = new Scanner(System.in).nextLine();
        check();
    }

    public static void exit() {
        System.out.println("Выход из списка..");
    }
}
