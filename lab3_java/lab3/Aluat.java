package lab3;

/** Tipul de aluat al clatitei: eticheta si coeficientul de pret. */
public enum Aluat {
    CLASIC("clasic", 1.00),
    INTEGRAL("integral", 1.15),
    FARA_GLUTEN("fara gluten", 1.30);

    private final String eticheta;
    private final double coeficient;

    Aluat(String eticheta, double coeficient) {
        this.eticheta = eticheta;
        this.coeficient = coeficient;
    }

    public String getEticheta() { return eticheta; }

    public double getCoeficient() { return coeficient; }
}
