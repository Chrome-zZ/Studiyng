package Employers;

public class Manager implements Employee {
    final int FIX = 50000;
    private final double BONUS = 115000 + Math.random() * 25001;
    Company company;

    @Override
    public int getMonthSalary() {
//        setCompany(company);
        double salary = FIX + 0.05 * BONUS;
        return (int) salary;
    }

    @Override
    public void setCompany(Company company) {
//        this.company = company;
    }

    @Override
    public int compareTo(Employee obj) {
        return Integer.compare(getMonthSalary(), obj.getMonthSalary());
    }
}