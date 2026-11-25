package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/** Un combo ESTE un Produs si, in acelasi timp, ARE produse (agregare). */
public class MeniuCombo extends Produs {
    private final ArrayList<Produs> componente = new ArrayList<>();

    public MeniuCombo(String denumire) {
        super(denumire, 0, 0);      // pretul si stocul combo-ului se deriva din componente
    }

    public void adaugaComponenta(Produs p) {
        if (p == null) {
            throw new IllegalArgumentException("Componenta nu poate fi null");
        }
        componente.add(p);
    }

    public int numarComponente() { return componente.size(); }

    // pretul de baza al combo-ului = suma preturilor de baza ale componentelor
    @Override
    public double getPret() {
        BigDecimal suma = BigDecimal.ZERO;
        for (Produs p : componente) {
            suma = suma.add(BigDecimal.valueOf(p.getPret()));
        }
        return suma.doubleValue();
    }

    // suma preturilor finale ale componentelor, inainte de reducere
    public BigDecimal sumaComponente() {
        BigDecimal suma = BigDecimal.ZERO;
        for (Produs p : componente) {
            suma = suma.add(BigDecimal.valueOf(p.pretFinal()));
        }
        return suma.setScale(2, RoundingMode.HALF_UP);
    }

    // pret final = suma preturilor finale - reducerea personala (14%)
    @Override
    public double pretFinal() {
        BigDecimal suma = sumaComponente();
        BigDecimal reducere = suma.multiply(BigDecimal.valueOf(ConstanteStand.REDUCERE_COMBO))
                .divide(BigDecimal.valueOf(100));
        return suma.subtract(reducere).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    // stocul combo-ului = stocul celei mai putin disponibile componente
    @Override
    public int getStoc() {
        if (componente.isEmpty()) return 0;
        int minim = Integer.MAX_VALUE;
        for (Produs p : componente) {
            minim = Math.min(minim, p.getStoc());
        }
        return minim;
    }
    // vanzarea combo-ului scade stocul fiecarei componente
    @Override
    public void scadeStoc(int cantitate) {
        if (!esteDisponibil(cantitate)) {
            throw new IllegalStateException("Combo indisponibil: " + getDenumire());
        }
        for (Produs p : componente) {
            p.scadeStoc(cantitate);
        }
    }

    @Override
    public String categorie() { return ConstanteStand.CAT_COMBO; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" [componente: ");
        for (int i = 0; i < componente.size(); i++) {
            if (i > 0) sb.append(" + ");
            sb.append(componente.get(i).getDenumire());
        }
        sb.append(", reducere ").append(ConstanteStand.REDUCERE_COMBO).append("%]");
        return sb.toString();
    }
}
