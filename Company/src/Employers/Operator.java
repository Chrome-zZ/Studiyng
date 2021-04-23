package Employers;

public class Operator implements Employee {
    final int FIX = 70000;
    Company company;

    @Override
    public int getMonthSalary() {
//        setCompany(company);
        return FIX;
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