import Clients.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Individual clientInd = new Individual();
        Entity clientEnt = new Entity();
        Self_employed clientSelf = new Self_employed();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String input = scanner.nextLine();
            switch (input) {
                case "I_STATUS":
                    clientInd.checkAccount();
                    break;
                case "E_STATUS":
                    clientEnt.checkAccount();
                    break;
                case "S_STATUS":
                    clientSelf.checkAccount();
                    break;
                case "I_PUT": {
                    clientInd.putMoney(3100);
                    break;
                }
                case "I_GET": {
                    clientInd.getMoney(3000);
                    break;
                }
                case "E_PUT": {
                    clientEnt.putMoney(10000);
                    break;
                }
                case "E_GET": {
                    clientEnt.getMoney(7000);
                    break;
                }
                case "S_GET": {
                    clientSelf.getMoney(5000);
                    break;
                }
                case "S_PUT": {
                    clientSelf.putMoney(800);
                    break;
                }
            }
        }
    }
}