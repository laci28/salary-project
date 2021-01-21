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
    private int grossSalaryWithOvertime;
    private int grossSalary;
    private int hoursWorked;
    private int daysWorked;
    private int overtime;
    private int persoaneInIntretinere;

    private int cas;
    private int cass;
    private int deducerePersonala;
    private int salaryTax;
    private int netSalary;

    public Salary(String name, Position position, Month month, int grossSalary, int hoursWorked, int overtime, int persoaneInIntretinere) {
        this.name = name;
        this.position = position;
        this.month = month;
        this.grossSalary = grossSalary;
        this.hoursWorked = hoursWorked;
        this.overtime = overtime;
        this.persoaneInIntretinere = persoaneInIntretinere;
        daysWorked = hoursWorked / 8;
        grossSalaryWithOvertime = (((grossSalary / hoursWorked) * overtime) * 2) + grossSalary;
        cas = (int) Math.ceil(grossSalaryWithOvertime * 0.1);
        cass = (int) Math.ceil(grossSalaryWithOvertime * 0.25);
        deducerePersonala = deducere(grossSalaryWithOvertime, persoaneInIntretinere);
        salaryTax = (int) Math.ceil((grossSalaryWithOvertime - cas - cass - deducerePersonala) * 0.1);
        netSalary = grossSalaryWithOvertime - cas - cass - salaryTax;
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

    public int getPersoaneInIntretinere() {
        return persoaneInIntretinere;
    }

    public void setPersoaneInIntretinere(int persoaneInIntretinere) {
        this.persoaneInIntretinere = persoaneInIntretinere;
    }

    public int getDeducerePersonala() {
        return deducerePersonala;
    }

    public void setDeducerePersonala(int deducerePersonala) {
        this.deducerePersonala = deducerePersonala;
    }

    public int getGrossSalaryWithOvertime() {
        return grossSalaryWithOvertime;
    }

    public void setGrossSalaryWithOvertime(int grossSalaryWithOvertime) {
        this.grossSalaryWithOvertime = grossSalaryWithOvertime;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", month=" + month +
                ", grossSalaryWithOvertime=" + grossSalaryWithOvertime +
                ", grossSalary=" + grossSalary +
                ", hoursWorked=" + hoursWorked +
                ", daysWorked=" + daysWorked +
                ", overtime=" + overtime +
                ", persoaneInIntretinere=" + persoaneInIntretinere +
                ", cas=" + cas +
                ", cass=" + cass +
                ", deducerePersonala=" + deducerePersonala +
                ", salaryTax=" + salaryTax +
                ", netSalary=" + netSalary +
                '}';
    }

    private int deducere(int grossSalary, int persoaneInIntretinere) {
        double deducere = 0;
        if (grossSalary <= 1950) {
            if (persoaneInIntretinere == 0) {
                deducere = 510;
            } else if (persoaneInIntretinere == 1) {
                deducere = 670;
            } else if (persoaneInIntretinere == 2) {
                deducere = 830;
            } else if (persoaneInIntretinere == 3) {
                deducere = 990;
            } else if (persoaneInIntretinere <= 4) {
                deducere = 1310;
            }
        } else if (grossSalary < 3600) {
            if (persoaneInIntretinere == 0) {
                deducere = 510 - (Math.ceil(((double) grossSalary - 1950) / 50) * 15);
            } else if (persoaneInIntretinere == 1) {
                deducere = 670 - (Math.ceil(((double) grossSalary - 1950) / 50) * 15);
            } else if (persoaneInIntretinere == 2) {
                deducere = 830 - (Math.ceil(((double) grossSalary - 1950) / 50) * 15);
            } else if (persoaneInIntretinere == 3) {
                deducere = 990 - (Math.ceil(((double) grossSalary - 1950) / 50) * 15);
            } else if (persoaneInIntretinere >= 4) {
                deducere = 1310 - (Math.ceil(((double) grossSalary - 1950) / 50) * 15);
            }
        } else {
            deducere = 0;
        }
        return (int) deducere;
    }
}
