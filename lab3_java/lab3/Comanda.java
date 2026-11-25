package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Comanda DETINE liniile sale (compozitie): le creeaza ea si dispar odata cu ea. */
public class Comanda {
    private final ArrayList<LinieComanda> linii = new ArrayList<>();

    public boolean adauga(Produs p, int cantitate) {
        if (p == null || cantitate <= 0) {
            System.out.println("  Refuzat: cantitate sau produs invalid");
            return false;
        }
        if (!p.esteDisponibil(cantitate)) {
            System.out.println("  Refuzat: " + p.getDenumire() + " x" + cantitate
                    + " (stoc disponibil: " + p.getStoc() + ")");
            return false;
        }
        p.scadeStoc(cantitate);
        for (LinieComanda linie : linii) {
            if (linie.getProdus().equals(p)) {      // acelasi produs -> aceeasi linie
                linie.maresteCantitatea(cantitate);
                return true;
            }
        }
        linii.add(new LinieComanda(p, cantitate));
        return true;
    }

    public List<LinieComanda> getLinii() {
        return Collections.unmodifiableList(linii);
    }

    public boolean esteGoala() { return linii.isEmpty(); }

    public BigDecimal subtotal() {
        BigDecimal suma = BigDecimal.ZERO;
        for (LinieComanda linie : linii) {
            suma = suma.add(linie.subtotal());
        }
        return suma.setScale(2, RoundingMode.HALF_UP);
    }
}
