package Employers;

public interface Employee extends Comparable<Employee> {

    int getMonthSalary();

    void setCompany(Company company);
}