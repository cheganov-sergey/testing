/**
 * Колесо - пердмет
 */
public class Whell extends Item {

   public Whell() {
        super("Колесо", 20.0, true, true, false);
    }

    @Override
    public String toString() {
        return getName();
    }
}
