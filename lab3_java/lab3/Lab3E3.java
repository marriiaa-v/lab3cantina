package lab3;

import java.util.Locale;

public class Lab3E3 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Catalog catalog = new Catalog();

        System.out.println("=== " + ConstanteStand.NUME_STAND + " ===");
        System.out.println("Produse in catalog: " + catalog.getProduse().size()
                + " (minim cerut: " + ConstanteStand.MIN_PRODUSE + ")");

        for (Produs p : catalog.getProduse()) {
            System.out.println(p);
        }
    }
}
