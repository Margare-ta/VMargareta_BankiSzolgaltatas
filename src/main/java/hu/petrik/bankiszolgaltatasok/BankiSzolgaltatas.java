package hu.petrik.bankiszolgaltatasok;

public class BankiSzolgaltatas {
    private final Tulajdonos tulajdonos;

    protected BankiSzolgaltatas(Tulajdonos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

     public Tulajdonos getTulajdonos() {
        return tulajdonos;
    }

    public void nyujtSzolgaltatas() {

    }
}
