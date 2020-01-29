import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Класс "Стопка" служит для хранения пердметов
 * реализация через LinkedList
 */
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

    /**
     *
     * @param name имя предмета
     * @param weight    вес предметка в кг.
     * @param flat  можно ли складировать стопокй
     * @param bigSize тру -не влезит в коробку
     * @param allowedSize - допустимый вес
     */
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
                "" + getName() +
                " высотоа: " + getCurrentweigth() +
                " из " + allowedSize +
                ", содержит: " + insideItems +
                ", otherCharacters=" + getOtherCharacters() +
                '}';
    }

    // Реализация интерфейса PutGetItem --

    /**
     * метод - положить предмет на верх стопки
     * @param item предмет который кладем
     */
    public void putItem(Item item) {
        if (!(item instanceof StackedLinkList)){
            if (!item.isPacked()){   // пердмет запакован?
                if (this.insideItems.size() < this.allowedSize) {
                    this.insideItems.addLast(item);
                    item.setPacked(true);
                } else System.out.println ("Превышен разрешенный размер стопки!");
            } else System.out.println("Данный предмет уже упакован!");
        } else System.out.println(" ");
    }

    /**
     * метод - получить указанный предмет
     * @param item  предмет который хотим получить
     */
    public void getItem(Item item) {
        if (!this.insideItems.isEmpty()){
            int i = this.insideItems.indexOf(item);
            System.out.println(this.insideItems.get(i));
            this.insideItems.remove();
            this.setPacked(false);
        }
    }

    /**
     * просмотр содержимого стопки
     */
    public void showItem() {
        System.out.println(getName() + " высотой " + getCurrentweigth() + ", здесть находится:");
        if (!this.insideItems.isEmpty()) {
            for (Item item : this.insideItems){
                System.out.println(item);
            }
        }
        else System.out.println("здесь пусто!");

    }

    /**
     * метод - узнать количество предметов в стопке
     * @return количество предметов встопке
     */
    public double getCurrentweigth() {            //здесь возвращает размер стопки
        int size = this.insideItems.size();
        return size;
    }
    // -- Реализация интерфейса PutGetItem
}
