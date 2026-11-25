package lab3;

import java.util.Locale;

public class Lab3E5 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Catalog catalog = new Catalog();

        System.out.println("Scenariul 1: regula NU se activeaza (doar clatite dulci)");
        Comanda c1 = new Comanda();
        c1.adauga(catalog.getNutella(), 1);
        c1.adauga(catalog.getVisine(), 1);
        new Bon(c1).afiseaza();

        System.out.println("\nScenariul 2: regula se activeaza (o dulce + o sarata)");
        Comanda c2 = new Comanda();
        c2.adauga(catalog.getBranzaDulce(), 1);
        c2.adauga(catalog.getSunca(), 1);
        c2.adauga(catalog.getCappuccino(), 1);
        new Bon(c2).afiseaza();

        System.out.println("\nBonurile 3, 4 si 5 (k = " + ConstanteStand.K_CADOU + ")");
        for (int i = 3; i <= ConstanteStand.K_CADOU; i++) {
            Comanda c = new Comanda();
            c.adauga(catalog.getCeai(), 1);
            Bon bon = new Bon(c);
            if (i >= ConstanteStand.K_CADOU - 1) {
                bon.afiseaza();
            } else {
                System.out.println("Bon nr. " + bon.getNumar() + " emis, cadou: " + bon.areCadou());
            }
        }
    }
}
