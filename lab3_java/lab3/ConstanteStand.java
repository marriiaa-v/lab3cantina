package lab3;

/** Constantele standului; valorile numerice depind de N (numarul din catalog). */
public final class ConstanteStand {
    public static final int N = 10;
    public static final int MIN_PRODUSE = 6 + N % 3;       // 7 produse distincte
    public static final int REDUCERE_COMBO = 10 + N % 6;   // 14 (%)
    public static final int K_CADOU = 3 + N % 4;           // fiecare al 5-lea bon

    public static final String NUME_STAND = "Clataria FFI";
    public static final String CADOU = "o mini-clatita cu zahar pudra";

    public static final String CAT_DULCE = "clatita dulce";
    public static final String CAT_SARATA = "clatita sarata";
    public static final String CAT_BAUTURA = "bautura";
    public static final String CAT_COMBO = "combo";

    private ConstanteStand() { }
}

