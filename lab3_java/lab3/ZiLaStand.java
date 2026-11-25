package lab3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;

public class ZiLaStand {
    private final Catalog catalog = new Catalog();
    private final MeniuCombo comboDulce = Combouri.dulce(catalog);
    private final MeniuCombo comboSarat = Combouri.sarat(catalog);
    private final ArrayList<Comanda> comenzi = new ArrayList<>();
    private final ArrayList<Bon> bonuri = new ArrayList<>();

    private void inchideComanda(Comanda comanda) {
        if (comanda.esteGoala()) {
            System.out.println("Comanda goala: nu se emite bon.");
            return;
        }
        Bon bon = new Bon(comanda);
        bon.afiseaza();
        comenzi.add(comanda);
        bonuri.add(bon);
    }

    public void ruleazaZiua() {
        System.out.println("##### Ziua la " + ConstanteStand.NUME_STAND + " #####");

        System.out.println("\n--- Comanda 1: clatite dulci si cappuccino ---");
        Comanda c1 = new Comanda();
        c1.adauga(catalog.getNutella(), 2);
        c1.adauga(catalog.getCappuccino(), 1);
        inchideComanda(c1);

        System.out.println("\n--- Comanda 2: meniul combo ---");
        Comanda c2 = new Comanda();
        c2.adauga(comboDulce, 1);
        c2.adauga(catalog.getCeai(), 1);
        inchideComanda(c2);

        System.out.println("\n--- Comanda 3: regula 'perechea dulce-sarat' ---");
        Comanda c3 = new Comanda();
        c3.adauga(catalog.getVisine(), 2);
        c3.adauga(catalog.getSunca(), 1);
        c3.adauga(catalog.getSpanac(), 1);
        c3.adauga(catalog.getCappuccino(), 2);
        inchideComanda(c3);

        System.out.println("\n--- Comanda 4: refuzata partial (stoc insuficient) ---");
        Comanda c4 = new Comanda();
        c4.adauga(catalog.getPui(), 2);
        c4.adauga(catalog.getPui(), 2);
        c4.adauga(catalog.getLimonada(), 1);
        inchideComanda(c4);

        System.out.println("\n--- Comanda 5: combo sarat (bonul nr. " + ConstanteStand.K_CADOU + ") ---");
        Comanda c5 = new Comanda();
        c5.adauga(comboSarat, 1);
        c5.adauga(catalog.getCappuccino(), 1);
        inchideComanda(c5);

        System.out.println("\n--- Comanda 6: regula activa, ultimele clatite cu pui ---");
        Comanda c6 = new Comanda();
        c6.adauga(catalog.getPui(), 1);
        c6.adauga(catalog.getBranzaDulce(), 1);
        c6.adauga(catalog.getCeai(), 2);
        inchideComanda(c6);

        System.out.println("\n--- Comanda 7: totul refuzat (pui epuizat) ---");
        Comanda c7 = new Comanda();
        c7.adauga(catalog.getPui(), 1);
        inchideComanda(c7);

        raportulZilei();
    }

    private void raportulZilei() {
        System.out.println("\n##### RAPORTUL ZILEI #####");
        System.out.println("Numar de bonuri: " + Bon.getNumarBonuri());

        BigDecimal incasari = BigDecimal.ZERO;
        StringBuilder suma = new StringBuilder();
        for (Bon bon : bonuri) {
            incasari = incasari.add(bon.getTotal());
            if (suma.length() > 0) suma.append(" + ");
            suma.append(bon.getTotal().toPlainString());
        }
        System.out.println("Incasari totale: " + incasari.toPlainString() + " lei");
        System.out.println("  (" + suma + ")");

        // produsul cel mai vandut: dupa cantitatile din liniile comenzilor
        ArrayList<Produs> toate = new ArrayList<>(catalog.getProduse());
        toate.add(comboDulce);
        toate.add(comboSarat);
        Produs celMaiVandut = null;
        int maxim = 0;
        for (Produs p : toate) {
            int vandute = 0;
            for (Comanda comanda : comenzi) {
                for (LinieComanda linie : comanda.getLinii()) {
                    if (linie.getProdus().equals(p)) {
                        vandute += linie.getCantitate();
                    }
                }
            }
            if (vandute > maxim) {
                maxim = vandute;
                celMaiVandut = p;
            }
        }
        if (celMaiVandut != null) {
            System.out.println("Cel mai vandut produs: " + celMaiVandut.getDenumire()
                    + " (" + maxim + " buc.)");
        }

        System.out.println("Stoc ramas:");
        for (Produs p : toate) {
            System.out.printf("  %-36s %3d%n", p.getDenumire(), p.getStoc());
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        new ZiLaStand().ruleazaZiua();
    }
}
