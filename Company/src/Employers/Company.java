package Employers;

import java.util.*;

public class Company implements Comparator<Integer> {
    private final int MIN_INCOME = 3000000;
    private final int MAX_INCOME = 15000000;
    private final int INCOMING_MONEY = MIN_INCOME + (int) (Math.random() * MAX_INCOME);
    Scanner scanner = new Scanner(System.in);

    ArrayList<Employee> list = new ArrayList<>();

    public Company() {
    }

    public int getIncome() {
        return INCOMING_MONEY;
    }

    public void hire(Employee employee) {
        list.add(employee);
    }

    public void hireAll(List<Employee> list) {
        this.list.addAll(list);
        System.out.println("Total hired - " + list.size());
    }

    public void fire(int count) {
        int percent = list.size() * count / 100;
        for (int i = 0; i <= percent; i++) {
            list.remove((int) (Math.random() * list.size()));
        }
        System.out.println(count + "% was fired - " + percent + " workers");
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(list);
        System.out.println("\nTOP " + count + " salary list:");
        int result = compare(count, list.size());
        if (result >= 0) {
            System.out.println("Вы ошиблись с вводом..");
            System.out.println("Введите новое число для вывода списка зарплат: ");
            count = scanner.nextInt();
            getTopSalaryStaff(count);
        } else {
            for (int i = 1; i < count; i++) {
                System.out.println(list.get(list.size() - i).getMonthSalary());
            }
        }
        return null;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        System.out.println("\nLOWEST " + count + " salary list:");
        int result = compare(count, list.size());
        if (result >= 0) {
            System.out.println("Вы ошиблись с вводом..");
            System.out.println("Введите новое число для вывода списка зарплат: ");
            count = scanner.nextInt();
            getTopSalaryStaff(count);
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(list.get(i).getMonthSalary());
            }
        }
        return null;
    }

    @Override
    public int compare(Integer integer, Integer t1) {
        return integer.compareTo(t1);
    }
}