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
       super("Стопка (S)", 0.0, true, true);
       this.allowedSize = 10;
       this.insideItems = new Stack<>();
   }

    /**
     * Конструктор с мин. кол-вом параметров
     * @param allowedSize разрешенное количство предметов в стопке
     */
    public Stacked(int allowedSize) {
        super("Стопка", 0.0, false, true);
        this.allowedSize = allowedSize;
        this.insideItems = new Stack<>();
    }

    public Stacked(String name, double weight, boolean flat, boolean bigSize, int allowedSize) {
        super(name, weight, flat, bigSize);
        this.allowedSize = allowedSize;
        this.insideItems = new Stack<>();
    }

    public Stacked(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, int allowedSize) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowedSize = allowedSize;
        this.insideItems = new Stack<>();
    }

    /**
     * метод - добавить предмет в стопку, можно переложить одну стопку в бругую
     * @param item  предмет который мы добавляем
     */
    public void putItem(Item item) {
        if (!(item.equals(this))) {   //Нельзя положить предмет сам в себя
            if (item.isFlat()) {                // можно складировать стопкой?
                if (item instanceof Stacked) {   // стопка на стопку ?
                    if ((this.insideItems.size() + ((Stacked) item).insideItems.size()) < this.allowedSize) {   //если суммарный размер стопок допустим
                        while (!(((Stacked) item).insideItems.empty())) {   // прекидываем предметы из одной стопки в другую
                            this.insideItems.push(((Stacked) item).insideItems.pop());
                        }
                    } else System.out.println("Максимальный размер стопки превышен");

                } else {                                                    // другой предмет (не стопка)
                    if (this.insideItems.size() < this.allowedSize) {   // влезет?
                        this.insideItems.push(item);
                        item.setPacked(true);
                    } else System.out.println("Размер стопки достиг максимального значения");
                }
            } else System.out.println("Этот предмет нельзя складировать стопклй!");
        } else System.out.println("Нельзя положить предмет сам в себя");
    }

    /**
     * не возможно получить произвольный предмет (метод для реализации интерфейса)
     * @param item - предмет
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