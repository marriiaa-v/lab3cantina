package lab3;

public class Clatita extends Produs {
    private final Aluat aluat;

    public Clatita(String denumire, double pret, int stoc, Aluat aluat) {
        super(denumire, pret, stoc);
        if (aluat == null) {
            throw new IllegalArgumentException("Aluatul trebuie ales");
        }
        this.aluat = aluat;
    }

    public Aluat getAluat() { return aluat; }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() * aluat.getCoeficient());
    }

    @Override
    public String categorie() { return "clatita"; }

    @Override
    public String toString() {
        return super.toString() + " [aluat " + aluat.getEticheta() + "]";
    }
}
