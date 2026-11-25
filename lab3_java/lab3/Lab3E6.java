package lab3;

import java.util.Locale;

public class Lab3E6 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Catalog catalog = new Catalog();
        Produs cappuccino = catalog.getCappuccino();
        Produs nutella = catalog.getNutella();

        // ---------- 6.1 Agregarea ----------
        Meniu meniuDimineata = new Meniu("Meniul diminetii");
        Meniu meniuZilei = new Meniu("Meniul zilei");
        meniuDimineata.adaugaProdus(cappuccino);
        meniuDimineata.adaugaProdus(catalog.getCeai());
        meniuDimineata.adaugaProdus(nutella);
        meniuZilei.adaugaProdus(catalog.getSunca());
        meniuZilei.adaugaProdus(catalog.getLimonada());
        meniuZilei.adaugaProdus(cappuccino);

        System.out.println("(1) Acelasi obiect in doua meniuri:");
        System.out.println("    Cappuccino (id " + cappuccino.getId() + ") in Meniul diminetii: "
                + meniuDimineata.contine(cappuccino));
        System.out.println("    Cappuccino (id " + cappuccino.getId() + ") in Meniul zilei:     "
                + meniuZilei.contine(cappuccino));
        meniuDimineata.afiseaza();
        meniuZilei.afiseaza();

        System.out.println("\n(2) Modificam pretul prin setter: setPret(16.00)");
        cappuccino.setPret(16.00);
        meniuDimineata.afiseaza();
        meniuZilei.afiseaza();

        System.out.println("\n(3) meniuDimineata = null");
        meniuDimineata = null;
        System.out.println("    Produsul exista in continuare: " + cappuccino);
        Comanda comanda = new Comanda();
        boolean ok = comanda.adauga(cappuccino, 1);
        System.out.println("    Cappuccino poate fi comandat: " + ok);

        // ---------- 6.2 Meniul combo ----------
        System.out.println("\n--- Meniul combo ---");
        cappuccino.setPret(14.00);          // revenim la pretul initial
        MeniuCombo comboDulce = Combouri.dulce(catalog);
        MeniuCombo comboSarat = Combouri.sarat(catalog);
        System.out.println(comboDulce);
        System.out.println("Suma preturilor finale ale componentelor: "
                + comboDulce.sumaComponente().toPlainString() + " lei");
        System.out.println("Pret final combo (reducere " + ConstanteStand.REDUCERE_COMBO + "%): "
                + comboDulce.pretFinal() + " lei");
        System.out.println(comboSarat);

        System.out.println("\nCombo cu o componenta epuizata:");
        Comanda epuizeaza = new Comanda();
        epuizeaza.adauga(catalog.getSunca(), 6);                 // stocul de sunca ajunge la 0
        System.out.println("  Stoc Clatita cu sunca: " + catalog.getSunca().getStoc()
                + ", stoc Combo Sarat: " + comboSarat.getStoc());
        Comanda refuz = new Comanda();
        refuz.adauga(comboSarat, 1);
        System.out.println("  Combo-ul adaugat in comanda? " + !refuz.esteGoala());
    }
}
