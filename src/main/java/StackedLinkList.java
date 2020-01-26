import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Класс "Стопка" служит для хранения пердметов

public class StackedLinkList extends Item implements PutGetItem {

    private int allowedSize;                           // доустимая высота стопки
    private LinkedList<Item> insideItems;               // что содержит


    public StackedLinkList(){
        super("Стопка (LL)", 0.0, false, true);
        this.allowedSize = 5;
        this.insideItems = new LinkedList<Item>();
    }

    public StackedLinkList(int allowedSize) {
        super();
        this.allowedSize = allowedSize;
        this.insideItems = new LinkedList<Item>();
    }

    public StackedLinkList(String name, double weight, boolean flat, boolean bigSize, int allowedSize) {
        super(name, weight, flat, bigSize);
        this.allowedSize = allowedSize;
        this.insideItems = new LinkedList<Item>();
    }

    public StackedLinkList(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters, int allowedSize) {
        super(name, weight, flat, bigSize, otherCharacters);
        this.allowedSize = allowedSize;
        this.insideItems = new LinkedList<Item>();
    }

    @Override
    public String toString() {
        return "StackedLinkList {" +
                "" + name +
                " высотоа: " + getCurrentweigth() +
                " из " + allowedSize +
                ", содержит: " + insideItems +
                ", otherCharacters=" + otherCharacters +
                '}';
    }

    // Реализация интерфейса PutGetItem --

    public void putItem(Item item) {

        if (!this.insideItems.contains(item)) {
            try {
                if (this.insideItems.size() < this.allowedSize)
                    this.insideItems.addLast(item);
                else System.out.println("Превышен разрешенный размер стопки!");
            } catch (NullPointerException e) {
                System.out.println("проверьте правильность созданной стопки");
            }
        }
        else System.out.println("Данный предмет здесь уже есть!");
    }

    public void getItem(Item item) {
        if (!this.insideItems.isEmpty()){
            int i = this.insideItems.indexOf(item);
            System.out.println(this.insideItems.get(i));
            this.insideItems.remove();
        }

    }

    public void showItem() {
        System.out.println(name + " высотой " + getCurrentweigth() + ", здесть находится:");
        if (!this.insideItems.isEmpty()) {
            for (Item item : this.insideItems){
                System.out.println(item);
            }
        }
        else System.out.println("здесь пусто!");

    }

    public double getCurrentweigth() {            //здесь возвращает размер стопки
        int size = this.insideItems.size();
        return size;
    }

    // -- Реализация интерфейса PutGetItem
}
