package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final double hitelkeret;

    public HitelSzamla(Tulajdonos tulajdonos, double hitelkeret) {
        super(tulajdonos);
        this.hitelkeret = hitelkeret;
    }

    public double getHitelkeret() {
        return hitelkeret;
    }

    @Override
    public boolean kivesz(double osszeg) {
        double ujEgyenleg = getEgyenleg() - osszeg;

         if (ujEgyenleg >= -hitelkeret) {
              super.befizet(-osszeg);
            return true;
        } else {
            System.out.println("A kivétel nem engedélyezett. A hitelkeret túllépése.");
            return false;
        }
    }

    @Override
    public void nyujtSzolgaltatas() {
        System.out.println("HitelSzámla szolgáltatás nyújtása a tulajdonosnak: " + getTulajdonos().getNev());
    }
}
