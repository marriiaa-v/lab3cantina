package lab3;

import java.util.ArrayList;

/** Meniul REFERA produse create in afara lui (agregare). */
public class Meniu {
    private final String denumire;
    private final ArrayList<Produs> produse = new ArrayList<>();

    public Meniu(String denumire) {
        this.denumire = denumire;
    }

    public void adaugaProdus(Produs p) {
        produse.add(p);
    }

    // true doar daca in meniu se afla EXACT acelasi obiect (referinta)
    public boolean contine(Produs p) {
        for (Produs existent : produse) {
            if (existent == p) return true;
        }
        return false;
    }

    public void afiseaza() {
        System.out.println("=== " + denumire + " ===");
        for (Produs p : produse) {
            System.out.printf("  %-36s %6.2f lei%n", p.getDenumire(), p.pretFinal());
        }
    }
}
