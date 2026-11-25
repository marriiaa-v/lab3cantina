package lab3;

public class ClatitaDulce extends Clatita {
    private static final double PRET_TOPPING = 3.50;

    private final int toppinguri;

    public ClatitaDulce(String denumire, double pret, int stoc, Aluat aluat, int toppinguri) {
        super(denumire, pret, stoc, aluat);
        if (toppinguri < 0) {
            throw new IllegalArgumentException("Numarul de toppinguri nu poate fi negativ");
        }
        this.toppinguri = toppinguri;
    }

    public int getToppinguri() { return toppinguri; }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() + toppinguri * PRET_TOPPING);
    }

    @Override
    public String categorie() { return ConstanteStand.CAT_DULCE; }

    @Override
    public String toString() {
        return super.toString() + " [toppinguri: " + toppinguri + "]";
    }
}
