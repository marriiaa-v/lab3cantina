package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Bonul REFERA o comanda creata in afara lui (agregare) si aplica regula proprie a standului. */
public class Bon {
    private static int contor = 0;

    // Regula proprie: "perechea dulce-sarat" - pentru fiecare pereche (o clatita dulce
    // + una sarata) din aceeasi comanda se scad 5.00 lei.
    public static final BigDecimal REDUCERE_PE_PERECHE = new BigDecimal("5.00");

    private final int numar;
    private final Comanda comanda;
    private final int perechi;
    private final BigDecimal reducere;
    private final BigDecimal total;
    private final boolean cuCadou;

    public Bon(Comanda comanda) {
        if (comanda == null || comanda.esteGoala()) {
            throw new IllegalArgumentException("Nu se poate emite bon pentru o comanda goala");
        }
        this.numar = ++contor;
        this.comanda = comanda;
        this.perechi = numaraPerechiDulceSarat(comanda);
        this.reducere = REDUCERE_PE_PERECHE.multiply(BigDecimal.valueOf(perechi));
        BigDecimal rezultat = comanda.subtotal().subtract(reducere);
        if (rezultat.compareTo(BigDecimal.ZERO) < 0) {
            rezultat = BigDecimal.ZERO;
        }
        this.total = rezultat.setScale(2, RoundingMode.HALF_UP);
        this.cuCadou = numar % ConstanteStand.K_CADOU == 0;
    }
    // Regula proprie: "perechea dulce-sarat" - pentru fiecare pereche (o clatita dulce
    // + una sarata) din aceeasi comanda se scad 5.00 lei.
    private static int numaraPerechiDulceSarat(Comanda comanda) {
        int dulci = 0;
        int sarate = 0;
        for (LinieComanda linie : comanda.getLinii()) {
            String categorie = linie.getProdus().categorie();
            if (categorie.equals(ConstanteStand.CAT_DULCE)) {
                dulci += linie.getCantitate();
            } else if (categorie.equals(ConstanteStand.CAT_SARATA)) {
                sarate += linie.getCantitate();
            }
        }
        return Math.min(dulci, sarate);
    }

    public static int getNumarBonuri() { return contor; }

    public int getNumar() { return numar; }

    public boolean areCadou() { return cuCadou; }

    public BigDecimal getTotal() { return total; }

    public void afiseaza() {
        System.out.println("==============================================================");
        System.out.println(" " + ConstanteStand.NUME_STAND + " - BON NR. " + numar);
        System.out.println("==============================================================");
        for (LinieComanda linie : comanda.getLinii()) {
            System.out.println(String.format("%-36s %2d x %6s = %8s", linie.getProdus().getDenumire(),
                    linie.getCantitate(), linie.getPretUnitar().toPlainString(),
                    linie.subtotal().toPlainString()));
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Subtotal: " + comanda.subtotal().toPlainString() + " lei");
        if (perechi > 0) {
            System.out.println("Reducere perechea dulce-sarat (" + perechi + " x "
                    + REDUCERE_PE_PERECHE.toPlainString() + "): -" + reducere.toPlainString() + " lei");
        }
        System.out.println("TOTAL: " + total.toPlainString() + " lei");
        if (cuCadou) {
            System.out.println("*** Bonul nr. " + numar + " (la fiecare " + ConstanteStand.K_CADOU
                    + " bonuri): CADOU - " + ConstanteStand.CADOU + " ***");
        }
        System.out.println("==============================================================");
    }
}
