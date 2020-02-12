import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * класс "Коробка" служит для хранения пердметов
 */

public class Box extends Item implements PutGetItem {

    /**
     * @param allowWeigth - допустимый вес
     * @param insideItems - что содержит данный кейс
     */
    protected final double allowedlWeight;  // допустимый вес
    protected List<Item> insideItems;   // что содержит

    // Конструктор по умолчанию
    public Box() {
        super ("Стандартная коробка", 1.0, true, true);
        this.allowedlWeight = 30.0;
        this.insideItems = new ArrayList<>();
    }

    // Конструктор со всеми параметрами
    public Box(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, double allowadlWeight) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowedlWeight = allowadlWeight;
        this.insideItems = new ArrayList<>();
        }

    // Конструктор без множества
    public Box(String name, double weight, boolean flat, boolean bigSize, double allowadlWeight) {
        super(name, weight, flat, bigSize);
        this.allowedlWeight = allowadlWeight;
        this.insideItems = new ArrayList<>();
    }



    @Override
    public String toString() {
        return "Коробка " + this.getName() + " {" +
                " содержит:" + insideItems +
                "весом: " + getCurrentweigth() + "кг." +
                ", плоский:" + this.isFlat() +
                ", большой:" + this.isBigSize() +
                ", другие параметры:" + getOtherCharacters() +
                ", грузоподъемность:" + allowedlWeight +
                '}';
    }

    // Реализация интерфейса GetPutItem ---

    /**
     * положить предмет в коробку
     * @param item предмет который мы хотм положить в коробку
     * @throws CaseExсeption в случае если коробка порвется от перегруза
     */
    @Override
    public void putItem(Item item) throws CaseExсeption{

        if (!(item.equals(this))) {  //  //нельзя упаковаться само в себя
            if (!item.isPacked()){      // предмет уже упакован?
               if (!item.isBigSize()) {     // предмет влазит в коробку?
                    double weigthMax = 0.0;  //  коробка выдержит?
                    for (Item i : insideItems) {
                        weigthMax = weigthMax + i.getWeight();
                    }
                    if ((weigthMax + item.getWeight()) <= this.allowedlWeight) {   // упаковываем предмет
                        insideItems.add(item);
                        item.setPacked(true);
                    } else throw new CaseExсeption("Максимально разрешенный вес " + this.getName() + " превышен");
                } else System.out.println("этот предмет слишком большой, попробуйте воспользоватся мешком.");
            } else System.out.println("что бы переупаковать предмет, сперва его надо достать");
        } else System.out.println("Нельзя упаковать коробку в коробку!");
        }

    /**
     * получение указанного предмета
     * @param item предмет который мы хотим достать из коробки
     */
    @Override
    public void getItem(Item item) {
        if (!this.insideItems.isEmpty()) {  // а не пусто ли?
            if (insideItems.contains(item)) {   // а может предмета здесь нет?
                insideItems.remove(item);
                item.setPacked(false);
            } else System.out.println("данного предмета здесть нет!");
        }
    }

    /**
     * Вывести список предметов в алфавитном порядке (то что содержится в коробке
     * реализация через Стрим
     */
    @Override
      public void showItem(){
          if(!this.insideItems.isEmpty()){
              System.out.println(this.name + "содержит: ");
              List<Item> byName = insideItems.stream().
                      sorted(Comparator.comparing(Item::getName)).
                      collect(Collectors.toList());
              byName.forEach(System.out::println);
          }
      }
//
    /**
     * Получить текущий вес коробки
     * @return возвращает суммарный вес тары и предметов в ней
     */
    @Override
    public double getCurrentweigth() {
        double currentWeigth = this.getWeight();
        for(Item it : insideItems) {
            currentWeigth = currentWeigth + it.getWeight();
        }
        return currentWeigth;
    }

    // --- Реализация интерфейса GetPutItem завершена


    /**
     * Получить случайный предмет из коробки
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

    /**
     * узнать общий вес
     * @return текущий вес тары и содержимого в кг.
     */
    public double getAllowadlWeight() {
        return allowedlWeight;
    }

    /**
     * содержимое коробки
     * @return список предметов
     */
    public List<Item> getInsideItems() {
        return insideItems;
    }

    /**
     * Достать предмет по имени
     * @param name имя искомого предмета
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
}
