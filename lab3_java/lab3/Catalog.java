package lab3;

import java.util.ArrayList;

/** Catalogul standului: cele 9 produse de baza (create o singura data). */
public class Catalog {
    private final ClatitaDulce nutella =
            new ClatitaDulce("Clatita cu Nutella si banane", 22.00, 6, Aluat.CLASIC, 1);
    private final ClatitaDulce visine =
            new ClatitaDulce("Clatita cu dulceata de visine", 18.00, 5, Aluat.INTEGRAL, 0);
    private final ClatitaDulce branzaDulce =
            new ClatitaDulce("Clatita cu branza dulce si stafide", 20.00, 4, Aluat.FARA_GLUTEN, 1);
    private final ClatitaSarata sunca =
            new ClatitaSarata("Clatita cu sunca si cascaval", 21.00, 6, Aluat.CLASIC, 120);
    private final ClatitaSarata spanac =
            new ClatitaSarata("Clatita cu branza si spanac", 20.00, 5, Aluat.INTEGRAL, 100);
    private final ClatitaSarata pui =
            new ClatitaSarata("Clatita cu pui si ciuperci", 23.00, 3, Aluat.CLASIC, 150);
    private final Bautura cappuccino = new Bautura("Cappuccino", 14.00, 20, 250);
    private final Bautura limonada = new Bautura("Limonada cu menta", 12.00, 15, 400);
    private final Bautura ceai = new Bautura("Ceai de fructe", 10.00, 15, 300);

    private final ArrayList<Produs> produse = new ArrayList<>();

    public Catalog() {
        produse.add(nutella);
        produse.add(visine);
        produse.add(branzaDulce);
        produse.add(sunca);
        produse.add(spanac);
        produse.add(pui);
        produse.add(cappuccino);
        produse.add(limonada);
        produse.add(ceai);
    }

    public ArrayList<Produs> getProduse() { return produse; }

    public ClatitaDulce getNutella() { return nutella; }

    public ClatitaDulce getVisine() { return visine; }

    public ClatitaDulce getBranzaDulce() { return branzaDulce; }

    public ClatitaSarata getSunca() { return sunca; }

    public ClatitaSarata getSpanac() { return spanac; }

    public ClatitaSarata getPui() { return pui; }

    public Bautura getCappuccino() { return cappuccino; }

    public Bautura getLimonada() { return limonada; }

    public Bautura getCeai() { return ceai; }
}
