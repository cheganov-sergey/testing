/**
 * Класс "Блок" (большой кирпич) пердмет
 */
public class Blok extends Item {

    public Blok() {
        super("Блок", 10.0, true, false);
    }

    @Override
    public String toString() {
        return getName();
    }
}
