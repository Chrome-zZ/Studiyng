import java.util.*;

public class GoldNumbers {
    public static long start;
    public static long duration;

    public static void main(String[] args) {
        String[] chars = {"Y", "K", "E", "H", "X", "B", "A", "P", "O", "C", "M", "T"};
        ArrayList<String> list = new ArrayList<>();

//цифры
        for (int region = 1; region <= 199; region++) {
            for (int digit1 = 1; digit1 < 10; digit1++) {
                for (String i : chars) {
                    for (String j : chars) {
                        for (String k : chars) {
                            if (i.equals(j) && k.equals(j)) {
                                continue;
                            }
                            String number = String.format("%s%d%d%d%s%02d", i, digit1, digit1, digit1, j + k, region);
                            list.add(number);
                        }
                    }
                }
            }
        }

//буквы
        for (int region = 1; region <= 199; region++) {
            for (int digit1 = 0; digit1 < 10; digit1++) {
                for (int digit2 = 0; digit2 < 10; digit2++) {
                    for (int digit3 = 0; digit3 < 10; digit3++) {
                        if (digit1 == 0 && digit2 == 0 && digit3 == 0) {
                            continue;
                        }
                        for (String i : chars) {
                            String number = String.format("%s%d%d%d%s%02d", i, digit1, digit2, digit3, i + i, region);
                            list.add(number);
                        }
                    }
                }
            }
        }
        Collections.sort(list);
        HashSet<String> hashSet = new HashSet<>(list);
        TreeSet<String> treeSet = new TreeSet<>(list);

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Введите номер автомобиля: ");
            String input = scanner.nextLine();

// прямой перебор
            start = System.nanoTime();
            boolean listContainer = list.contains(input);
            duration = System.nanoTime() - start;
            if (listContainer) {
                System.out.println("Поиск перебором: Номер найден, поиск занял " + duration + " нс");
            } else {
                System.out.println("Поиск перебором: Номер не найден, поиск занял " + duration + " нс");
            }

//бинарный поиск
            start = System.nanoTime();
            int index = Collections.binarySearch(list, input);
            duration = System.nanoTime() - start;
            if (index < 0) {
                System.out.println("Бинарный поиск: Номер не найден, поиск занял " + duration + " нс");
            } else {
                System.out.println("Бинарный поиск: Номер найден, поиск занял " + duration + " нс");
            }
//HashSet
            start = System.nanoTime();
            boolean hashContainer = hashSet.contains(input);
            duration = System.nanoTime() - start;
            if (hashContainer) {
                System.out.println("Поиск в HashSet: Номер найден, поиск занял " + duration + " нс");
            } else {
                System.out.println("Поиск в HashSet: Номер не найден, поиск занял " + duration + " нс");
            }

//TreeSet
            start = System.nanoTime();
            boolean treeContainer = treeSet.contains(input);
            duration = System.nanoTime() - start;
            if (treeContainer) {
                System.out.println("Поиск в TreeSet: Номер найден, поиск занял " + duration + " нс");
            } else {
                System.out.println("Поиск в TreSet: Номер не найден, поиск занял " + duration + " нс");
            }
        }
    }
}
