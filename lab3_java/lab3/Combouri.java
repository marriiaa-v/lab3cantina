package lab3;

/** Fabrica celor doua combo-uri ale standului (componentele vin din catalog: agregare). */
public final class Combouri {

    public static MeniuCombo dulce(Catalog catalog) {
        MeniuCombo combo = new MeniuCombo("Combo Dulce");
        combo.adaugaComponenta(catalog.getNutella());
        combo.adaugaComponenta(catalog.getCappuccino());
        return combo;
    }

    public static MeniuCombo sarat(Catalog catalog) {
        MeniuCombo combo = new MeniuCombo("Combo Sarat");
        combo.adaugaComponenta(catalog.getSunca());
        combo.adaugaComponenta(catalog.getLimonada());
        return combo;
    }

    private Combouri() { }
}
