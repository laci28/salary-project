package ro.fasttrackit.salarizare.model;

import javax.persistence.Entity;

@Entity
public class StateBudget extends Salary {

    public double cas(int grossSalary) {
        return grossSalary * 0.25;
    }

    public double cass(int grossSalary) {
        return grossSalary * 0.1;
    }

    public double salaryTax(int grossSalary) {
        return grossSalary * 0.1;
    }

    public int netSalary(int grossSalary) {
        return (int) (grossSalary - cas(grossSalary) - cass(grossSalary) - salaryTax(grossSalary));
    }

    @Override
    public int getGrossSalary() {
        return super.getGrossSalary();
    }
}
