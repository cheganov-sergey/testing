import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 *  реализация стопки через Стек
 */

public class Stacked extends Item implements PutGetItem {

    private int allowedSize;
    private Stack<Item> insideItems;

   public Stacked(){
       super("Стопка (S)", 0.0, false, true);
       this.allowedSize = 10;
       this.insideItems = new Stack<Item>();
   }

    /**
     * Конструктор с мин. кол-вом параметров
     * @param allowedSize разрешенное количство предметов в стопке
     */
    public Stacked(int allowedSize) {
        super("Стопка", 0.0, false, true);
        this.allowedSize = allowedSize;
        this.insideItems = new Stack<Item>();
    }

    public Stacked(String name, double weight, boolean flat, boolean bigSize, int allowedSize) {
        super(name, weight, flat, bigSize);
        this.allowedSize = allowedSize;
        this.insideItems = new Stack<Item>();
    }

    public Stacked(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, int allowedSize) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowedSize = allowedSize;
        this.insideItems = new Stack<Item>();
    }

    /**
     * метод - добавить предмет в стопку
     * @param item  предмет который мы добавляем
     */
    public void putItem(Item item) {
        if (!(item instanceof Stacked)) {   //это стопка?
            if (item.isFlat()) {                // можно складировать стопкой?
                if (this.insideItems.size() < this.allowedSize) {   // влезет?
                    this.insideItems.push(item);
                    item.setPacked(true);
                } else System.out.println("Размер стопки достиг максимального значения");
            } else System.out.println("Этот предмет нельзя складировать стопклй!");
        } else System.out.println("Нельзя поместить стопку в стопку");
    }

    /**
     * не возможно получить произвольный предмет
     * @param item
     */
    @Override
    public void getItem(Item item) {
        System.out.println("Ошибка!");
    }

    /**
     * метод - получить верхний предмет из стопки
     */
    public void getItem(){  //Забрать верхний элемент из стопки
       if (!this.insideItems.empty()) {
           this.insideItems.peek().setPacked(false);
           this.insideItems.pop();
       }
   }

     /**
     * метод - показать верхний предмет
     */
    public void showItem() {                   // должен возвращать верхний предмет из стопки.
        if (!this.insideItems.empty()){
             this.insideItems.peek();
            }
        }

    /**
     * Метод возвращающий вес стопки (Не работает!)
      * @return вес стопки в кг.
     */
    public double getCurrentweigth() {
        return 0;
    }

    @Override
    public String toString() {
        return "Стопка: "+ getName() +" {" +
                " разрешенный вес:" + allowedSize +
                ", insideItems=" + insideItems +
                ", вес:=" + getWeight() +
                ", дополнительно: " + getOtherCharacters() +
                '}';
    }

    public Stack<Item> getInsideItems() {
        return insideItems;
    }
}