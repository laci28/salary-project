package ro.fasttrackit.salarizare.model;

import ro.fasttrackit.salarizare.service.Deducere;

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
        cas = (int) Math.ceil(grossSalary * 0.1);
        cass = (int) Math.ceil(grossSalary * 0.25);
        deducerePersonala = deducere(grossSalary, persoaneInIntretinere);
        salaryTax = (int) Math.ceil((grossSalary - cas - cass - deducerePersonala) * 0.1);
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
                ", persoaneInIntretinere=" + persoaneInIntretinere +
                ", cas=" + cas +
                ", cass=" + cass +
                ", deducerePersonala=" + deducerePersonala +
                ", salaryTax=" + salaryTax +
                ", netSalary=" + netSalary +
                '}';
    }

    public int deducere(int grossSalary, int persoaneInIntretinere) {
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
