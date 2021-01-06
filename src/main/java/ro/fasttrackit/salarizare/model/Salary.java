package ro.fasttrackit.salarizare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Salary {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private Position position;
    private Month month;
    private int grossSalary;
    private int hoursWorked;
    private int overtime;

    private int cas;
    private int cass;
    private int salaryTax;
    private int netSalary;

    public Salary(String name, Position position, Month month, int grossSalary, int hoursWorked, int overtime) {
        this.name = name;
        this.position = position;
        this.month = month;
        this.grossSalary = grossSalary;
        this.hoursWorked = hoursWorked;
        this.overtime = overtime;
        cas = (int) (grossSalary * 0.1);
        cass = (int) (grossSalary * 0.25);
        salaryTax = (int) ((grossSalary - cas - cass) * 0.1);
        netSalary = grossSalary - cas - cass - salaryTax;
    }

    public Salary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public double getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }

    public double getCass() {
        return cass;
    }

    public void setCass(int cass) {
        this.cass = cass;
    }

    public double getSalaryTax() {
        return salaryTax;
    }

    public void setSalaryTax(int salaryTax) {
        this.salaryTax = salaryTax;
    }

    public int getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(int netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", month=" + month +
                ", grossSalary=" + grossSalary +
                ", hoursWorked=" + hoursWorked +
                ", overtime=" + overtime +
                ", cas=" + cas +
                ", cass=" + cass +
                ", salaryTax=" + salaryTax +
                ", netSalary=" + netSalary +
                '}';
    }
}
