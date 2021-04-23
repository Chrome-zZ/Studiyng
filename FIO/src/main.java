import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите ФИО");
        String fio = (new BufferedReader(new InputStreamReader(System.in))).readLine();

        splitFio(fio);
    }

    public static void splitFio(String fio) {
        fio = fio.trim();
        String[] parts = fio.split("[ ]");

        if (parts.length == 3 && fio.length() > 0) {
            if (fio.matches("[А-я ёй]")) {
                System.out.println("Фамилия: " + parts[0]);
                System.out.println("Имя: " + parts[1]);
                System.out.println("Отчество: " + parts[2]);
            } else {
                System.out.println("Проверьте язык введённых данных");
            }
        } else {
            System.out.println("Проверьте введенные данные");
        }
    }
}