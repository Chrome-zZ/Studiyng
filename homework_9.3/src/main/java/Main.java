public class Main {

    public static final String PATH = "src/main/resources/movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(PATH);
        System.out.printf("Сумма расходов: %.2f руб.\n", movements.getExpenseSum());
        System.out.printf("Сумма доходов: %.2f руб.\n", movements.getIncomeSum());
        System.out.println("\nСуммы расходов по организациям:");
        movements.getExpensesByOrganization()
                .forEach((key, value) -> System.out.printf("%s\t%.2f руб.\n", key, value));
    }
}