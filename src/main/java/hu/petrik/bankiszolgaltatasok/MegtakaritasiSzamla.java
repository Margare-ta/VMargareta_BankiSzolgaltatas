package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends  Szamla{
    public static short alapKamat;
    private double kamat;
    private static final double ALAPKAMAT = 1.1;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = ALAPKAMAT;
    }

     public double getKamat() {
        return kamat;
    }

     public void setKamat(double kamat) {
        if (kamat > 0) {
            this.kamat = kamat;
        } else {
            System.out.println("A kamat mértéke nem lehet nulla vagy negatív.");
        }
    }

    @Override
    public boolean kivesz(double osszeg) {
        double ujEgyenleg = getEgyenleg() - osszeg;

         if (ujEgyenleg >= 0) {
            super.kivesz(osszeg);
            return true;
        } else {
            System.out.println("A kivétel nem engedélyezett. Az egyenleg nem csökkenhet 0 alá.");
            return false;
        }
    }

    /public void kamatJóváírás() {
        double ujEgyenleg = getEgyenleg() * kamat;
        super.befizet(ujEgyenleg - getEgyenleg());
        System.out.println("Kamat jóváírás: " + (ujEgyenleg - getEgyenleg()) + " HUF. Új egyenleg: " + getEgyenleg() + " HUF.");
    }

    @Override
    public void nyujtSzolgaltatas() {
        System.out.println("MegtakarításiSzámla szolgáltatás nyújtása a tulajdonosnak: " + getTulajdonos().getNev());
    }

   
}
