import java.util.ArrayList;
import java.util.Scanner;

public class List {
    static ArrayList<String> todoList = new ArrayList<>();
    public static int dealNumber;
    public static String deal;
    public static String input;
    final static String REG_COMMAND = "[A-Z]{3,6}\\s?(\\d+)?\\s?.+?";
//    static String input;
//    public static int i = 0;//       final String REG_ADD = "[A-Z]+\\s+(\\d+)?(\\s+)?.+";
//        final String REG_EDIT = "[A-Z]+\\s+(\\d+)?(\\s+)?.+";
//        final String REG_DELETE = "[A-Z]+\\s+(\\d+);"^%c %d? %s$"

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
            } else if (input.matches("EDIT \\d .+")) {
                edit();
            }
            else if (input.matches("DELETE \\d+")) {
                delete();
            }
            else if (input.matches("EXIT")) {
                exit();
            } else {
                System.out.println("Неверный ввод! \n Повторите снова:");
                input = new Scanner(System.in).nextLine();
                check();
            }
        }
    }

    public static void add() {
        if (input.matches(".{1,7}\\d+.+?")) {
            String[] command = input.split("\\s+", 3);
            dealNumber = Integer.parseInt(command[1]);
            deal = command[2];
            if ((dealNumber - todoList.size()) >= 1) {
                todoList.add(todoList.size(), deal);
            } else {
                todoList.add(dealNumber, deal);
            }
        } else {
            String[] command = input.split("\\s+", 2);
            deal = command[1];
            if (command[0].equals("ADD")) {
                todoList.add(deal);
            }
        }
        System.out.println("Введите команду: ");
        input = new Scanner(System.in).nextLine();
        check();
    }

    public static void edit() {
        String[] command = input.split("\\s+", 3);
        dealNumber = Integer.parseInt(command[1]);
        deal = command[2];
        todoList.set((dealNumber - 1), deal);
        System.out.println("Введите команду: ");
        input = new Scanner(System.in).nextLine();
        check();
    }

    public static void delete () {
        String[] command = input.split("\\s+", 3);
        dealNumber = Integer.parseInt(command[1]);
        todoList.remove((dealNumber - 1));
        System.out.println("Введите команду: ");
        input = new Scanner(System.in).nextLine();
        check();
    }
    public static void list() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + " - " + todoList.get(i));
        }
        System.out.println("Введите команду: ");
        input = new Scanner(System.in).nextLine();
        check();
    }

    public static void exit() {
        System.out.println("Выход из списка..");
    }
}
/*
ЭТО ОБЩАЯ РЕГУЛЯРКА
"[A-Z]+\\s+(\\d+)?(\\s+)?.+"
* */
