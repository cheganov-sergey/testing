
    // Класс "Мяч" предмет

public class Ball extends Item {
    public Ball() {
        super("Шар", 20.0, false, true);
    }

    @Override
    public String toString() {
        return name;
    }

}
