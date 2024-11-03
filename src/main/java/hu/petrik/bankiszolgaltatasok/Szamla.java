package hu.petrik.bankiszolgaltatasok;

public class Szamla extends BankiSzolgaltatas {
    private double egyenleg;

     public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.egyenleg = 0.0;
    }

    public double getEgyenleg() {
        return egyenleg;
    }

    public void befizet(double osszeg) {
        if (osszeg > 0) {
            egyenleg += osszeg;
            System.out.println("Befizetés: " + osszeg + " HUF. Új egyenleg: " + egyenleg + " HUF.");
        } else {
            System.out.println("A befizetett összeg nem lehet negatív vagy nulla.");
        }
    }

    public Kartya újKártya(String kártyaszám) {
        return new Kartya(getTulajdonos(), this, kártyaszám); // Új kártya létrehozása a számla tulajdonosával és a számlával
    }

    public boolean kivesz(double osszeg) {
        double ujEgyenleg = egyenleg - osszeg; // Számítsuk ki az új egyenleget
        if (ujEgyenleg >= 0) {
            egyenleg = ujEgyenleg; // Ha érvényes, csökkentjük az egyenleget
            return true; // Sikeres kivétel
        } else {
            System.out.println("A kivétel nem engedélyezett. Az egyenleg nem csökkenhet 0 alá.");
            return false; // Sikertelen kivétel
        }
    }

    @Override
    public void nyujtSzolgaltatas() {
        System.out.println("Számla szolgáltatás nyújtása a tulajdonosnak: " + getTulajdonos().getNev());
    }
}
