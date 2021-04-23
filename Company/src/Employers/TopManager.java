package Employers;

public class TopManager implements Employee {
    final int FIX = 100000;
    private double bonus = 115000 + Math.random() * 25001;
    Company company;
    int income;

    public TopManager(Company company) {
        setCompany(company);
        income = company.getIncome();
    }

    @Override
    public int getMonthSalary() {
        double salary;
        if (income > 10000000) {
            salary = (FIX + bonus * 1.5);
            return (int) salary;
        }
        salary = FIX;
        return (int) salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int compareTo(Employee obj) {
        return Integer.compare(getMonthSalary(), obj.getMonthSalary());
    }
}