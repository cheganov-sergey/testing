/**
 * Класс "Кирпич" предмет
 */

public class Brick extends Item {

    public Brick() {
        super("Кирпич", 2.0, true, false);
    }

    @Override
    public String toString() {
        return  getName();
    }
}
