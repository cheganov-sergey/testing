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
    private final double allowadlWeight;  // допустимый вес
    private List<Item> insideItems;   // что содержит

    // Конструктор по умолчанию
    public Box() {
        super ("Стандартная коробка", 1.0, true, true);
        this.allowadlWeight = 30.0;
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
        return "Коробка " + this.getName() + " {" +
                " содержит:" + insideItems +
                "весом: " + getCurrentweigth() + "кг." +
                ", плоский:" + this.isFlat() +
                ", большой:" + this.isBigSize() +
                ", другие параметры:" + getOtherCharacters() +
                ", грузоподъемность:" + allowadlWeight +
                '}';
    }

    // Реализация интерфейса GetPutItem ---

    /**
     * положить предмет в коробку
     * @param item предмет который мы хотм положить в коробку
     * @throws CaseExсeption в случае если коробка порвется от перегруза
     */
    public void putItem(Item item) throws CaseExсeption{

        if (!(item instanceof Box)) {  //  это не коробка?
            if (!item.isPacked()){      // предмет уже упакован?
               if (!item.isBigSize()) {     // предмет влазит в коробку?
                    double weigthMax = 0.0;  //  коробка выдержит?
                    for (Item i : insideItems) {
                        weigthMax = weigthMax + i.getWeight();
                    }
                    if ((weigthMax + item.getWeight()) <= this.allowadlWeight) {   // упаковываем предмет
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
      public void showItem(){
          if(!this.insideItems.isEmpty()){
              System.out.println("Коробка содержит: ");
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

    public double getCurrentweigth() {
        double currentWeigth = this.getWeight();
        for(Item it : insideItems) {
            currentWeigth = currentWeigth + it.getWeight();
        }
        return currentWeigth;
    }

    /**
     * --- Реализация интерфейса GetPutItem
      */

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


   }
