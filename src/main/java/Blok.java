public class Blok extends Item {

    // Класс "Блок" пердмет

    public Blok() {
        super("Блок", 10.0, true, false);
    }

    @Override
    public String toString() {
        return name;
    }
}
