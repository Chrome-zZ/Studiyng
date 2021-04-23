import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Book {
    //    final static String NAME = ".+";
    final static String NUMBER = "[+]?[\\d-]+";

    public static String personName;
    public static String personNumber;

    public static void main(String[] args) {
        TreeMap<String, String> telephoneBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Введите имя или номер абонента: ");
            String input = scanner.nextLine();
            if (input.equals("LIST")) {
                showBook(telephoneBook);
                continue;
            }
            if (input.matches(NUMBER) && !telephoneBook.containsValue(input)) {
                personNumber = input;
                System.out.println("Введите имя нового абонента: ");
                personName = scanner.nextLine();
                personNumber = personNumber.replaceAll("\\D", "");
                telephoneBook.put(personName, personNumber);
            } else if (!telephoneBook.containsKey(input)) {
                personName = input;
                System.out.println("Введите номер телефона нового абонента: ");
                personNumber = scanner.nextLine();
                if (personNumber.matches(NUMBER)) {
                    personNumber = personNumber.replaceAll("\\D", "");
                    telephoneBook.put(personName, personNumber);
                }
            } else {
                System.out.println("Абонент: " + personName + ". Номер: " + telephoneBook.get(personName));
            }
        }
    }

    public static void showBook(Map<String, String> map) {
        for (String listing : map.keySet()) {
            System.out.println("Абонент: " + listing + ". Номер: " + map.get(listing));
        }
    }
}
