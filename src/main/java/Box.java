import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// класс "Коробка" служит для хранения пердметов

public class Box extends Item implements PutGetItem {

    private double allowadlWeight;  // допустимый вес
    private Set<Item>insideItems;   // что содержит

    // Конструктор по умолчанию
    public Box() {
        super ("Стандартная коробка", 1.0, true, true);
        this.allowadlWeight = 20.0;
        this.insideItems = new LinkedHashSet<Item>();
    }

    // Конструктор со всеми параметрами
    public Box(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, double allowadlWeight) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowadlWeight = allowadlWeight;
        this.insideItems = new LinkedHashSet<Item>();
        }

    // Конструктор без мноества
    public Box(String name, double weight, boolean flat, boolean bigSize, double allowadlWeight) {
        super(name, weight, flat, bigSize);
        this.allowadlWeight = allowadlWeight;
        this.insideItems = new LinkedHashSet<Item>();
    }

    @Override
    public String toString() {
        return "Коробка " + name + " {" +
                " содержит:" + insideItems +
                "весом: " + getCurrentweigth() + "кг." +
                ", плоский:" + flat +
                ", большой:" + bigSize +
                ", другие параметры:" + otherCharacters +
                ", грузоподъемность:" + allowadlWeight +
                '}';
    }

    // Реализация интерфейса GetPutItem ---

    public void putItem(Item item) {

        if (!item.bigSize) {
            if (insideItems.contains(item)) System.out.println("Это здесьб уже есть!");
            double weigthMax = 0.0;
            for (Item i : insideItems) {
                weigthMax = weigthMax + i.weight;
            }
            if ((weigthMax + item.weight) <= this.allowadlWeight) {
                try {
                    insideItems.add(item);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e);
                }
            } else System.out.println("Максимально разрешенный вес " + this.name + " превышен");
        }
            else System.out.println("этот предмет слишком большой, попробуйте воспользоватся мешком.");
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
    // --- Реализация интерфейса GetPutItem



    public double getAllowadlWeight() {
        return allowadlWeight;
    }

    public void setAllowadlWeight(double allowadlWeight) {
        this.allowadlWeight = allowadlWeight;
    }

    public Set<Item> getInsideItems() {
        return insideItems;
    }

    public void setInsideItems(Set<Item> insideItems) {

        this.insideItems = insideItems;

    }
}
