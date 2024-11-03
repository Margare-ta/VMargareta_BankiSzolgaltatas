package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Szamla> számlák;

    public Bank() {
        this.számlák = new ArrayList<>();
    }

    public Szamla SzamlaNyitás(Tulajdonos tulajdonos, double hitelkeret) {
        if (hitelkeret < 0) {
            throw new IllegalArgumentException("A hitelkeret nem lehet negatív.");
        }

        Szamla újSzamla;
        if (hitelkeret > 0) {
            újSzamla = new HitelSzamla(tulajdonos, hitelkeret);
        } else {
            újSzamla = new MegtakaritasiSzamla(tulajdonos);
        }

        számlák.add(újSzamla);
        return újSzamla;
    }

    public double getÖsszEgyenleg(Tulajdonos tulajdonos) {
        double összEgyenleg = 0.0;

        for (Szamla Szamla : számlák) {
            if (Szamla.getTulajdonos().equals(tulajdonos)) {
                összEgyenleg += Szamla.getEgyenleg();
            }
        }

        return összEgyenleg;
    }

    public Szamla getLegnagyobbEgyenlegűSzamla(Tulajdonos tulajdonos) {
        Szamla legnagyobbSzamla = null;

        for (Szamla Szamla : számlák) {
            if (Szamla.getTulajdonos().equals(tulajdonos)) {
                if (legnagyobbSzamla == null || Szamla.getEgyenleg() > legnagyobbSzamla.getEgyenleg()) {
                    legnagyobbSzamla = Szamla;
                }
            }
        }

        return legnagyobbSzamla;
    }

    public double getÖsszHitelkeret() {
        double összHitelkeret = 0.0;

        for (Szamla Szamla : számlák) {
            if (Szamla instanceof HitelSzamla) {
                összHitelkeret += ((HitelSzamla) Szamla).getHitelkeret();
            }
        }

        return összHitelkeret;
    }
}
