package lab3;

public class Bautura extends Produs {
    private static final double VOLUM_REFERINTA = 250.0;   // pretul de baza e pentru 250 ml

    private final int volumMl;

    public Bautura(String denumire, double pret, int stoc, int volumMl) {
        super(denumire, pret, stoc);
        if (volumMl <= 0) {
            throw new IllegalArgumentException("Volumul trebuie sa fie pozitiv");
        }
        this.volumMl = volumMl;
    }

    public int getVolumMl() { return volumMl; }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() * volumMl / VOLUM_REFERINTA);
    }

    @Override
    public String categorie() { return ConstanteStand.CAT_BAUTURA; }

    @Override
    public String toString() {
        return super.toString() + " [" + volumMl + " ml]";
    }
}
