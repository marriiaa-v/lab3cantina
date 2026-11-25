package lab3;

import java.util.Locale;

public class Lab3E2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("Constante: N = " + ConstanteStand.N
                + ", MIN_PRODUSE = " + ConstanteStand.MIN_PRODUSE
                + ", REDUCERE_COMBO = " + ConstanteStand.REDUCERE_COMBO + "%"
                + ", K_CADOU = " + ConstanteStand.K_CADOU);

        Produs a = new Produs("Test A", 10, 5);
        Produs b = new Produs("Test B", 12.5);      // constructorul scurt -> this(...)
        Produs c = new Produs("Test C", 8, 2);
        System.out.println("Id-uri: " + a.getId() + ", " + b.getId() + ", " + c.getId()
                + "  (al treilea produs are id " + c.getId() + ")");
        System.out.println(b);

        try {
            new Produs("", 10, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Denumire goala  -> " + e.getMessage());
        }
        try {
            new Produs("Test D", -3, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Pret negativ    -> " + e.getMessage());
        }
        try {
            new Produs("Test E", 3, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Stoc negativ    -> " + e.getMessage());
        }

        Produs d = new Produs("Test D", 9, 1);
        System.out.println("Dupa 3 constructii esuate, urmatorul produs are id " + d.getId());

        System.out.println("a.equals(\"test a\") -> " + a.equals(new Produs("test a", 99, 1)));
        System.out.println("a.equals(b)        -> " + a.equals(b));
    }
}
