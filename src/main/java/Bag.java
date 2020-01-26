import java.util.HashSet;
import java.util.Set;

// Класс "Мешок" служит для хранения пердметов

public class Bag extends Item implements PutGetItem {

    private double allowedWeigth;   // допустимый вес
    private Set<Item> insideItems;   // что содержит

    public Bag(){
        super ("стандартный мешок", 0.5, false, true);
        this.allowedWeigth = 50.0;
        this.insideItems = new HashSet<Item>();
    }

    public Bag(double allowedWeigth, Set<Item> insideItems) {
        this.allowedWeigth = allowedWeigth;
        this.insideItems = new HashSet<Item>(insideItems);
    }

    public Bag(String name, double weight, boolean flat, boolean bigSize, double allowedWeigth, Set<Item> insideItems) {
        super(name, weight, flat, bigSize);
        this.allowedWeigth = allowedWeigth;
        this.insideItems = new HashSet<Item>(insideItems);
    }

    public Bag(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, double allowedWeigth, Set<Item> insideItems) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowedWeigth = allowedWeigth;
        this.insideItems = new HashSet<Item>(insideItems);
    }

    // Реализация итерфейса --
    public void putItem(Item item) {
        double weigthMax = 0.0;
        for (Item i : insideItems) {
            weigthMax = weigthMax + i.weight;
        }
        if ((weigthMax + item.weight) <= this.allowedWeigth) {
            try {
                insideItems.add(item);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e);
            }
        } else System.out.println("Максимально разрешенный вес " + this.name + " превышен");
    }


    public void getItem(Item item) {
        if (insideItems.contains(item)) {
            insideItems.remove(item);
        }
        else System.out.println("данного предмета здесть нет!");
    }

    public void showItem() {
        if (!this.insideItems.isEmpty()) {
            System.out.println(name + " весом " + getCurrentweigth() + ", здесть находится:");
            for (Item it : insideItems)
                System.out.println(it);
        }
        else System.out.println("здесь пусто!");
    }

    public double getCurrentweigth() {
        double currentWeigth = this.weight;
        for(Item it : insideItems) {
            currentWeigth = currentWeigth + it.weight;
        }
        return currentWeigth;
    }

    // -- Реализация итерфейса


    @Override
    public String toString() {
        return "Мешок {" + name +
                " допустимый вес:" + allowedWeigth +
                ", содержит предметы:" + insideItems +
                " весом: " + getCurrentweigth() + " кг. " +
                ", плоский:" + flat +
                ", большой размер:" + bigSize +
                ", другие параметры:" + otherCharacters +
                '}';
    }

    public double getAllowedWeigth() {
        return allowedWeigth;
    }

    public Set<Item> getInsideItems() {
        return insideItems;
    }
}
