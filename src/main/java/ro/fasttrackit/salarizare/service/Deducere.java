package ro.fasttrackit.salarizare.service;

public class Deducere {

    public static int deducere(int grossSalary, int persoaneInIntretinere) {
        int deducere = 0;
        int counter = 0;
        if (grossSalary <= 1950 && persoaneInIntretinere < 4) {
            if (persoaneInIntretinere == 0) {
                deducere = 510;
            } else if (persoaneInIntretinere == 1) {
                deducere = 670;
            } else if (persoaneInIntretinere == 2) {
                deducere = 830;
            } else if (persoaneInIntretinere == 3) {
                deducere = 990;
            } else {
                deducere = 1310;
            }
        } else if (grossSalary > 1950) {
            for (int i = 1950; i <= 3600; i++) {
                counter++;
                if (i % 50 == 0 && persoaneInIntretinere == 0) {
                    deducere = 510 - (15 * counter);
                } else if (i % 50 == 0 && persoaneInIntretinere == 1) {
                    deducere = 670 - (15 * counter);
                }else if (i % 50 == 0 && persoaneInIntretinere == 2) {
                    deducere = 830 - (15 * counter);
                }else if (i % 50 == 0 && persoaneInIntretinere == 3) {
                    deducere = 990 - (15 * counter);
                }else if (i % 50 == 0 && persoaneInIntretinere >= 4) {
                    deducere = 1310 - (15 * counter);
                }
            }
        }
        return deducere;
    }
}
