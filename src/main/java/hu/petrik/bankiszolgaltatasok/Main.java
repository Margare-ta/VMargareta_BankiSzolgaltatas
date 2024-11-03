package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(); 
        Tulajdonos tulajdonos = new Tulajdonos("Kovács János");

        // Szamla nyitása
        Szamla hitelSzamla = bank.SzamlaNyitás(tulajdonos, 50000); // HitelSzamla létrehozása
        Szamla megtakarításiSzamla = bank.SzamlaNyitás(tulajdonos, 0); // MegtakarításiSzamla létrehozása

        // Befizetések
        hitelSzamla.befizet(30000);
        megtakarításiSzamla.befizet(10000);

        // Össz egyenleg lekérdezése
        double összEgyenleg = bank.getÖsszEgyenleg(tulajdonos);
        System.out.println("Össz egyenleg: " + összEgyenleg + " HUF"); // Kiírja: Össz egyenleg: 40000 HUF

        // Legnagyobb egyenlegű Szamla lekérdezése
        Szamla legnagyobbSzamla = bank.getLegnagyobbEgyenlegűSzamla(tulajdonos);
        System.out.println("Legnagyobb egyenlegű Szamla egyenlege: " + (legnagyobbSzamla != null ? legnagyobbSzamla.getEgyenleg() : "Nincs Szamla"));

        // Hitelkeretek összegének lekérdezése
        double összHitelkeret = bank.getÖsszHitelkeret();
        System.out.println("Össz hitelkeret: " + összHitelkeret + " HUF");
    }
}
