package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** O linie a comenzii. Constructorul NU este public: liniile se creeaza doar in Comanda. */
public class LinieComanda {
    private final Produs produs;
    private int cantitate;

    LinieComanda(Produs produs, int cantitate) {
        this.produs = produs;
        this.cantitate = cantitate;
    }

    void maresteCantitatea(int suplimentar) {
        cantitate += suplimentar;
    }

    public Produs getProdus() { return produs; }

    public int getCantitate() { return cantitate; }

    public BigDecimal getPretUnitar() {
        return BigDecimal.valueOf(produs.pretFinal()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal subtotal() {
        return getPretUnitar().multiply(BigDecimal.valueOf(cantitate))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return cantitate + " x " + produs.getDenumire() + " = " + subtotal().toPlainString() + " lei";
    }
}
