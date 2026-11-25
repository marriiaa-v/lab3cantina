package lab3;
import java.util.Locale;
import java.util.Objects;

public class Produs {
    private static final int STOC_IMPLICIT = 10;
    private static int contorId = 0;            // contor static pentru id
    private final int id;                       // atribuit automat, nu se mai schimba
    private String denumire;
    private double pret;
    private int stoc;

    // constructor scurt: il apeleaza pe cel complet prin this(...)
    public Produs(String denumire, double pret) {
        this(denumire, pret, STOC_IMPLICIT);
    }
    // singurul loc in care se valideaza datele
    public Produs(String denumire, double pret, int stoc) {
        if (denumire == null || denumire.trim().isEmpty()) {
            throw new IllegalArgumentException("Denumirea nu poate fi goala");
        }
        if (pret < 0) {
            throw new IllegalArgumentException("Pretul nu poate fi negativ: " + pret);
        }
        if (stoc < 0) {
            throw new IllegalArgumentException("Stocul nu poate fi negativ: " + stoc);
        }
        this.id = ++contorId;
        this.denumire = denumire.trim();
        this.pret = pret;
        this.stoc = stoc;
    }

    public int getId() { return id; }

    public String getDenumire() { return denumire; }

    public double getPret() { return pret; }

    public void setPret(double pret) {
        if (pret < 0) {
            throw new IllegalArgumentException("Pretul nu poate fi negativ: " + pret);
        }
        this.pret = pret;
    }

    public int getStoc() { return stoc; }

    public boolean esteDisponibil(int cantitate) {
        return cantitate > 0 && getStoc() >= cantitate;
    }

    public void scadeStoc(int cantitate) {
        if (!esteDisponibil(cantitate)) {
            throw new IllegalStateException("Stoc insuficient pentru " + denumire);
        }
        stoc -= cantitate;
    }

    public String categorie() { return "produs"; }

    // in Produs: pretul de baza; subclasele il suprascriu
    public double pretFinal() { return getPret(); }

    // metode ajutatoare pentru subclase
    protected static double rotunjeste(double valoare) {
        return Math.round(valoare * 100) / 100.0;
    }

    protected static String lei(double valoare) {
        return String.format(Locale.US, "%.2f", valoare);
    }

    @Override
    public String toString() {
        return "#" + id + " " + denumire + " | baza " + lei(getPret())
                + " lei | final " + lei(pretFinal()) + " lei | stoc " + getStoc();
    }

    // doua produse sunt egale daca au aceeasi denumire (si acelasi tip)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs altul = (Produs) o;
        return denumire.equalsIgnoreCase(altul.denumire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denumire.toLowerCase());
    }
}
