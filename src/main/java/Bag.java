import java.util.*;

/**
 * Класс "Мешок" служит для хранения пердметов
 */

public class Bag extends Item implements PutGetItem {

    private double allowedWeigth;   // допустимый вес
    private List<Item> insideItems;   // что содержит

   public Bag(){
        super ("стандартный мешок", 0.5, false, true);
        this.allowedWeigth = 50.0;
        this.insideItems = new ArrayList<Item>();
    }

    /**
     * конструктор
     * @param allowedWeigth допустимый вес
     * @param insideItems какие предметы содержит данный мешок
     */
    public Bag(double allowedWeigth, Set<Item> insideItems) {
        this.allowedWeigth = allowedWeigth;
        this.insideItems = new ArrayList<Item>();
    }

    public Bag(String name, double weight, boolean flat, boolean bigSize, double allowedWeigth, Set<Item> insideItems) {
        super(name, weight, flat, bigSize);
        this.allowedWeigth = allowedWeigth;
        this.insideItems = new ArrayList<Item>();
    }

    public Bag(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, double allowedWeigth, Set<Item> insideItems) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowedWeigth = allowedWeigth;
        this.insideItems = new ArrayList<Item>();
    }

    // Реализация итерфейса --

    /**
     * положить предмет в мешок
     * @param item предмет который мы хотим положить в мешок
     * @throws CaseExсeption в случае если мешок порвется
     */
    public void putItem(Item item) throws CaseExсeption{
        if (!(item instanceof Bag) & !(item instanceof Box)) {       // нельзя упаковать мешок в мешок или коробку
            if (!item.isPacked()) {                                      // предмет уже упакован?
                double weigthMax = 0.0;
                for (Item i : insideItems) {
                    weigthMax = weigthMax + i.getWeight();                  //вес мешка с предметами
                }
                if ((weigthMax + item.getWeight()) <= this.allowedWeigth) {  // мешок выдержит?
                    insideItems.add(item);
                    item.setPacked(true);
                }
                else {
                    throw new CaseExсeption("Максимально разрешенный вес " + this.getName() + " превышен");
                }
            } else System.out.println("что бы переупаковать предмет, сперва его надо достать");
        }else System.out.println("Нельзя упаковать мешок в мешок или коробку");
    }

    /**
     * Метод - достать предмет
     * @param item предмет который мы хотим достать
     */
    public void getItem(Item item) {
        if (!this.insideItems.isEmpty()) {  // а не пусто ли?
            if (insideItems.contains(item)) {   // а может предмета здесь нет?
                insideItems.remove(item);
                item.setPacked(false);
            } else System.out.println("данного предмета здесть нет!");
        }
    }

    /**
     * метод - посмотреть что содержит мешок
     */
    public void showItem() {
        if (!this.insideItems.isEmpty()) {
            System.out.println(getName() + " весом "
                    + getCurrentweigth()
                    + ", здесть находится:");
            for (Item it : insideItems)
                System.out.println(it);
        }
        else System.out.println("здесь пусто!");
    }

    /**
     * метод - узнать текущий вес мешка
     * @return сумма веса предметов в мешке + вес самого мешка
     */
    public double getCurrentweigth() {
        double currentWeigth = this.getWeight();
        for(Item it : insideItems) {
            currentWeigth = currentWeigth + it.getWeight();
        }
        return currentWeigth;
    }

    // -- Реализация итерфейса

    /**
     * получить предмет по названию
     * @param name имя предмета в формате String
     */
    public void getByName (String name){        // не понял как добавить флаг "packed"
        if (!this.insideItems.isEmpty()) {
            Iterator<Item> iterator = this.insideItems.iterator();
            while (iterator.hasNext()) {
                Item it = iterator.next();
                if (it.getName().equals(name)) {
                    System.out.println("Мы взяли " + it.getName());
                    iterator.remove();
                }
            }
        }
    }

    /**
     * Получить случайный предмет из мешка
     */
    public void getRandom(){        //  получить случайный предмет
        if (!this.insideItems.isEmpty()){
            Random random = new Random();
            int i = random.nextInt(this.insideItems.size());
            System.out.println("Случайно вытащили " + this.insideItems.get(i));
            this.insideItems.get(i).setPacked(false);
            this.insideItems.remove(i);
        }
    }

    @Override
    public String toString() {
        return "Мешок {" + getName() +
                " допустимый вес:" + allowedWeigth +
                ", содержит предметы:" + insideItems +
                " весом: " + getCurrentweigth() + " кг. " +
                ", плоский:" + isFlat() +
                ", большой размер:" + isBigSize() +
                ", другие параметры:" + getOtherCharacters() +
                '}';
    }

}
