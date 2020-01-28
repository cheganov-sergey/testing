import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

// реализация стопки через Стек

public class Stacked extends Item implements PutGetItem {

    private int allowedSize;
    private Stack<Item> insideItems;

   public Stacked(){
       super("Стопка (S)", 0.0, false, true);
       this.allowedSize = 10;
       this.insideItems = new Stack<Item>();
   }

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

    public void putItem(Item item) {
        if (!(item instanceof Stacked)) {   //это стопка?
            if (item.flat) {                // можно складировать стопкой?
                if (this.insideItems.size() < this.allowedSize) {   // влезет?
                    this.insideItems.push(item);
                    item.packed = true;
                } else System.out.println("Размер стопки достиг максимального значения");
            } else System.out.println("Этот предмет нельзя складировать стопклй!");
        } else System.out.println("Нельзя поместить стопку в стопку");
    }

    public void getItem(){  //Забрать верхний элемент из стопки
       if (!this.insideItems.empty()) {
           this.insideItems.peek().packed = false;
           this.insideItems.pop();
       }
   }

    public void getItem(Item item) { // забрать указанный элемент (Не работает!!!)
       int it = -1;
       it = this.insideItems.search(item);
        if ( it > 0 ) {
            Stack<Item> s = new Stack<Item>();
            Iterator<Item> iterator = insideItems.iterator();
            for (int i = 1; i <= it; i++){
                s.push(iterator.next());
                }
            System.out.println(iterator.next());
            iterator.remove();
            s.clear();
           // for (Item items : s){
            //    this.insideItems.push(items);
           // }
        }

    }

    public void showItem() {                   // должен возвращать верхний предмет из стопки.
        if (!this.insideItems.empty()){
             this.insideItems.peek();
            }
        }

    public double getCurrentweigth() {
        return 0;
    }

    @Override
    public String toString() {
        return "Стопка: "+ name +" {" +
                " разрешенный вес:" + allowedSize +
                ", insideItems=" + insideItems +
                ", вес:=" + weight +
                ", дополнительно: " + otherCharacters +
                '}';
    }
}