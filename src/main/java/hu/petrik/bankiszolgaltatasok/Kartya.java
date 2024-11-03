package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgaltatas{
    private final Szamla mögöttesSzámla;
    private final String kártyaszám;

     public Kartya(Tulajdonos tulajdonos, Szamla mögöttesSzámla, String kártyaszám) {
        super(tulajdonos);
        this.mögöttesSzámla = mögöttesSzámla;
        this.kártyaszám = kártyaszám;
    }

    public String getKártyaszám() {
        return kártyaszám;
    }

    public boolean vásárlás(double osszeg) {
        if (mögöttesSzámla.kivesz(osszeg)) {
            System.out.println("Vásárlás sikeres: " + osszeg + " HUF.");
            return true;
        } else {
            System.out.println("Vásárlás sikertelen: nem elegendő egyenleg.");
            return false;
        }
    }

    @Override
    public void nyujtSzolgaltatas() {
        System.out.println("Kártya szolgáltatás nyújtása a tulajdonosnak: " + getTulajdonos().getNev());
    }
}
