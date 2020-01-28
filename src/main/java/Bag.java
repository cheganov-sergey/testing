import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
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
        if (!(item instanceof Bag) & !(item instanceof Box)) {      // нельзя упаковать мешок в мешок или коробку
            if (!item.packed) {     // предмет уже упакован?
                double weigthMax = 0.0;
                for (Item i : insideItems) {
                    weigthMax = weigthMax + i.weight;   //вес мешка с предметами
                }
                if ((weigthMax + item.weight) <= this.allowedWeigth) {  // мешок выдержит?
                    insideItems.add(item);
                    item.packed = true;

                } else System.out.println("Максимально разрешенный вес " + this.name + " превышен");
            } else System.out.println("что бы переупаковать предмет, сперва его надо достать");
        }else System.out.println("Нельзя упаковать мешок в мешок или коробку");
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

    // -- Реализация итерфейса

    public void getByName (String name){        // не понял как добавить флаг "packed"
        if (!this.insideItems.isEmpty()) {
            Iterator<Item> iterator = this.insideItems.iterator();
            while (iterator.hasNext()) {
                Item it = iterator.next();
                if (it.name.equals(name)) {
                    System.out.println("Мы взяли " + it.name);
                    iterator.remove();
                }
            }
        }
    }

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
