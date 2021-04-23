import Employers.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> sublist = new ArrayList<>();
        Company company = new Company();

        for (int i = 0; i < 150; i++) {
            sublist.add(new Operator());
        }

        for (int i = 0; i < 80; i++) {
            sublist.add(new Manager());
        }

        for (int i = 0; i < 10; i++) {
            sublist.add(new TopManager(company));
        }
        company.hireAll(sublist);

        company.getTopSalaryStaff(10);
        company.getLowestSalaryStaff(30);

        company.fire(50);

        company.getTopSalaryStaff(10);
        company.getLowestSalaryStaff(30);
    }
}
