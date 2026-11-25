package lab3;

public class ClatitaSarata extends Clatita {
    private static final double PRET_PE_GRAM = 0.05;

    private final int gramajUmplutura;

    public ClatitaSarata(String denumire, double pret, int stoc, Aluat aluat, int gramajUmplutura) {
        super(denumire, pret, stoc, aluat);
        if (gramajUmplutura <= 0) {
            throw new IllegalArgumentException("Gramajul umpluturii trebuie sa fie pozitiv");
        }
        this.gramajUmplutura = gramajUmplutura;
    }

    public int getGramajUmplutura() { return gramajUmplutura; }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() + gramajUmplutura * PRET_PE_GRAM);
    }

    @Override
    public String categorie() { return ConstanteStand.CAT_SARATA; }

    @Override
    public String toString() {
        return super.toString() + " [umplutura: " + gramajUmplutura + " g]";
    }
}
