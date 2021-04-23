import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] xX = {
                {" "},
                {"X"}
        };
        System.out.println("Введите размер креста: ");
        String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        int x = Integer.parseInt(input);

        if (x > 2) {
            String[][] figure = new String[x][x];
            for (int stringNum = 0; stringNum < figure.length; stringNum++) {
                for (int symbolNum = 0; symbolNum < figure[stringNum].length; symbolNum++) {
                    if (symbolNum == stringNum || symbolNum == x - 1 - stringNum) {
                        figure[stringNum][symbolNum] = xX[1][0];
                        figure[stringNum][x - 1 - symbolNum] = xX[1][0];
                    } else figure[stringNum][symbolNum] = xX[0][0];
                }
            }
            for (int i = 0; i < figure.length; i++) {
                for (int j = 0; j < figure[i].length; j++) {
                    System.out.print(figure[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Невозможно создать крест!");
        }
    }
}