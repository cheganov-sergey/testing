import java.util.*;

// класс "Коробка" служит для хранения пердметов

public class Box extends Item implements PutGetItem {

    private double allowadlWeight;  // допустимый вес
    private List<Item> insideItems;   // что содержит

    // Конструктор по умолчанию
    public Box() {
        super ("Стандартная коробка", 1.0, true, true);
        this.allowadlWeight = 20.0;
        this.insideItems = new ArrayList<Item>();
    }

    // Конструктор со всеми параметрами
    public Box(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, double allowadlWeight) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowadlWeight = allowadlWeight;
        this.insideItems = new ArrayList<Item>();
        }

    // Конструктор без мноества
    public Box(String name, double weight, boolean flat, boolean bigSize, double allowadlWeight) {
        super(name, weight, flat, bigSize);
        this.allowadlWeight = allowadlWeight;
        this.insideItems = new ArrayList<Item>();
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

        if (!(item instanceof Box)) {  //  это не коробка?
            if (!item.packed){      // предмет уже упакован?
               if (!item.bigSize) {     // предмет влазит в коробку?
                    double weigthMax = 0.0;  //  коробка выдержит?
                    for (Item i : insideItems) {
                        weigthMax = weigthMax + i.weight;
                    }
                    if ((weigthMax + item.weight) <= this.allowadlWeight) {   // упаковываем предмет
                        insideItems.add(item);
                        item.packed = true;
                    } else System.out.println("Максимально разрешенный вес " + this.name + " превышен");
                } else System.out.println("этот предмет слишком большой, попробуйте воспользоватся мешком.");
            } else System.out.println("что бы переупаковать предмет, сперва его надо достать");
        } else System.out.println("Нельзя упаковать коробку в коробку!");
        }

    public void getItem(Item item) {
        if (!this.insideItems.isEmpty()) {  // а не пусто ли?
            if (insideItems.contains(item)) {   // а может предмета здесь нет?
                insideItems.remove(item);
                item.packed = false;
            } else System.out.println("данного предмета здесть нет!");
        }
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

    public List<Item> getInsideItems() {
        return insideItems;
    }

    public void setInsideItems(List<Item> insideItems) {

        this.insideItems = insideItems;

    }
}
