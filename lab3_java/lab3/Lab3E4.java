package lab3;

import java.math.BigDecimal;
import java.util.Locale;

public class Lab3E4 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Catalog catalog = new Catalog();
        Produs nutella = catalog.getNutella();
        Produs pui = catalog.getPui();

        Comanda comanda = new Comanda();
        comanda.adauga(nutella, 2);
        comanda.adauga(catalog.getCappuccino(), 1);
        comanda.adauga(nutella, 1);          // acelasi produs -> aceeasi linie
        System.out.println("Linii in comanda: " + comanda.getLinii().size() + " (3 adaugari)");
        for (LinieComanda linie : comanda.getLinii()) {
            System.out.println("  " + linie);
        }
        System.out.println("Stoc Nutella: " + nutella.getStoc() + " (6 - 3)");

        System.out.println("\nStoc " + pui.getDenumire() + " inainte: " + pui.getStoc());
        comanda.adauga(pui, 10);             // refuzat
        System.out.println("Stoc " + pui.getDenumire() + " dupa refuz: " + pui.getStoc());
        System.out.println("Linii in comanda: " + comanda.getLinii().size());

        System.out.println("\nTotal (BigDecimal): " + comanda.subtotal().toPlainString() + " lei");

        System.out.println("\n--- Experiment BigDecimal ---");
        double s = 0;
        for (int i = 0; i < 10; i++) s += 0.10;
        System.out.println("double: " + s);
        BigDecimal b = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) b = b.add(new BigDecimal("0.10"));
        System.out.println("BigDecimal: " + b);
        System.out.println("new BigDecimal(\"0.10\") = " + new BigDecimal("0.10"));
        System.out.println("new BigDecimal(0.10)   = " + new BigDecimal(0.10));
    }
}
