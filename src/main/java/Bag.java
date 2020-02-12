import java.util.ArrayList;

/**
 * Класс - мешок
 */
public class Bag extends Box {

    public Bag() {

        super("Мешок", 1.0, false, true, 50.0);
        super.insideItems = new ArrayList<>();
    }

    /**
     * полжить предмет
     * @param item предмет который мы хотм положить в мешок
     */
    @Override
    public void putItem(Item item) throws CaseExсeption{

        if (!(item.equals(this))) {  //  //нельзя упаковаться само в себя
            if (!item.isPacked()){      // предмет уже упакован?
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
    }

}