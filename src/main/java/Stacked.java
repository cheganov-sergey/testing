import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

// Данный класс не работает полностью! (нельза получить произволдьный элемент стека)
// не разобрался до конца как сделать, допишу позже, а пока см. StackedLinkList

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
        if (item.flat)
            if (this.insideItems.size() < this.allowedSize) {
                this.insideItems.push(item);}
                else System.out.println("Размер стопки достиг максимального значения");
            else System.out.println("Этот предмет нельзя складировать стопклй!");
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