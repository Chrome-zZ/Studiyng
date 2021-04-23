import java.awt.*;
import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws WrongFormatException , NumberException, EmailException {
        final String NUMBER = "[+]79([0-9]{9})";
        final String MAIL = "[a-z]{1,15}[.][a-z]{1,15}@gmail[.]com";
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new WrongFormatException("Wrong format. Correct format is: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722", 4);
        }
        if (!components[3].matches(NUMBER)){
            throw new NumberException("Wrong number format. Correct number format is: \n" +
                    "+79215637722", NUMBER);
        }
        if (!components[2].matches(MAIL)){
            throw new EmailException("Wrong email format. Correct email format is: \n" +
                    "vasily.petrov@gmail.com", MAIL);
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }

    class NumberException extends Exception {
        String number;
        public NumberException(String message, String s) {
            super(message);
            number = s;
        }
    }

    class EmailException extends Exception {
        String mail;
        public EmailException(String message, String s) {
            super(message);
            mail = s;
        }
    }
   class WrongFormatException extends Exception {

        int length;

        public WrongFormatException(String message, int num) {
            super(message);
            length = num;
        }
    }

}
